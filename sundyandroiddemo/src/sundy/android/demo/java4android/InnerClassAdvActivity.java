/**
 * 
 */
package sundy.android.demo.java4android;

import java.text.SimpleDateFormat;
import java.util.Date;

import sundy.android.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class InnerClassAdvActivity extends Activity {
	public static final String DEBUG_TAG = "MyLoggingTag";  
    /** Called when the activity is first created. */  
    //6, Inner Classes and the "This" variable .
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.layout_innerclassadv);  
  
        final TextView myTextview = (TextView) findViewById(R.id.textViewToShow);  
        Button myButton = (Button) findViewById(R.id.buttonToClick);  
        myButton.setOnClickListener(new View.OnClickListener() {  
            public void onClick(View v) {  
  
                SimpleDateFormat formatter = new SimpleDateFormat("h:mm:ss a");  
                String strWhen = formatter.format(new Date());  
                myTextview.setText("Clicked at " + strWhen);  
  
                Log.v(DEBUG_TAG, "this Class name: " + this.getClass().getName());  
                Log.v(DEBUG_TAG, "this extends interface named: " + this.getClass().getInterfaces()[0].getName());  
                Log.v(DEBUG_TAG, "this Enclosing class name: " +this.getClass().getEnclosingClass().getName());  
                Log.v(DEBUG_TAG, "this Is anonymous class? " + this.getClass().isAnonymousClass());  
  
                Log.v(DEBUG_TAG, "ClassChaosActivity.this Class name: " + InnerClassAdvActivity.this.getClass().getName());  
                Log.v(DEBUG_TAG, "ClassChaosActivity.this Super Class name: " + InnerClassAdvActivity.this.getClass().getSuperclass().getName());  
                Log.v(DEBUG_TAG, "ClassChaosActivity.this Is anonymous class? " + InnerClassAdvActivity.this.getClass().isAnonymousClass());  
            }  
        });  
  
    }  
}
