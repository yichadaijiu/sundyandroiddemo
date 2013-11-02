/**
 * @author Sundy
 * @decription Inner class
 */
package sundy.android.demo.java4android;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class InnerClassActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//3,Using an Anonymous Inner Class to Define a Listener
		/*Button aButton = (Button) findViewById(R.id.MyButton);  
		aButton.setOnClickListener(new View.OnClickListener() {  
		            public void onClick(View v) {  
		                // User clicked my button, do something here!  
		            }  
		});  */
		
		//4,Using an Anonymous Inner Class to Start a Thread
		new Thread() {  
		    public void run()  
		    {  
		        //doWorkHere();  
		    }  
		}.start();
		
		
		//5,Using a Named Inner Class
		/*Button[] buttons = getAllOneHundredButtonsAsArray();  
		for (Button button : buttons) {  
		    button.setOnClickListener(new View.OnClickListener() {  
		        public void onClick(View v) {  
		            showToast(v.getText());  
		        }  
		    });  
		}*/  
		
		
	
		
	}
	
	
	
	
	
	//1,inner class
	public class User {  
		  
	    //  User fields, including variables of type LoginInfo and UserPreferences  
	    // Misc user methods  
	  
	    class LoginInfo  
	    {  
	        // Login info fields  
	        // Login/Logout methods  
	        // Can access User fields/methods  
	    }  
	  
	    class Preferences  
	    {  
	        // User preference fields  
	        // Get/Set preference methods  
	        // Reset preferences method  
	        // Can access User fields/methods  
	    }
	    
	   
	}  
	
	//2,Using Static Nested Classes
	public static class ManageUser{}  
    {  
        // Server info applies to all instances of User  
    }  
}
