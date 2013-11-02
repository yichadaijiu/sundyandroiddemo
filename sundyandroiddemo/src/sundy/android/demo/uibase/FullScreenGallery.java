package sundy.android.demo.uibase;

import sundy.android.demo.R;
import sundy.android.demo.uibase.MyGalleryActivity.ImageAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;

public class FullScreenGallery extends Activity {

	private int[] mImages = new int[]{
			R.drawable.sample_0,
			R.drawable.sample_5,
			R.drawable.sample_7,
			R.drawable.gesture1,
			R.drawable.gesture2,
			R.drawable.gesture3,
			R.drawable.gesture4
			}  ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE) ;
		setContentView(R.layout.layout_fullscreengallery)  ;
		Gallery gallery1 = (Gallery)findViewById(R.id.galleryFullScreen)  ;
		gallery1.setAdapter(new ImageAdapter())  ;
		
	}
	
	class ImageAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImages.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mImages[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView _ImageView = new ImageView(FullScreenGallery.this)  ;
			_ImageView.setImageResource(mImages[arg0])  ;
			return _ImageView ;
		}
		
	}

}
