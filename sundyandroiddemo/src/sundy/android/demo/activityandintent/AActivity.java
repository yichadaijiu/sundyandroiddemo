package sundy.android.demo.activityandintent;

import sundy.android.demo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AActivity extends Activity{

	private static int mIndex = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_task)  ;
		Log.i("sundylog","AActivity Create"+mIndex+"  TaskId="+getTaskId())  ;
		++mIndex  ;
		Button _buttonStartA = (Button)findViewById(R.id.buttonStartA)  ;
		_buttonStartA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent _intent = new Intent(AActivity.this,AActivity.class)  ;
				startActivity(_intent) ;
			}
		}) ;
		
		
		Button _buttonStartB = (Button)findViewById(R.id.buttonStartB)  ;
		_buttonStartB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent _intent = new Intent(AActivity.this,BActivity.class)  ;
				startActivity(_intent) ;
			}
		}) ;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("sundylog","AActivity Destory"+mIndex+"  TaskId="+getTaskId())  ;
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		Log.i("sundylog","AActivity onNewIntent"+mIndex+"  TaskId="+getTaskId())  ;
	}

}
