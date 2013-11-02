package sundy.android.demo.contentprovider;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.SimpleCursorAdapter;

public class ContactContractActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ContentResolver _resolver =  getContentResolver()  ;
		Cursor _cursor = _resolver.query(CallLog.Calls.CONTENT_URI, null, null, null, null)  ;
		SimpleCursorAdapter _adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_single_choice, _cursor,
				new String[]{CallLog.Calls.NUMBER}, new int[]{android.R.id.text1})  ;
		setListAdapter(_adapter) ;
		
	}

}
