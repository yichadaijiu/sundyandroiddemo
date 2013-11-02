package sundy.android.demo.broadcastreceiver;

import sundy.android.demo.configration.CommonConstants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"接收到短信")  ;
			
		}else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"系统启动完成")  ;
		}else {
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"广播机制")  ;
		}
	}

}
