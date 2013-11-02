/**
 * Thread activity
 * @author Sundy
 */
package sundy.android.demo.java4android;

import sundy.android.demo.R;
import sundy.android.demo.configration.CommonConstants;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Multithread demo class
 * @author Sundy
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class ThreadActivity extends Activity {

	
	class MyThread extends Thread
	{
		public MyThread(String p_Name)
		{
			super(p_Name);
		}
		
		@Override
		public void run()
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,getName() + "线程运行开始！");
			
			for (int i = 0; i < 10; i++)
			{
				Log.i(CommonConstants.LOGCAT_TAG_NAME,i + "---" + getName());
				try
				{
					sleep((int) Math.random() * 10);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Thread from Runnable .
	 * @author Sundy
	 * @version 1.0
	 */
	class MyRunnable implements Runnable
	{

		@Override
		public void run()
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行开始！");
	        for (int i = 0; i < 10; i++) {
	        	Log.i(CommonConstants.LOGCAT_TAG_NAME,i + " " + Thread.currentThread().getName());
	            try {
	                Thread.sleep((int) Math.random() * 10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行结束！");
			
		}

	}

	
	
	/**
	 * @author Administrator
	 * 
	 */
	class Ticket implements Runnable
	{
		private int m_Tickets = 100;
		Object _Locker = new Object();
		
		@Override
		public void run()
		{
			for (int i = 0; i < 100; i++)
			{
				//不加同步锁就可能会导致同一张票被卖了两次的情况，体验通过同步代码块实现锁
				synchronized (this)
				{
					Sale();
				}
			}
		}

		//这是一个同步方法，体验通过同步方法实现锁
		//public synchronized void Sale()
		
		
		
		public void Sale()
		{
			if(m_Tickets > 0)
			{
				Log.i(CommonConstants.LOGCAT_TAG_NAME,"售票点" + Thread.currentThread().getName() + "卖出了第" + m_Tickets + "张票");
				m_Tickets--;
				
				try {
	                Thread.sleep((int) Math.random() * 10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			}
		}
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_threadactivity)  ;
		
		//1,Runnable demo 
		Button buttonRunnable = (Button)findViewById(R.id.buttonRunnable)  ;
		buttonRunnable.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行开始！");
				MyRunnable _MyRunnable = new MyRunnable();
		        Thread _Thread1 = new Thread(_MyRunnable);
		        
		        
		        
		        Thread _Thread2 = new Thread(_MyRunnable);
		        _Thread1.start();
		        _Thread2.start();
		        Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行结束！");
			}
		}) ;
		
		//2, Thread demo
		Button buttonThread = (Button)findViewById(R.id.buttonThread)  ;
		buttonThread.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行开始！");
				new MyThread("A").start();
		        new MyThread("B").start();
		        Log.i(CommonConstants.LOGCAT_TAG_NAME,Thread.currentThread().getName() + " 线程运行结束！");
			}
		}) ;
		
		
		//3, Synchronized
		Button buttonSynchronized = (Button)findViewById(R.id.buttonSynchronized)  ;
		buttonSynchronized.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Ticket _Ticket = new Ticket();
		        Thread _Thread1 = new Thread(_Ticket, "Thread-A"); 
		        Thread _Thread2 = new Thread(_Ticket, "Thread-B"); 
		        _Thread1.start(); 
		        _Thread2.start(); 
			}
		}) ;
		
	}

}
