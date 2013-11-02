package sundy.android.demo.activityandintent;

import sundy.android.demo.R;
import sundy.android.demo.configration.CommonConstants;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LifecycleActivity extends Activity {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onPause")  ;
	}

	private EditText mEditText  ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_lifecycleactivity) ;
		mEditText = (EditText)findViewById(R.id.editTextLifecycle)  ;
		if(mEditText != null && savedInstanceState != null)
		{
			mEditText.setText(savedInstanceState.getString("sundyvaluetext"))  ;
		}
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onCreate")  ;
		
		
		Button _buttonShowDialog = (Button)findViewById(R.id.buttonShowDialog)  ;
		_buttonShowDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final CharSequence[] items = {"Red", "Green", "Blue"};

				//调用dialog
				/*AlertDialog.Builder builder = new AlertDialog.Builder(LifecycleActivity.this);
				builder.setTitle("Pick a color");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
				AlertDialog alert = builder.create();
				alert.show()  ;*/
				
				//启动新的activity
				Intent _intent2 = new Intent(LifecycleActivity.this,ThirdActivity.class)  ;
				startActivity(_intent2)  ;
			}
		})  ;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onConfigurationChanged")  ;
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"onConfigurationChanged : Landscape")  ;
		else
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"onConfigurationChanged : Portrait")  ;
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onDestroy")  ;
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onRestart")  ;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onRestoreInstanceState")  ;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onResume")  ;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		if(mEditText != null)
		{
			String _textValue = mEditText.getText().toString()  ;
			outState.putString("sundyvaluetext", "Sundy:"+_textValue)  ;
		}
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onSaveInstanceState")  ;
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onStart")  ;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onStop")  ;
	}

}
