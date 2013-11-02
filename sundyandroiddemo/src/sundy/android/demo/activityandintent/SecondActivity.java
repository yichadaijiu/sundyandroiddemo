package sundy.android.demo.activityandintent;

import sundy.android.demo.R;
import sundy.android.demo.R.id;
import sundy.android.demo.R.layout;
import sundy.android.demo.configration.CommonConstants;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

	private EditText et  ;
	private Intent getIntent ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onCreate")  ;
		setContentView(R.layout.layout_activity2)  ;
		Button button24 = (Button)findViewById(R.id.button24)  ;
		button24.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent _intent = new Intent(SecondActivity.this,ThirdActivity.class)  ;
				startActivity(_intent) ;
			}
			
		}
		) ;
		getIntent = this.getIntent()  ;
		String getValue = getIntent.getStringExtra("sundyintent") ;
		et = (EditText)findViewById(R.id.editText23)  ;
		et.setText(getValue)  ;
		//Close Button
		Button buttonClose = (Button)findViewById(R.id.button2Close)  ;
		buttonClose.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String setValue = et.getText().toString()  ;
				getIntent.putExtra("sundyintentreturn", setValue)  ;
				setResult(1234,getIntent) ;
				
				finish()  ;
				
				
				
			}
			
		}
		) ;
		
		
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onDestroy")  ;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onPause")  ;
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onRestart")  ;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onResume")  ;
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onStart")  ;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Second - onStop")  ;
	}


}
