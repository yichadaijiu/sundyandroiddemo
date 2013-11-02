package sundy.android.demo.datastore;

import sundy.android.demo.configration.CommonConstants;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

	public SQLiteHelper(Context context) {
		super(context, SQLiteDateBaseConfig.GetDataBaseName(), null, SQLiteDateBaseConfig.GetVersion());
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder _CreateTableScript = new StringBuilder();
		
		_CreateTableScript.append("		Create  TABLE User(");
		_CreateTableScript.append("				[UserID] integer PRIMARY KEY AUTOINCREMENT NOT NULL");
		_CreateTableScript.append("				,[UserName] varchar(10) NOT NULL");
		_CreateTableScript.append("				,[CreateDate] datetime NOT NULL");
		_CreateTableScript.append("				,[State] integer NOT NULL");
		_CreateTableScript.append("				)");

		db.execSQL(_CreateTableScript.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "DB updated")  ;
	}
}
