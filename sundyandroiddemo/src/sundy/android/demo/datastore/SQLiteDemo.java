package sundy.android.demo.datastore;

import java.lang.reflect.Field;
import sundy.android.demo.* ;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SQLiteDemo extends Activity {
	
	ListView lvUser;
	private int m_ListViewPosition;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_demo);
		
		InitView();
		InitListeners();
		BindData();
	}

	private void InitView() {
		lvUser = (ListView) findViewById(R.id.lvUser);
	}
	
	private void InitListeners() {
		registerForContextMenu(lvUser);
	}
	
	/**
	 * 绑定数据
	 */
	public void BindData()
	{
		AdapterUser _AdapterUser = new AdapterUser(this);
		lvUser.setAdapter(_AdapterUser);
	}
	
	/**
	 * 删除一个指定的用户
	 * @param p_ModelUser
	 */
	public void Delete(ModelUser p_ModelUser)
	{	
		String _Message = "你确认要删用户" + p_ModelUser.GetUserName();
		//显示警告框
		ShowAlertDialog("删除用户",_Message,new OnDeleteClickListener());
	}
		
	/**
	 * 点击删除事件
	 *
	 */
	private class OnDeleteClickListener implements DialogInterface.OnClickListener {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			//获取绑定的Adapter
			AdapterUser _AdapterUser = (AdapterUser)lvUser.getAdapter();
			//获取点击行的User实体类
			ModelUser _ModelUser = (ModelUser)_AdapterUser.getItem(m_ListViewPosition);
			BusinessUser _BusinessUser = new BusinessUser(SQLiteDemo.this);
			//调用删除方法删除
			Boolean _Result = _BusinessUser.DeleteUserByUserID(_ModelUser.GetUserID());
			if(_Result == true)
			{
				//移除删除要删除的行
				_AdapterUser.GetList().remove(m_ListViewPosition);
				//触发改变，刷新ListViewUI
				_AdapterUser.notifyDataSetChanged();
			}
		}
		
	}
	
	protected AlertDialog ShowAlertDialog(String p_Title,String p_Message,DialogInterface.OnClickListener p_ClickListener)
	{
		return new AlertDialog.Builder(this).setTitle(p_Title).setMessage(p_Message).setPositiveButton("确定", p_ClickListener).setNegativeButton("取消", null).show();
	}
	
	//设置上下文长按Item时的菜单
	@Override
	public void onCreateContextMenu(ContextMenu p_ContextMenu, View p_View, ContextMenuInfo p_MenuInfo) {
		AdapterContextMenuInfo _AdapterContextMenuInfo = (AdapterContextMenuInfo)p_MenuInfo;
		ListAdapter _ListAdapter = lvUser.getAdapter();
		ModelUser _ModelUser = (ModelUser)_ListAdapter.getItem(_AdapterContextMenuInfo.position);
		m_ListViewPosition = _AdapterContextMenuInfo.position;
		//设置菜单Title
		p_ContextMenu.setHeaderTitle(_ModelUser.GetUserName());
		int _ItemID[] = {1,2};
		//设置菜单
		CreateMenu(p_ContextMenu, _ItemID);
	}
	
	//设置点击手机Menu后的新建菜单
	@Override    
	public boolean onCreateOptionsMenu(Menu menu) {         
		menu.add(0, 1, 1, "新建");        
//		menu.add(0, 2, 2, "删除");        
		return super.onCreateOptionsMenu(menu);
	}
	
	//设置Menu菜单新建点击后的事件
	@Override    public boolean onOptionsItemSelected(MenuItem item) { 
		if(item.getItemId() == 1){    
			ShowUserAddOrEditDialog(null);  
		}               
		return true;   
	}
	
	//生成长按菜单方法
	protected void CreateMenu(Menu p_Menu,int p_ItemID[])
	{
		int _GroupID = 0;
		int _Order = 0;
		
		for(int i=0;i<p_ItemID.length;i++)
		{
			switch(p_ItemID[i])
			{
			case 1:
				p_Menu.add(_GroupID, p_ItemID[i], _Order, "编辑");
				break;
			case 2:
				p_Menu.add(_GroupID, p_ItemID[i], _Order, "删除");
				break;
			default:
				break;
			}
		}
	}
	
	//长按菜单点击事件
	@Override
	public boolean onContextItemSelected(MenuItem p_Item) {
		AdapterContextMenuInfo _AdapterContextMenuInfo = (AdapterContextMenuInfo)p_Item.getMenuInfo();
		ListAdapter _ListAdapter = lvUser.getAdapter();
		ModelUser _ModelUser = (ModelUser)_ListAdapter.getItem(_AdapterContextMenuInfo.position);
		
		switch (p_Item.getItemId()) {
		case 1:
			ShowUserAddOrEditDialog(_ModelUser);
			break;
		case 2:
			Delete(_ModelUser);
			break;
		default:
			break;
		}
		
		return super.onContextItemSelected(p_Item);
	}
	
	//根据是添加还是修改，弹出添加或编辑对话框
	protected void ShowUserAddOrEditDialog(ModelUser p_ModelUser)
	{
		LayoutInflater _LayoutInflater = LayoutInflater.from(this);
		//加载对话框要显示的布局文件
		View _View = _LayoutInflater.inflate(R.layout.user_add_or_edit, null);
		
		EditText _etUserName = (EditText)_View.findViewById(R.id.etUserName);
		
		if(p_ModelUser != null)
		{
			_etUserName.setText(p_ModelUser.GetUserName());
		}
		
		String _Title;
		if(p_ModelUser == null)
		{
			_Title = "添加用户";
		}
		else {
			_Title = "修改用户";
		}
		
		//声明一个弹出对话框事件
		AlertDialog.Builder _Builder = new AlertDialog.Builder(this);
		_Builder.setTitle(_Title);
		_Builder.setView(_View);
		//设置保存、取消按钮，并绑定点击后调用的事件
		_Builder.setNeutralButton("保存", new OnAddOrEditUser(p_ModelUser,_etUserName,true));
		_Builder.setNegativeButton("取消", new OnAddOrEditUser(null,null,false));
		_Builder.show();
	}
	
	//关闭对话框
	protected void SetAlertDialogIsClose(DialogInterface p_Dialog,Boolean p_IsClose)
	{
		try {
			Field _Field = p_Dialog.getClass().getSuperclass().getDeclaredField("mShowing");
			_Field.setAccessible(true);
		    _Field.set(p_Dialog, p_IsClose);
		} catch (Exception e) {
		}
	}
	
	//对话框点击后调用的添加或修改事件
	private class OnAddOrEditUser implements DialogInterface.OnClickListener
	{
		private ModelUser m_ModelUser;
		private EditText m_txtUserName;
		private Boolean m_IsSaveButton;
		
		public OnAddOrEditUser(ModelUser p_ModelUser,EditText p_txtUserName,Boolean p_IsSaveButton)
		{
			m_ModelUser = p_ModelUser;
			m_txtUserName = p_txtUserName;
			m_IsSaveButton = p_IsSaveButton;
		}
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			//点击的不是保存是取消则关闭对话框
			if(m_IsSaveButton == false)
			{
				SetAlertDialogIsClose(dialog,true);
				return;
			}
			
			if(m_ModelUser == null)
			{
				m_ModelUser = new ModelUser();
			}
			
			String _UserName = m_txtUserName.getText().toString().trim();
		    
		    BusinessUser _BusinessUser = new BusinessUser(SQLiteDemo.this);

		    //判断是否已经存在该用户名
		    boolean _CheckResult = !_BusinessUser.IsExistUserByUserName(_UserName,m_ModelUser.GetUserID());
		    if(!_CheckResult)
		    {
				Toast.makeText(getApplicationContext(), "该用户名已经存在", 1).show();
		    	SetAlertDialogIsClose(dialog,false);
		    	return;
		    }
		    else {
		    	SetAlertDialogIsClose(dialog,true);
			}

			m_ModelUser.SetUserName(String.valueOf(m_txtUserName.getText().toString().trim()));
			
			Boolean _Result = false;
			//根据是添加还是修改调用方法
			if(m_ModelUser.GetUserID() == 0)
			{
				_Result = _BusinessUser.InsertUser(m_ModelUser);
			}
			else {
				_Result = _BusinessUser.UpdateUserByUserID(m_ModelUser);
			}

			if(_Result)
			{
				//ListView重新绑定Adapter
				AdapterUser _AdapterUser = new AdapterUser(SQLiteDemo.this);
				lvUser.setAdapter(_AdapterUser);
			}
			else {
				Toast.makeText(getApplicationContext(), "添加失败", 1).show();
			}
		}
		
	}
}