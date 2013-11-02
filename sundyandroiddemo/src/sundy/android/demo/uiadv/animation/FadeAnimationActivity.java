package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class FadeAnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delay_load);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Intent intent=new Intent(this, getClass());
            startActivity(intent);
            overridePendingTransition(R.anim.zoomout, R.anim.zoomin);
            finish();
        }
        return super.onTouchEvent(event);
    }
}
