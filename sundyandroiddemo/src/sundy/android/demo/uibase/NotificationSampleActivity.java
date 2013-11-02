package sundy.android.demo.uibase;

import sundy.android.demo.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class NotificationSampleActivity extends Activity {

	private NotificationManager notifyManager   ;
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		notifyManager.cancelAll()  ;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_notification)  ;
		notifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE)  ;
		
		
		//custom notification
		Button buttonNotify2 = (Button)findViewById(R.id.buttonNotify2)  ;
		buttonNotify2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Notification notify = new Notification(R.drawable.icon, "自定义 Notification", System.currentTimeMillis()) ;
				PendingIntent contentIntent = PendingIntent.getActivity(NotificationSampleActivity.this, 0, 
						new Intent(NotificationSampleActivity.this,BaseDialogActivity.class), 0)  ;
				notify.contentIntent = contentIntent  ;
				notify.contentView = new RemoteViews(getPackageName(), R.layout.layout_notificationcontent)  ;
				long[] vibrateA = {0L,200L,400L,600L} ;
				notify.vibrate = vibrateA ;
				notifyManager.notify(123, notify)  ;
			}
		}) ;
		
		//common notification
		Button buttonNotify1 = (Button)findViewById(R.id.buttonNotify1)  ;
		buttonNotify1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Notification notify = new Notification(R.drawable.icon, "你好 Sundy", System.currentTimeMillis()) ;
				PendingIntent contentIntent = PendingIntent.getActivity(NotificationSampleActivity.this, 0, 
						new Intent(NotificationSampleActivity.this,BaseDialogActivity.class), 0)  ;
				
				notify.setLatestEventInfo(NotificationSampleActivity.this, "Hello Sundy", "感谢你的提醒", contentIntent)  ;
				notifyManager.notify(123, notify)  ;
			}
		}) ;
	}

}
