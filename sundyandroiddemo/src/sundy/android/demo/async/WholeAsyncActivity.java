package sundy.android.demo.async;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import sundy.android.demo.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WholeAsyncActivity extends Activity {
    /** Called when the activity is first created. */
	private int index =0  ;
	private Handler handler   ;
	private Button button1  ;
	private Button button2  ;
	private Button button3 ;
	private ImageView imageView  ;
	private Handler handler1  ;
	Drawable _drawable2  ;
	
	
	class SundyAsyncTask extends AsyncTask<String, Integer, Drawable>
	{

		@Override
		protected Drawable doInBackground(String... params) {
			// TODO Auto-generated method stub
			Drawable drawable3 = null ;
			try {
				drawable3 = Drawable.createFromStream(new URL(params[0]).openStream()  , "image.gif")  ;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return drawable3;
		}

		@Override
		protected void onPostExecute(Drawable result) {
			// TODO Auto-generated method stub
			imageView.setImageDrawable(result)  ;
			super.onPostExecute(result);
		}
		
	}
	
	Message defineNewMessage(String messageContent)
	{
		Message returnMsg = new Message() ;
		Bundle data = new Bundle() ;
		data.putString("sundymessagekey", messageContent)  ;
		returnMsg.setData(data)  ;
		return returnMsg ;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wholeasync); 
        imageView = (ImageView)findViewById(R.id.imageView1)  ;
        button3 = (Button)findViewById(R.id.button3)  ;
        button3.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new SundyAsyncTask().execute("http://img.mm-girl.com/photo/180/chenqiaoen-se-459180.jpg")  ;
			}
		})  ;
        
        
        handler1 = new Handler()
        {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				
				Drawable _drawable = (Drawable)msg.obj  ;
				imageView.setImageDrawable(_drawable)  ;
				
				super.handleMessage(msg);
				
				
			}
        	
        }  ;
        
        
        //1,实现handler ， 主线程
        handler = new Handler()
        {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg != null && msg.getData().containsKey("sundy"))
				{
					String megContent = msg.getData().getString("sundy")  ;
					Toast.makeText(WholeAsyncActivity.this, "接收到消息:"+megContent, 3000).show() ;
					button1.setText("接收到消息")  ;
					
				}
				super.handleMessage(msg);
			}
        	
        };
       
        
        button2 = (Button)findViewById(R.id.button2)  ;
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							_drawable2 = Drawable.createFromStream(new URL("http://www.nihaotw.com/18094/hylxyyc/mtjl/201003/W020100331473852181905.jpg").openStream()  , "image.gif")  ;
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						handler1.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub

									imageView.setImageDrawable(_drawable2)  ;
								
							}
						})  ;
					}
				}).start()  ;
				
				
			}
		}) ;
        
        button1 = (Button)findViewById(R.id.button1)  ;
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
	
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						// TODO Auto-generated method stub
						try {
							Drawable _drawable = Drawable.createFromStream(new URL("http://img.mm-girl.com/photo/180/chenqiaoen-se-459180.jpg").openStream()  , "image.gif")  ;
												
							Message _message = new Message()  ;
							_message.obj = _drawable  ;
							handler1.sendMessage(_message)  ;
								
							
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start()  ;
				
				
				
				
			}
		})  ;
        
        
        
        
    }
}