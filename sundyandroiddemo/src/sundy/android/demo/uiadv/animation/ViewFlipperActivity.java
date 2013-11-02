package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {

	ViewFlipper viewFlipper ;
	GestureDetector gestureDetector ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		gestureDetector = new GestureDetector(this)  ;
		setContentView(R.layout.layout_viewflipper)  ;
		viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1)  ;
		
		
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//一定要加上
		return gestureDetector.onTouchEvent(event) ;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Log.i("sundylog","onFling...")  ;
		if(e1.getX() >e2.getX()) 
		{
			//如果是往左边滑动
			//设置动画效果
			viewFlipper.setOutAnimation(this, R.anim.fade_left_out)  ;
			viewFlipper.setInAnimation(this,R.anim.fade_right_in)  ;
			//上一张
			viewFlipper.showPrevious()  ;
		}else if(e1.getX() < e2.getX())
		{
			//如果是往右边滑动
			viewFlipper.setOutAnimation(this,R.anim.fade_right_out)  ;
			viewFlipper.setInAnimation(this,R.anim.fade_left_in)  ;
			viewFlipper.showNext()  ;
		}else 
		{
			return false  ;
		}
		return true;
	}

}
