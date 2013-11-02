package sundy.android.demo.async;

import sundy.android.demo.configration.CommonConstants;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MyThreadHandler extends Handler {

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Get the message by Handler Thread")  ;
	}

}
