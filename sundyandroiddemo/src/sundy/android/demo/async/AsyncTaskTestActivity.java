package sundy.android.demo.async;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import sundy.android.demo.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskTestActivity extends Activity {

	EditText asEditText = null ;
	TextView asTextView = null ;
	ProgressBar asProgressBar = null ;
	Button asButton = null ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout_asynctask) ;
		asEditText = (EditText)this.findViewById(R.id.editTextState2)  ;
		asTextView = (TextView)this.findViewById(R.id.text_view2)  ;
		asProgressBar = (ProgressBar)this.findViewById(R.id.progress_bar2)  ;
		asButton = (Button)this.findViewById(R.id.update_button2)  ;
		
		asButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(asEditText.getText() != null && !asEditText.getText().equals(""))
				{
					new WebGetAsyncTask().execute(asEditText.getText().toString())  ;
				}
				
			}
			
		})  ;
	}

	class WebGetAsyncTask extends AsyncTask<String,Integer,String>
	{

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			asTextView.setText(result) ;
		}

		

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			//super.onProgressUpdate(values);
			asProgressBar.setProgress(values[0]) ;
		}



		@Override
		protected String doInBackground(String... params) {
			try {    
                HttpClient client = new DefaultHttpClient();    
                // params[0] is connectivity url 
                HttpGet get = new HttpGet(params[0]);    
                HttpResponse response = client.execute(get);    
                HttpEntity entity = response.getEntity();    
                long length = entity.getContentLength();    
                InputStream is = entity.getContent();    
                String s = null;   
                int toCase = 0 ; 
                if (is != null) {    
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();    
                        byte[] buf = new byte[128];    
                        int ch = -1;    
                        int count = 0;    
                        while ((ch = is.read(buf)) != -1) {    
                                baos.write(buf, 0, ch);    
                                count += ch;    
                                if (length > 0) {    
                                        // call publishProgress（）update progress
                                		toCase = (int) ((count / (float) length) * 100) ;
                                        publishProgress(toCase);
                                }    
                                // sleep 100
                                Thread.sleep(100);    
                        }    
                        s = new String(baos.toByteArray());                        }       
                return s;    
        } catch (Exception e) {    
                e.printStackTrace();    
        }    
        return null;
		}
		
	}
}
