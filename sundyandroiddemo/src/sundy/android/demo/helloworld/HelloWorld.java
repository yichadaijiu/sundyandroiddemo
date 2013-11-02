/**
 * 第二课讲解Android环境基础的HelloWorld案例 �?
 */
package sundy.android.demo.helloworld;

import sundy.android.demo.R;
import sundy.android.demo.configration.CommonConstants;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Administrator
 * @version 1.0
 * 
 */
public class HelloWorld extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/* 打印出不同的log信息 */
		
		Log.v(CommonConstants.LOGCAT_TAG_NAME, "VERBOSE");
		Log.d(CommonConstants.LOGCAT_TAG_NAME, "DEBUG");
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "INFO");
		Log.w(CommonConstants.LOGCAT_TAG_NAME, "WARN");
		Log.e(CommonConstants.LOGCAT_TAG_NAME, "ERROR");
		/* 设置Activity要显示的布局�?R.layout.main) */
		setContentView(R.layout.layout_helloword);
	}

}
