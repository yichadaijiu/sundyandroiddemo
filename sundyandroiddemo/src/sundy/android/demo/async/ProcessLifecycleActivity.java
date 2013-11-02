/**
 * 鐔熸倝杩涚▼鐢熷懡鍛ㄦ湡鐨凞emo绫�
 */
package sundy.android.demo.async;

import java.util.List;

import sundy.android.demo.configration.CommonConstants;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ProcessLifecycleActivity extends Activity {
	
	/**褰撳墠杩涚▼淇℃伅瀹炰緥 */
	RunningAppProcessInfo curRunningProcessInfo ; 
	
	/**
	 * 鍒濆鍖栧苟涓斿緱鍒板綋鍓嶈繘绋嬩俊鎭�
	 */
	private void initCurProcess()
	{
		ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE) ;
		List<RunningAppProcessInfo> processList = am.getRunningAppProcesses() ;
		for(int i=0 ; i<processList.size(); i++)
		{
			if(processList.get(i).processName.equals(CommonConstants.APP_PACKAGE_NAME))
			{
				curRunningProcessInfo = processList.get(i) ;
				return  ;
			}
		}
	}
	
	/**
	 * 杞崲杩涚▼褰撳墠Level鏄剧ず鏂瑰紡锛岃int杞负String
	 * @param imp
	 * @return
	 */
	protected String convertImportance(int imp)
	{
		String returnStr = null  ;
		switch(imp)
		{
		case RunningAppProcessInfo.IMPORTANCE_FOREGROUND:
			returnStr = "IMPORTANCE_FOREGROUND" ;
			break  ;
		case RunningAppProcessInfo.IMPORTANCE_VISIBLE:
			returnStr = "IMPORTANCE_VISIBLE" ;
			break ;
		case RunningAppProcessInfo.IMPORTANCE_SERVICE:
			returnStr = "IMPORTANCE_SERVICE"  ;
			break ;
		case RunningAppProcessInfo.IMPORTANCE_BACKGROUND:
			returnStr = "IMPORTANCE_BACKGROUND" ;
			break ;
		case RunningAppProcessInfo.IMPORTANCE_EMPTY:
			returnStr = "IMPORTANCE_EMPTY" ;
			break ;
		default:
			break ;
			
		}
		return returnStr ;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initCurProcess() ;
		Log.i(CommonConstants.LOGCAT_TAG_NAME, convertImportance(curRunningProcessInfo.importance))  ;
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if(id == 1)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you want to exit?")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                ProcessLifecycleActivity.this.finish();
			           }
			       })
			       .setNegativeButton("No", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			//AlertDialog alert = builder.create();
		}
		
		return super.onCreateDialog(id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,0,1,"閫�嚭Activity") ;
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()==0)
		{
			this.showDialog(1) ;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, convertImportance(curRunningProcessInfo.importance))  ;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(CommonConstants.LOGCAT_TAG_NAME, convertImportance(curRunningProcessInfo.importance))  ;
	}

}
