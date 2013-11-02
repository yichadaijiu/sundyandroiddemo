package sundy.android.demo.graphic;

import com.google.android.maps.TrackballGestureDetector;

import sundy.android.demo.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawableResourceXMLActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Resources res = getResources()  ;
		
		LinearLayout _LinearLayout = new LinearLayout(this)  ;
		ImageView _ImageView = new ImageView(this) ;
		TransitionDrawable drawable = (TransitionDrawable)res.getDrawable(R.drawable.expand_collapse) ;
		_ImageView.setAdjustViewBounds(true)  ;
		_ImageView.setImageDrawable(drawable) ;
		_ImageView.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.MATCH_PARENT,Gallery.LayoutParams.MATCH_PARENT)) ;
		_LinearLayout.addView(_ImageView)  ;
		setContentView(_LinearLayout) ;
	}

}
