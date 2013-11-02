package sundy.android.demo.uibase;

import sundy.android.demo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MyGalleryActivity extends Activity implements ViewFactory {
	private int mIndex = 0 ;	
	private ImageSwitcher imageSwitcher1  ;
	private int[] mImages = new int[]{
			R.drawable.sample_0,
			R.drawable.sample_1,
			R.drawable.sample_2,
			R.drawable.sample_3,
			R.drawable.sample_4,
			R.drawable.sample_5,
			R.drawable.sample_6,
			R.drawable.sample_7,
			}  ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gallery) ;
		
		imageSwitcher1 = (ImageSwitcher)findViewById(R.id.imageSwitcher1)  ;
		imageSwitcher1.setFactory(this)  ;
		imageSwitcher1.setImageResource(mImages[mIndex])  ;
		
		Gallery gallery1 = (Gallery)findViewById(R.id.gallery1)  ;
		gallery1.setAdapter(new ImageAdapter())  ;
		
		gallery1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MyGalleryActivity.this, ""+arg2, 3000).show() ;
				imageSwitcher1.setImageResource(mImages[arg2])  ;
			}
		}) ;
		
		
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
			ImageView _ImageView = new ImageView(MyGalleryActivity.this)  ;
			_ImageView.setImageResource(mImages[arg0])  ;
			return _ImageView ;
		}
		
	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		return new ImageView(this);
	}


}
