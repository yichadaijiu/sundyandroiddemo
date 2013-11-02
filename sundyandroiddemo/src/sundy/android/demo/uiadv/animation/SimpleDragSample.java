package sundy.android.demo.uiadv.animation;

import sundy.android.demo.R;
import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class SimpleDragSample extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_simpledrag)  ;
		DisplayMetrics dm = getResources().getDisplayMetrics()  ;
		final int screenWidth = dm.widthPixels  ;
		final int screenHeight = dm.heightPixels  ;
		final Button _Button = (Button)findViewById(R.id.buttonDrag)  ;
		_Button.setOnTouchListener(new OnTouchListener() {
			int lastX , lastY  ;
			boolean isDraging  = false  ;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				int ea = event.getAction()  ;
				switch (ea) {
				case MotionEvent.ACTION_DOWN:
					Log.i("sundylog","Down") ;
					isDraging = true ;
					lastX = (int) event.getRawX()  ;
					lastY = (int) event.getRawY()  ;
					break;
				case MotionEvent.ACTION_MOVE:
					if(isDraging)
					{
						int dx = (int)event.getRawX() - lastX  ;
						int dy = (int)event.getRawY() - lastY  ;
						
						int l = v.getLeft() + dx  ;
						int b = v.getBottom() + dy  ;
						int r = v.getRight() + dx  ;
						int t = v.getTop() + dy  ;
						
						//ÅÐ¶Ï³¬³öÆÁÄ»
						if(l<0)
						{
							l = 0 ;
							r = l + v.getWidth()  ;
						}
						if(t<0)
						{
							t = 0 ;
							b = t + v.getHeight()  ;
						}
						if(r> screenWidth)
						{
							r = screenWidth  ;
							l = r - v.getWidth()  ;
						}
						if(b > screenHeight)
						{
							b = screenHeight  ;
							t = b - v.getHeight()  ;
						}
						
						v.layout(l, t, r, b)  ;
						lastX = (int) event.getRawX()  ;
						lastY = (int) event.getRawY()  ;
						v.postInvalidate()  ;
					}
					
					break ;
				case MotionEvent.ACTION_UP:
					isDraging = false  ;
					break ;
				default:
					break;
				}
				return false;
			}
		}) ;
	}

}
