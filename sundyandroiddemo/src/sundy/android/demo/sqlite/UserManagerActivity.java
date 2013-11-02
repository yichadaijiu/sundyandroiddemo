package sundy.android.demo.sqlite;

import java.io.File;
import java.util.zip.Inflater;

import sundy.android.demo.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class UserManagerActivity extends ListActivity {

	private DBOperation dbOperation  ;
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}
	
	

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if(id == 1234)
		{
			AlertDialog dialog = new AlertDialog.Builder(this)
								.setTitle("添加新用户")
								.setIcon(R.drawable.name)
								
								.setView(LayoutInflater.from(this).inflate(R.layout.layout_adduser_dialog, null))
								.setPositiveButton("添加", new OnClickListener() {
									
									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										// TODO Auto-generated method stub
										
										
										AlertDialog dialog = (AlertDialog)arg0 ;
										User _user = new User()  ;
										EditText editUser = (EditText)dialog.findViewById(R.id.editTextUserName)  ;
										EditText editAddress = (EditText)dialog.findViewById(R.id.editTextUserAddress)  ;
										_user.setUserAge(18) ;
										_user.setMale(true) ;
										if(editUser != null)
											_user.setUserName(editUser.getText().toString()) ;
										else {
											_user.setUserName("Sundy")  ;
											Log.i("sundylog","edit user is null") ;
										}
										if(editAddress != null)
											_user.setUserAddress(editAddress.getText().toString())  ;
										else {
											_user.setUserAddress("Chengdu")  ;
											Log.i("sundylog","edit address is null") ;
										}
										dbOperation.insertUser(_user) ; 
										
										arg0.dismiss()  ;
										
										displayUserList()  ;
									}
								})
								.setNegativeButton("取消", new OnClickListener() {
									
									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										// TODO Auto-generated method stub
										arg0.dismiss() ;
									}
								}).create()		;

			return dialog  ;
			
		}
		return super.onCreateDialog(id);
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() ==1)
		{
			showDialog(1234)  ;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(1,1, 1, "添加用户") ;
		return super.onCreateOptionsMenu(menu);
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		dbOperation = new DBOperation(this) ;
		dbOperation.createDatabase()  ;
		displayUserList() ;
	}
	
	/**
	 * 显示用户列表
	 */
	private void displayUserList()
	{
		dbOperation.openDatabase()  ;
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, dbOperation.queryUserAll(), new String[]{dbOperation.COLUMN_USERNAME,dbOperation.COLUMN_ADRESS}, new int[]{android.R.id.text1,android.R.id.text2})  ;
		setListAdapter(adapter); 
	}
	
	/**
	 * 用户适配器内部类
	 * @author Administrator
	 *
	 */
	class UsersAdapter extends BaseAdapter
	{
		Context appContext ;
		Cursor cursor  ;
		public UsersAdapter(Context context , Cursor usersCursor)
		{
			appContext = context ;
			cursor = usersCursor  ;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return cursor.getCount() ;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
