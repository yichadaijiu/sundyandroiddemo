package sundy.android.demo.activityandintent;

import sundy.android.demo.R;
import sundy.android.demo.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE)  ;
		setContentView(R.layout.layout_floatactivity)  ;
	}

}
