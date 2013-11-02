/**
 * @author Sundy
 * @description listview using arrays .
 */

package sundy.android.demo.java4android;

import sundy.android.demo.R;
import android.app.ListActivity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ArraryActivity extends ListActivity {

	String[] cities = {"成都","郑州","北京","上海"}  ;
	ArrayAdapter<String> adapter ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mylist) ;
		ListView listView1 = (ListView)findViewById(android.R.id.list) ;
		listView1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				Toast.makeText(ArraryActivity.this,"选中了："+arg0.getSelectedItemId(), 2000).show() ;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}) ;
		
		listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(ArraryActivity.this,"选中了::："+arg2, 2000).show() ;
				// TODO Auto-generated method stub
				
			}
		}) ;
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities) ;
		listView1.setAdapter(adapter) ;
		
		NotificationManager nm = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE)  ;
	}
}
