package sundy.android.demo.uiadv.shake_desk;

import sundy.android.demo.R;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Random;

public abstract class ItemContainerAdapter<T> extends BaseAdapter
{

    private Context        mContext    = null;
    protected List<T>        mItemList    = null;
    private int            mHiddenPosition   = -1;


    private final Random mRandom = new Random(SystemClock.currentThreadTimeMillis());

    public ItemContainerAdapter(Context c, List<T> list)
    {
        mContext = c;
        mItemList = list;
    }

    public void setHideItem(int pos)
    {
        int size = getCount();
        if (pos >= 0 && pos < size)
        {
            mHiddenPosition = pos;
        }
    }

    public int getHideItemPosition()
    {
        return mHiddenPosition;
    }

    public void unhideAllItem()
    {
        mHiddenPosition = -1;
    }

    public boolean swap(int a, int b)
    {
        if (a == b)
        {
            return false;
        }
        if (a < 0 || b < 0)
        {
            return false;
        }
        int size = getCount();
        if (a >= size || b >= size)
        {
            return false;
        }
        T t = mItemList.get(a);
        mItemList.set(a, mItemList.get(b));
        mItemList.set(b, t);
        return true;
    }

    public int getCount()
    {
        return mItemList.size();
    }

    @Override
    public T getItem(int position)
    {
        return mItemList.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    abstract protected View onCreateItemView(int position, ViewGroup parent);

    abstract public void onBindView(View v, int position);

    abstract public void onHideView(View v);

    public final void bindView(View v, int position) {
        if (position == mHiddenPosition) {
            onHideView(v);
        } else {
            v.setVisibility(View.VISIBLE);
            v.clearAnimation();
            onBindView(v, position);
        }
    }

    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = onCreateItemView(position, parent);
        }

        bindView(convertView, position);

        if (mHiddenPosition >= 0 && position != mHiddenPosition) {
            Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.shake);
            anim.setStartOffset(mRandom.nextInt() % anim.getDuration());
            convertView.startAnimation(anim);
        } else {
            convertView.clearAnimation();
        }
        return convertView;
    }

    public final View createSuspensionView(int position) {
        View v = onCreateItemView(position, null);
        onBindView(v, position);
        return v;
    }
}
