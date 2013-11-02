package sundy.android.demo.graphic;

import sundy.android.demo.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawableResourceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout _LinearLayout = new LinearLayout(this)  ;
		ImageView _ImageView = new ImageView(this) ;
		Drawable _Drawable = getResources().getDrawable(R.drawable.gesture2)  ;
		_ImageView.setAdjustViewBounds(true)  ;
		_ImageView.setImageDrawable(_Drawable) ;
		_ImageView.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT,Gallery.LayoutParams.WRAP_CONTENT)) ;
		_LinearLayout.addView(_ImageView)  ;
		setContentView(_LinearLayout) ;
	}

}
