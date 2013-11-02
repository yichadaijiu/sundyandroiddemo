package sundy.android.demo.uibase;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MyTabActivity extends TabActivity implements OnTabChangeListener {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		TabHost tabHost1 = getTabHost()  ;
		TabSpec tabSpec1 = tabHost1.newTabSpec("Tab1")
		.setIndicator("Tab11",getResources().getDrawable(android.R.drawable.ic_dialog_email))
		.setContent(new Intent(this,MyDrawerActivity.class));
		tabHost1.addTab(tabSpec1)  ;
		
		TabSpec tabSpec2 = tabHost1.newTabSpec("Tab2")
		.setIndicator("Tab22",getResources().getDrawable(android.R.drawable.ic_dialog_map))
		.setContent(new Intent(this,FormWidgetActivity.class));
		tabHost1.addTab(tabSpec2) ;
		
		tabHost1.setOnTabChangedListener(this)  ;
		
		
	}

	@Override
	public void onTabChanged(String arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arg0, 3000).show() ;
	}

}
