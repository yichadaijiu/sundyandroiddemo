package sundy.android.demo.uiadv.shake_desk;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class ItemMover extends FrameLayout
{
    private OnImageMovedListener mOnImageMovedListener = null;

    LayoutParams  mCurrentLayout = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

    public ItemMover(Context context)
    {
        super(context);
    }

    public ItemMover(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setOnImageMoveListener(OnImageMovedListener l)
    {
        mOnImageMovedListener = l;
    }

    public void startMove(View v)
    {
        if (v == null)
        {
            return;
        }

        setVisibility(View.VISIBLE);
        removeAllViews();

        v.setVisibility(View.INVISIBLE);
        v.clearAnimation();
        addView(v);

        if (mOnImageMovedListener != null)
        {
            mOnImageMovedListener.onMoveStart(v);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        View v = getChildAt(0);
        if (v == null) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // mDrawing = true;
                break;
            case MotionEvent.ACTION_UP:
                // mDrawing = false;
                if (getVisibility() == VISIBLE) {
                    setVisibility(GONE);
                    if (mOnImageMovedListener != null) {
                        mOnImageMovedListener.onMoveEnd(v);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            default:
                break;
        }
        if (getVisibility() == VISIBLE) {
            v.setVisibility(View.VISIBLE);

            float x = event.getX() - 32;
            float y = event.getY() - 32;

            mCurrentLayout.setMargins((int)x, (int)y, 0, 0);
            updateViewLayout(v, mCurrentLayout);
            mOnImageMovedListener.onMoving(v, x, y);
            return true;
        } else {
            mCurrentLayout.setMargins(0, 0, 0, 0);
            return false;
        }
    }

    public interface OnImageMovedListener {
        public void onMoveStart(View v);
        public void onMoving(View v, float x, float y);
        public void onMoveEnd(View v);
    }

}
