package sundy.android.demo.uiadv.performance;

import sundy.android.demo.R;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class FastSwitchActivity extends Activity {

    private View mLandView;
    private View mPortView;


    private SeekBar  mSeekBar;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.fast_switch);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        setOrientationLayout(display.getOrientation());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        setOrientationLayout(newConfig.orientation);

    }

    private void setOrientationLayout(int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (mLandView == null) {
                ViewStub landStub = (ViewStub) findViewById(R.id.stub_land);
                mLandView = landStub.inflate();
            }
            if (mPortView != null) {
                mPortView.setVisibility(View.GONE);
            }

            bindView(mLandView);
        } else {

            if (mPortView == null) {
                ViewStub portStub = (ViewStub) findViewById(R.id.stub_port);
                mPortView = portStub.inflate();
            }
            if (mLandView != null) {
                mLandView.setVisibility(View.GONE);
            }

            bindView(mPortView);
        }
    }

    private void bindView(View v) {
        v.setVisibility(View.VISIBLE);
        mSeekBar = (SeekBar) findViewById(android.R.id.progress);
        mTextView = (TextView) findViewById(android.R.id.text1);
    }

}
