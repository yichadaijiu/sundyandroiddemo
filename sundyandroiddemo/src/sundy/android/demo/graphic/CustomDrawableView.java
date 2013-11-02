package sundy.android.demo.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CustomDrawableView extends View {

	ShapeDrawable mShapeDrawable  ;
	public CustomDrawableView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mShapeDrawable = new ShapeDrawable(new OvalShape())  ;
		mShapeDrawable.setBounds(10, 10, 300, 60) ;
		mShapeDrawable.getPaint().setColor(Color.RED)  ;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		mShapeDrawable.draw(canvas) ;
	}

}
