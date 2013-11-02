package sundy.android.demo.uiadv.shake_desk;

import sundy.android.demo.R;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class ApplicationInfoContainer extends ItemContainer<ResolveInfo> {

    public ApplicationInfoContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.myAttr);
        int numColumns = a.getInt(R.styleable.myAttr_numColumns, 0);
        if (numColumns > 0) {
            setNumColumns(numColumns);
        }
    }
}
