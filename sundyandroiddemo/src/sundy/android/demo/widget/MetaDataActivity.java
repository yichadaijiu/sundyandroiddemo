package sundy.android.demo.widget;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.Toast;

public class MetaDataActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActivityInfo aiInfo;
		try {
			aiInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
			String metaValue = aiInfo.metaData.getString("sundy.android.demo.widget.metaactivity") ;
			Toast.makeText(this, metaValue, 3000).show()  ;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
