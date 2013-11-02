/**
 * Application of current instance management  . 
 */
package sundy.android.demo;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import sundy.android.demo.configration.*;

/**
 * @author sundy
 *
 */
public class SundyAndroidDemoApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.i(CommonConstants.LOGCAT_APP_NAME, "Created")  ;
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		Log.i(CommonConstants.LOGCAT_APP_NAME, "LowMemory")  ;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.i(CommonConstants.LOGCAT_APP_NAME, "ConfigurationChanged")  ;
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		Log.i(CommonConstants.LOGCAT_APP_NAME,"Terminated")  ;
	}

}
