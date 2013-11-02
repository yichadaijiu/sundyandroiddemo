package sundy.android.demo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBOperation {

	private SQLiteDatabase mSqLiteDatabase  ;
	private final String DATABASE_NAME = "sundy.demo.database" ;
	private final String USER_TABLE_NAME="users"  ;
	private Context mContext  ;
	public final String COLUMN_USERNAME = "username"  ;
	public final String COLUMN_ADRESS = "useraddress"  ;
	public final String COLUMN_AGE = "userage"  ;
	public DBOperation(Context context)
	{
		mContext = context  ;
	}
	
	public void openDatabase()
	{
		
	}
	
	public void createDatabase()
	{
		mSqLiteDatabase = mContext.openOrCreateDatabase(DATABASE_NAME, mContext.MODE_PRIVATE, null)  ;
		
		if(mSqLiteDatabase != null)
		{
			try {
				String findTableString = mSqLiteDatabase.findEditTable(USER_TABLE_NAME) ;
				if(findTableString == null || findTableString == "")
				{
					mSqLiteDatabase.execSQL("create TABLE "+USER_TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTO INCREASE,"+COLUMN_USERNAME+" VARCHAR(50)," +
							COLUMN_ADRESS+" VARCHAR(100),"+COLUMN_AGE+" INTEGER)")  ;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				Log.i("sundylog","db table exit") ;
			}
		}
		
		
	}
	
	public void closeDatabase()
	{
		mSqLiteDatabase.close() ;
		mSqLiteDatabase = null ;
	}
	
	/**
	 * 查询用户
	 * @param columns
	 * @param selection
	 * @param selectionArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return
	 */
	public Cursor queryUser(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)  
	{
		return mSqLiteDatabase.query(USER_TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy)  ;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public Cursor queryUserAll()
	{
		return mSqLiteDatabase.query(USER_TABLE_NAME, new String[]{"_id",COLUMN_USERNAME,COLUMN_ADRESS,COLUMN_AGE}, null, null, null, null, null)  ;
	}
	
	/**
	 * 添加用户信息
	 * @param newUser
	 * @return
	 */
	public long insertUser(User newUser)
	{
		if(mSqLiteDatabase != null)
		{
			ContentValues values = new ContentValues()  ;
			values.put(COLUMN_USERNAME, newUser.getUserName())  ;
			values.put(COLUMN_ADRESS, newUser.getUserAddress()) ;
			values.put(COLUMN_AGE, newUser.getUserAge())  ;
			return mSqLiteDatabase.insert(USER_TABLE_NAME, "no", values) ;
		}
		return -1  ;
	}
}
