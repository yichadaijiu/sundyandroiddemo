package sundy.android.demo.uibase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

	private String mText ;
	public String getText() {
		return mText;
	}

	public void setText(String mText) {
		this.mText = mText;
		invalidate()  ;
	}

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		RectF rectF = new RectF(10, 10, 50, 50) ;
		Paint paint = new Paint() ;
		paint.setColor(Color.BLUE)  ;
		//canvas.drawOval(rectF, paint)  ;
		canvas.drawRect(0,0,160,40,paint) ;
		if(mText != null && !mText.equals(""))
		{
			paint.setColor(Color.RED) ;
			canvas.drawText(mText, 10, 20, paint) ;
		}
	}

}
