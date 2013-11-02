package sundy.android.demo.uibase;

import sundy.android.demo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridViewActivity extends Activity {

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
		setContentView(R.layout.layout_gridview) ;
		GridView gridView1 = (GridView)findViewById(R.id.gridView1)  ;
		//1,建立数据源
		
		//2,adapter
		
		//3,ui
		gridView1.setAdapter(new ImageAdapter())  ;
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
			ImageView _ImageView = new ImageView(MyGridViewActivity.this)  ;
			_ImageView.setImageResource(mImages[arg0])  ;
			return _ImageView ;
		}
		
	}

}
