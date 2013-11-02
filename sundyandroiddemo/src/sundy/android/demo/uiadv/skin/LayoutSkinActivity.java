package sundy.android.demo.uiadv.skin;

import sundy.android.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LayoutSkinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_skin1);
        bindView();
    }

    private void bindView() {
        Button btn1 = (Button) findViewById(android.R.id.button1);
        Button btn2 = (Button) findViewById(android.R.id.button2);

        btn1.setOnClickListener(new SkinButtonOnClickListener(R.layout.layout_skin1));
        btn2.setOnClickListener(new SkinButtonOnClickListener(R.layout.layout_skin2));
    }

    private class SkinButtonOnClickListener implements OnClickListener {

        private final int mLayoutId;
        public SkinButtonOnClickListener(int layoutId) {
            mLayoutId = layoutId;
        }

        @Override
        public void onClick(View v) {
            setContentView(mLayoutId);
            bindView();
        }

    }
}

