package sundy.android.demo.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Contacts.People;
import android.provider.ContactsContract.Contacts;
import android.provider.LiveFolders;
import android.util.Log;

public class LiveFolderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(getIntent().getAction().equals(LiveFolders.ACTION_CREATE_LIVE_FOLDER))
		{
			Intent _Intent = new Intent()  ;
			_Intent.setData(People.CONTENT_URI)  ;
			_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_NAME, "SundyLiveFolder")  ;
			_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_DISPLAY_MODE, LiveFolders.DISPLAY_MODE_LIST)  ;
			setResult(RESULT_OK, _Intent) ;
			finish()  ;
			Log.i("sundylog","People");
		}
	}

}
