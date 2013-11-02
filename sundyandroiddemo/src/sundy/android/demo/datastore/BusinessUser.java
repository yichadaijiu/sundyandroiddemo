package sundy.android.demo.datastore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BusinessUser {
	
	private SQLiteHelper m_SqLiteHelper;
	private SQLiteDatabase m_SQLiteDatabase;
	
	public BusinessUser(Context p_Context)
	{
		//构造函数的时候生成数据库
		m_SqLiteHelper = new SQLiteHelper(p_Context);
		m_SQLiteDatabase = m_SqLiteHelper.getWritableDatabase();
	}
	
	public Boolean InsertUser(ModelUser p_Info) {
		ContentValues _ContentValues = CreatParms(p_Info);
		Long p_NewID = m_SQLiteDatabase.insert("User", null, _ContentValues);
		p_Info.SetUserID(p_NewID.intValue());
		return p_NewID > 0;
	}
	
	public Boolean DeleteUser(String p_Condition)
	{
		return m_SQLiteDatabase.delete(GetTableNameAndPK()[0], " 1=1 " + p_Condition, null) >= 0;
	}
	
	public Boolean DeleteUserByUserID(int p_UserID)
	{
		String _Condition = " And UserID = " + p_UserID;
		Boolean _Result = DeleteUser(_Condition);
		return _Result;
	}
	
	public Boolean UpdateUser(String p_Condition, ModelUser p_Info)
	{
		ContentValues _ContentValues = CreatParms(p_Info);
		return m_SQLiteDatabase.update("User", _ContentValues, p_Condition, null) > 0;
	}
	
	public List<ModelUser> GetUser(String p_Condition)
	{
		String _SqlText = "Select * From User Where  1=1 " + p_Condition;
		Cursor _Cursor = m_SQLiteDatabase.rawQuery(_SqlText, null);
		return CursorToList(_Cursor);
	}
	
	protected List CursorToList(Cursor p_Cursor)
	{
		List _List = new ArrayList();
		while(p_Cursor.moveToNext())
		{
			Object _Object = FindModel(p_Cursor);
			_List.add(_Object);
		}
		p_Cursor.close();
		return _List;
	}
	
	public boolean IsExistUserByUserName(String p_UserName,Integer p_UserID)
	{
		String _Condition = " And UserName = '" + p_UserName + "'";
		if(p_UserID != null)
		{
			_Condition += " And UserID <> " + p_UserID;
		}
		List _List = GetUser(_Condition);
		if (_List.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean UpdateUserByUserID(ModelUser p_Info)
	{
		String _Condition = " UserID = " + p_Info.GetUserID();
		Boolean _Result = UpdateUser(_Condition, p_Info);
		
		if(_Result)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public ModelUser GetModelUserByUserID(int p_UserID)
	{
		List _List = GetUser(" And UserID = " + p_UserID);
		if(_List.size() == 1)
		{
			return (ModelUser)_List.get(0);
		}
		else
		{
			return null;
		}
	}
	
	protected ModelUser FindModel(Cursor p_Cursor)
	{
		ModelUser _ModelUser = new ModelUser();
		_ModelUser.SetUserID(p_Cursor.getInt(p_Cursor.getColumnIndex("UserID")));
		_ModelUser.SetUserName(p_Cursor.getString(p_Cursor.getColumnIndex("UserName")));
		SimpleDateFormat _DateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");	
		Date _CreateDate;
		try {
			_CreateDate = _DateFormat.parse(p_Cursor.getString(p_Cursor.getColumnIndex("CreateDate")));
			_ModelUser.SetCreateDate(_CreateDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		_ModelUser.SetState((p_Cursor.getInt(p_Cursor.getColumnIndex("State"))));
		
		return _ModelUser;
	}
	
	protected String[] GetTableNameAndPK() {
		return new String[]{"User","UserID"};
	}
	
	public ContentValues CreatParms(ModelUser p_Info) {
		ContentValues _ContentValues = new ContentValues();
		_ContentValues.put("UserName", p_Info.GetUserName());
		SimpleDateFormat _DateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		_ContentValues.put("CreateDate",_DateFormat.format(p_Info.GetCreateDate()));
		_ContentValues.put("State",p_Info.GetState());
		return _ContentValues;
	}
}
