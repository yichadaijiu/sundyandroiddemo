package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class BaseFrameAnimation extends Activity {

	AnimationDrawable _AnimationDrawable ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_frameanimation)  ;
		ImageView rocketImage = (ImageView)findViewById(R.id.imageViewFrameAnimation)  ;
		Button _buttonFrame = (Button)findViewById(R.id.buttonShowFrameAni)  ;		
		rocketImage.setBackgroundResource(R.drawable.imageanim)  ;
		_AnimationDrawable = (AnimationDrawable)rocketImage.getBackground()  ;
		_buttonFrame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				_AnimationDrawable.start()  ;
			}
		})  ;
		
	}

}
