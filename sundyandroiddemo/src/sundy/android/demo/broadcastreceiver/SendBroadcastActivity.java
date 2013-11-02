package sundy.android.demo.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class SendBroadcastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout lin = new LinearLayout(this) ;
		lin.setOrientation(LinearLayout.VERTICAL)  ;
		Button button1 = new Button(this) ;
		button1.setText("发送消息") ;

		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent() ;
				intent.setAction("sundy.android.demo.HiMessage")  ;
				intent.putExtra("message", "今天天气不错");
				SendBroadcastActivity.this.sendBroadcast(intent)  ;
			}
			
		})  ;
		
		lin.addView(button1) ;
		setContentView(lin) ;
	}

}
