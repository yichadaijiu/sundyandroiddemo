package sundy.android.demo.uibase;

import java.util.ArrayList;
import java.util.List;

import sundy.android.demo.R;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People.Phones;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SundyListActivity extends ListActivity {

	private EditText mEditText  ;
	List<String> itemsList ;
	ArrayAdapter<String> adapter ;
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub		
		super.onListItemClick(l, v, position, id);
		itemsList.remove(position)  ;
		adapter.notifyDataSetChanged()  ;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sundylist) ;
		//displayList() ;
		displayCursor() ;
	}
	
	private void displayCursor() 
	{
		//数据集
		Cursor cursor = getContentResolver().query(android.provider.Contacts.Phones.CONTENT_URI, null, null, null,null) ;
		//adapter
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.user_item , 
				cursor, new String[]{Phones.NAME,Phones.NUMBER}, 
				new int[]{R.id.textView1,R.id.textView2})  ;
		//bind
		setListAdapter(adapter)  ;
		
	}
	
	private void displayList()
	{
		//mListView = getListView()  ;
		//建立dataset
		itemsList = new ArrayList<String>()  ;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,itemsList)  ;
		setListAdapter(adapter) ;
		
		mEditText = (EditText)findViewById(R.id.editTextSundy)  ;
		mEditText.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)
				{
					itemsList.add(mEditText.getText().toString())  ;
					adapter.notifyDataSetChanged()  ;
					mEditText.setText(null) ;
				}
				return false;
			}
		})  ;
		
	}

}
