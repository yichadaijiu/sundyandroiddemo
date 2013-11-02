package sundy.android.demo.widget;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.LiveFolders;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class AppWidgetSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Button _buttonCreateShortcut = new Button(this)  ;
        _buttonCreateShortcut.setText("install shortcut")  ;
        _buttonCreateShortcut.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)) ;
        setContentView(_buttonCreateShortcut);
        _buttonCreateShortcut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent returnIntent = new Intent()  ;				
				returnIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT")  ;
	        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Todeath")  ;
	        	//returnIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(AppWidgetSampleActivity.this, R.drawable.icon));
	        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(AppWidgetSampleActivity.this,AppWidgetSampleActivity.class))  ;
	        	//sendBroadcast(returnIntent, "com.android.launcher.permission.INSTALL_SHORTCUT")  ;
	        	sendBroadcast(returnIntent) ;
			}
		})  ;
       /* if(getIntent().getAction().equals(Intent.ACTION_CREATE_SHORTCUT))
        {
        	Intent returnIntent = new Intent()  ;
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Todeath")  ;
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(this,AppWidgetSampleActivity.class))  ;
        	
        	setResult(RESULT_OK,returnIntent)  ;
        	finish();
        }else if(getIntent().getAction().equals(LiveFolders.ACTION_CREATE_LIVE_FOLDER))
        {
        	Intent returnIntent = new Intent()  ;
        	returnIntent.setData(ContactsContract.Contacts.CONTENT_URI)  ;
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "TodeathLiveFolder")  ;
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        	returnIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(this,AppWidgetSampleActivity.class))  ;
        	
        	setResult(RESULT_OK,returnIntent)  ;
        	finish();
        }*/
        
        	
    }
}