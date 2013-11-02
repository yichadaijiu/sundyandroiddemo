package sundy.android.demo.service;

import sundy.android.demo.configration.CommonConstants;
import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BeginIntentService extends IntentService {

	public BeginIntentService() {
		super("sundy");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "IntentService oncreate") ;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "onBind") ;
		return super.onBind(intent);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "IntentService Destory") ;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "StartCommand") ;
		return super.onStartCommand(intent, flags, startId);
		
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++)
		{
			try {
				Thread.sleep(1000) ;
				Log.i(CommonConstants.LOGCAT_TAG_NAME, "Starting IntentService :"+i) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"IntentService Threadid="+Thread.currentThread().getId())  ;
	}

}
