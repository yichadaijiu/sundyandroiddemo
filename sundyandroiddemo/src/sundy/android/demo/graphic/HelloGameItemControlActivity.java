package sundy.android.demo.graphic;

import sundy.android.demo.configration.CommonConstants;
import sundy.android.demo.graphic.GameControlRobotView.OnGameKeyDownListner;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class HelloGameItemControlActivity extends Activity {

	private GameControlRobotView mGameView = null ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mGameView = new GameControlRobotView(this) ;
		
		mGameView.setOnGameKeyDown(new OnGameKeyDownListner() {
			
			@Override
			public void onKeyDown(Object keyObject) {
				// TODO Auto-generated method stub
				Toast.makeText(HelloGameItemControlActivity.this, keyObject.toString(), 3000).show() ;
			}
		})  ;
		
		
		getWindow().getDecorView().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i(CommonConstants.LOGCAT_TAG_NAME, "Window onClick") ;
			}
		}) ;
		
		getWindow().getDecorView().setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				Log.i(CommonConstants.LOGCAT_TAG_NAME, "Window onTouch") ;
				return false;
			}
		}) ;
		
		setContentView(mGameView) ;
		
		
		new Thread(new GameThread()).start() ;
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Activity onKeyUp") ;
		return true;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Activity onTouchEvent") ;
		return super.onTouchEvent(event);
	}

	class GameThread implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(!Thread.currentThread().isInterrupted())
			{
				try {
					Thread.sleep(100) ;
				} catch (Exception e) {
					// TODO: handle exception
					Thread.currentThread().interrupt() ;
				}
				mGameView.postInvalidate() ;
			}
		}
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode)
		{
		case KeyEvent.KEYCODE_VOLUME_UP:
			mGameView.y -= 3  ;
			break ;
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			mGameView.y += 3  ;
			break ;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			mGameView.y += 3  ;
			break ;
		case KeyEvent.KEYCODE_DPAD_UP:
			mGameView.y -= 3  ;
			break ;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			mGameView.x -= 3  ;
			break ;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			mGameView.x += 3  ;
			break ;
		}
		return false ;
	}
}
