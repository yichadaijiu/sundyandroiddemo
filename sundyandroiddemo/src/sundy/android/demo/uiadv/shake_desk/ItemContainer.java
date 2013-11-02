package sundy.android.demo.uiadv.shake_desk;

import sundy.android.demo.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class ItemContainer<T> extends FrameLayout implements AdapterView.OnItemLongClickListener,
        View.OnTouchListener, ItemMover.OnImageMovedListener
{

    private GridView             mGridView      = null;
    private ItemMover           mItemMover     = null;
    private ItemContainerAdapter<T> mAdapter   = null;

    public ItemContainer(Context context)
    {
        this(context, null);
    }

    public ItemContainer(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public ItemContainer(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
    }

    private void init()
    {
        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

        mGridView = new GridView(getContext());
        mGridView.setGravity(Gravity.CENTER);
        mGridView.setNumColumns(4);
        addView(mGridView, lp);

        mItemMover = new ItemMover(getContext());
        addView(mItemMover, lp);

        mGridView.setOnItemLongClickListener(this);
        mGridView.setOnTouchListener(this);
        mItemMover.setOnImageMoveListener(this);
    }

    protected void setNumColumns(int num) {
        mGridView.setNumColumns(num);
    }

    public void setAdapter(ItemContainerAdapter<T> adapter)
    {
        mAdapter = adapter;
        mGridView.setAdapter(adapter);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mGridView.setOnItemClickListener(listener);
    }

    public ItemContainerAdapter<T>  getAdapter()
    {
        return mAdapter;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View b, int pos,
            long id)
    {
        mAdapter.setHideItem(pos);
        View v = mAdapter.createSuspensionView(pos);
        mItemMover.startMove(v);
        return true;
    }

    @Override
    public void onMoveStart(View v)
    {
        mGridView.invalidateViews();
    }

    @Override
    public void onMoving(View v, float x, float y)
    {
        int targetPos = mGridView.pointToPosition((int) x, (int) y);
        int hiddenPos = mAdapter.getHideItemPosition();
        if (hiddenPos != targetPos && targetPos >= 0)
        {
            if (mAdapter.swap(hiddenPos, targetPos))
            {
                mAdapter.setHideItem(targetPos);
                refreshItem(targetPos);
                onItemMoved(refreshItem(hiddenPos), hiddenPos, targetPos);
            }
        }
    }

    @Override
    public void onMoveEnd(View v)
    {
        mAdapter.unhideAllItem();
        mGridView.invalidateViews();
    }


    protected void onItemMoved(final View v, int oldPos, int newPos)
    {
        int oldCol = oldPos % 5;
        int oldRow = oldPos / 5;

        int newCol = newPos % 5;
        int newRow = newPos / 5;

        int w = v.getWidth();
        int h = v.getHeight();

        TranslateAnimation anim = new TranslateAnimation((newCol - oldCol) * w, 0.0f, (newRow - oldRow) * h, 0.0f);
        anim.setDuration(300);
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation animation)
            {
                Animation mainAnim = AnimationUtils.loadAnimation(getContext(),
                        R.anim.shake);
                v.setAnimation(mainAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
            }

            @Override
            public void onAnimationStart(Animation animation)
            {
            }});

        v.setAnimation(anim);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        mItemMover.onTouchEvent(event);
        return v.onTouchEvent(event);
    }

    private View refreshItem(int position)
    {
        int firstPos = mGridView.getFirstVisiblePosition();
        int lastPos = mGridView.getLastVisiblePosition();
        if (position >= firstPos && position <= lastPos )
        {
            View v = mGridView.getChildAt(position - firstPos);
            mAdapter.bindView(v, position);
            return v;
        }
        return null;
    }

}
