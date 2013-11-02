/**
 * Thread Concept Demo
 */
package sundy.android.demo.async;

import java.io.IOException;
import java.net.URL;

import sundy.android.demo.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author sundy
 *
 */
public class ThreadConceptActivity extends Activity {

	private ImageView mImageView = null ;
	//The image url we are downloading from internet .
	private final String IMAGE_URL = "http://www.lhzhang.org/image.axd?picture=/201102/46613566.jpg" ;
	
	//Async private class 
	private class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
	    /** The system calls this to perform work in a worker thread and
	      * delivers it the parameters given to AsyncTask.execute() */
	    protected Drawable doInBackground(String... urls) {
	        return loadImageFromNetwork(urls[0]);
	    }
	    
	    /** The system calls this to perform work in the UI thread and delivers
	      * the result from doInBackground() */
	    protected void onPostExecute(Drawable result) {
	        mImageView.setImageDrawable(result);
	    }
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout_threadconcept)  ;
		mImageView = (ImageView)this.findViewById(R.id.imageThreadConcept) ;
		
		
	
		//1. load image in main thread 
		findViewById(R.id.buttonWorkThread).setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Drawable drawable = loadImageFromNetwork(IMAGE_URL);
	            mImageView.setImageDrawable(drawable) ;
			}})  ;
		//2. load image in new thread , but set imageview not thread  safety
		findViewById(R.id.buttonWorkThread2).setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Drawable drawable = loadImageFromNetwork(IMAGE_URL);
						mImageView.setImageDrawable(drawable) ;
							
						
					}
					
				}).start()  ;
				
			}})  ;
		
		//3. load image in new thread , but set imageview by View.post(Runnable) 
		findViewById(R.id.buttonWorkThread3).setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new Runnable(){
					Drawable drawable = loadImageFromNetwork(IMAGE_URL);
					@Override
					public void run() {
						// TODO Auto-generated method stub
			            mImageView.post(new Runnable(){
			            	@Override
							public void run() {
								// TODO Auto-generated method stub
								mImageView.setImageDrawable(drawable) ;
							}}) ;
					}
					
				}).start()  ;
				
			}})  ;
		
		//4. load image in new thread , but set imageview by AsyncTask 
		findViewById(R.id.buttonWorkThread4).setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DownloadImageTask().execute(IMAGE_URL) ;
				
			}})  ;
	}
	
	// the Drawable loadImage main function 
	private Drawable loadImageFromNetwork(String imageUrl)
	{
		
		Drawable drawable = null;
		try {
			drawable = Drawable.createFromStream(
					new URL(imageUrl).openStream(), "image.gif");
		} catch (IOException e) {
			Log.d("test", e.getMessage());
		}
		if (drawable == null) {
			Log.d("test", "null drawable");
		} else {
			Log.d("test", "not null drawable");
		}
		
		return drawable ;
	}
}
