package sundy.android.demo.contentprovider;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContentResolverActivity extends Activity {

	private ListView listView  ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		queryFromNew() ;

	}
	
	private void queryFromNew()
	{
		listView = new ListView(this);
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        //startManagingCursor(cursor);我们将获得的Cursor对象交由Activity管理，这样Cursor的生命周期和Activity便能够自动同步，省去自己手动管理Cursor
        startManagingCursor(cursor);
        ListAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1,
                cursor,
                new String[]{Contacts.DISPLAY_NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(listAdapter);
        
        setContentView(listView);
	}
	
	private void queryFromOld()
	{
		listView = new ListView(this);
        Cursor cursor = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        //startManagingCursor(cursor);我们将获得的Cursor对象交由Activity管理，这样Cursor的生命周期和Activity便能够自动同步，省去自己手动管理Cursor
        startManagingCursor(cursor);
        ListAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1,
                cursor,
                new String[]{People.NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(listAdapter);
        
        setContentView(listView);
	}

}
