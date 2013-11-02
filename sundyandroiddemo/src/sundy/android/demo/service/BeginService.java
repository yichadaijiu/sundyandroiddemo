/**
 * 一个简单的入门级的Service
 */
package sundy.android.demo.service;

import sundy.android.demo.configration.CommonConstants;
import android.R;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @author Administrator
 *
 */
public class BeginService extends Service {

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		
		return myBinder;
	}

	public void MyMethod(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++)
				{
					try {
						Thread.sleep(1000) ;
						Log.i(CommonConstants.LOGCAT_TAG_NAME, "Binding BeginService :"+i) ;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start() ;
		
    }
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		//证明是主线程
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(1000) ;
				Log.i(CommonConstants.LOGCAT_TAG_NAME, "Starting BeginService :"+i) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//采用多线程
		/*new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++)
				{
					try {
						Thread.sleep(1000) ;
						Log.i(CommonConstants.LOGCAT_TAG_NAME, "Starting BeginService :"+i) ;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start() ;*/
		return super.onStartCommand(intent, flags, startId);
	}
	
	 public class MyBinder extends Binder{
	        
	        public BeginService getService(){
	            return BeginService.this;
	        }
	        
	        public void helloSundy()
	        {
	        	
	        }
	    }
	    
	    private MyBinder myBinder = new MyBinder();

}
