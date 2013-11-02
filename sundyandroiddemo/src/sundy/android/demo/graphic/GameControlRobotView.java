package sundy.android.demo.graphic;

import java.net.InterfaceAddress;

import sundy.android.demo.configration.CommonConstants;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GameControlRobotView extends View{

	int miCount = 0 ;
	int x,y = 0 ;
	
	OnGameKeyDownListner mOnGameKeyDownListner  ;
	
	public interface OnGameKeyDownListner
	{
		public void onKeyDown(Object keyObject) ;
		
	}
	
	public void setOnGameKeyDown(OnGameKeyDownListner gameKeyDownListner)
	{
		mOnGameKeyDownListner = gameKeyDownListner  ;
	}
	
	public GameControlRobotView(Context context) {
		super(context);
		setFocusable(true) ;
		setFocusableInTouchMode(true) ;
	}
	
	protected void onGameKeyDown(Object keyObject)
	{
		
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "View onKeyUp") ;
		if(mOnGameKeyDownListner != null)
		{
			mOnGameKeyDownListner.onKeyDown("Hello") ;
			onGameKeyDown("hello") ;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "View onTouchEvent") ;
		return super.onTouchEvent(event) ;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		if(miCount < 100)
		{
			miCount ++ ;
		}else
		{
			miCount = 0 ; 			
		}
		Paint _paint = new Paint()  ;
		switch(miCount%4)
		{
		case 0:
			_paint.setColor(Color.BLUE) ;
			break ;
		case 1:
			_paint.setColor(Color.GREEN) ;
			break ;
		case 2:
			_paint.setColor(Color.RED) ;
			break ;
		case 3:
			_paint.setColor(Color.YELLOW) ;
			break ;
		default:
			_paint.setColor(Color.WHITE) ;
			break ;
		}
		canvas.drawRect(x,y,x+60,y+40,_paint) ;
	}

}
