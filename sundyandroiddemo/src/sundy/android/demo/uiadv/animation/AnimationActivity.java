package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

public class AnimationActivity extends Activity {

    private static final String TAG = "AnimationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animation);
        Button btn = (Button) findViewById(android.R.id.button1);
        btn.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Animation anim = new TranslateAnimation(0, 10, 0, 0);
                anim.setDuration(1000);
                anim.setInterpolator(new CycleInterpolator(7));
                anim.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.i(TAG, "animation start.");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.i(TAG, "animation end.");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.i(TAG, "animation repeat.");
                    }
                });

                v.startAnimation(anim);
            }});
    }

}
