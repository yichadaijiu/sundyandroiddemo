package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class BaseTweenAnimationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tweenanimation)  ;
		
		ImageView imageViewAlpha = (ImageView)findViewById(R.id.imageViewAlphaAnimation)  ;
		imageViewAlpha.setOnClickListener(new ImageViewListener(ImageAnimationType.ImageViewAlphaAnimation))  ;
		ImageView imageViewRotate = (ImageView)findViewById(R.id.imageViewRotateAnimation)  ;
		imageViewRotate.setOnClickListener(new ImageViewListener(ImageAnimationType.ImageViewRotateAnimation)) ;
		ImageView imageViewScale = (ImageView)findViewById(R.id.imageViewScaleAnimation)  ;
		imageViewScale.setOnClickListener(new ImageViewListener(ImageAnimationType.ImageViewScaleAnimation)) ;
		ImageView imageViewTranslate = (ImageView)findViewById(R.id.imageViewTranslateAnimation)  ;
		imageViewTranslate.setOnClickListener(new ImageViewListener(ImageAnimationType.ImageViewTranslateAnimation)) ;
	}
	
	enum ImageAnimationType
	{
		ImageViewAlphaAnimation,
		ImageViewRotateAnimation,
		ImageViewScaleAnimation,
		ImageViewTranslateAnimation
	}
	
	class ImageViewListener implements OnClickListener
	{
		private ImageAnimationType animationType ;
		public ImageViewListener(ImageAnimationType aniType)
		{
			animationType = aniType ;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (animationType) {
			case ImageViewAlphaAnimation:
				AlphaAnimation _Animation = new AlphaAnimation(1f, 0.1f)  ;
				_Animation.setDuration(2000)  ;
				_Animation.setRepeatMode(AlphaAnimation.REVERSE)  ;				
				v.startAnimation(_Animation)  ;
				break;
			case ImageViewRotateAnimation:
				RotateAnimation _Animation3 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)  ;
				_Animation3.setDuration(2000) ;
				_Animation3.setRepeatCount(5)  ;
				v.startAnimation(_Animation3) ;
				break ;
			case ImageViewScaleAnimation:
				ScaleAnimation _Animation2 = new ScaleAnimation(1, 1.5f, 1, 1.5f, 0.5f,0.5f)  ;
				
				_Animation2.setDuration(2000)  ;
				_Animation2.setFillAfter(false) ;
				v.startAnimation(_Animation2) ;
				break ;
			case ImageViewTranslateAnimation:
				TranslateAnimation _Animation4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1, 
						Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1) ;
				_Animation4.setDuration(2000) ;
				_Animation4.setFillAfter(true) ;
				_Animation4.setRepeatCount(3) ;
				v.startAnimation(_Animation4) ;
				break ;
			default:
				break;
				
			
			}
		}
		
	}

}
