package sundy.android.demo.datastore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sundy.android.demo.* ;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FileOperationDemo extends Activity implements OnClickListener {
	Button btnSaveUserName;
	Button btnClearUserName;
	EditText etUserName;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_preference_demo);
		InitView();
		InitListeners();
		
		LoadUserName();
	}
	
	private void InitView() {
		btnSaveUserName = (Button) findViewById(R.id.btnSaveUserName);
		btnClearUserName = (Button) findViewById(R.id.btnClearUserName);
		etUserName = (EditText) findViewById(R.id.etUserName);
	}
	
	private void InitListeners() {
		btnSaveUserName.setOnClickListener(this);
		btnClearUserName.setOnClickListener(this);
		etUserName.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSaveUserName:
			SaveUserName();
			break;
		case R.id.btnClearUserName:
			ClearUserName();
			break;
		default:
			break;
		}
	}
	
	private void SaveUserName()
	{
		Write(etUserName.getText().toString());
	}
	
	private void LoadUserName()
	{
		String _Message = Read();
		etUserName.setText(_Message);
	}
	
	private void ClearUserName()
	{
		Write("");
		etUserName.setText("");
	}
	
	private void Write(String p_Message) {
		//得到可用的SD卡路径
		String _SDCardPath = GetExternalStoragePath();
		if (_SDCardPath != null) {
			String _LogFolderPath = "/Log/";
			String _LogFilePath = _SDCardPath + _LogFolderPath + "Log.txt";
			try {
				//根据定义好的文件路径生成该文件
				CreateFile(_LogFilePath);
				//根据路径获取该文件流
				FileOutputStream _FileOutputStream = new FileOutputStream(_LogFilePath);
				byte[] bytes = p_Message.getBytes();
				//把转换好的信息写入该文件中
				_FileOutputStream.write(bytes);
				//关闭文件流
				_FileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String Read()
	{
		//得到可用的SD卡路径
		String _SDCardPath = GetExternalStoragePath();
		if (_SDCardPath != null) {
			String _LogFolderPath = "/Log/";
			String _LogFilePath = _SDCardPath + _LogFolderPath + "Log.txt";
			try {
				//根据定义好的文件路径得到该文件流
				FileInputStream _FileInputStream = new FileInputStream(_LogFilePath);
				//获取文件流数据长度
				int _Length = _FileInputStream.available(); 
			    byte [] _Buffer = new byte[_Length];
			    //读取内容
			    _FileInputStream.read(_Buffer);     
//			    res = EncodingUtils.getString(_Buffer, "UTF-8");
			    //将字节转换为String
			    String _Message = new String(_Buffer);
			    //关闭流
			    _FileInputStream.close();
			    return _Message;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		else
		{
			return "没有找到SD卡";
		}
	}
	
	/**
	 * 
	 * 获取SdCard路径
	 */
	private String GetExternalStoragePath() {
		// 获取SdCard状态
		String _State = android.os.Environment.getExternalStorageState();

		// 判断SdCard是否存在并且是可用的
		if (android.os.Environment.MEDIA_MOUNTED.equals(_State)) {
			if (android.os.Environment.getExternalStorageDirectory().canWrite()) {
				return android.os.Environment.getExternalStorageDirectory().getPath();
			}
		}

		return null;
	}
	
	private void CreateFile(String p_Path) throws IOException
	{
		File _LogFile = new File(p_Path);
		if(!_LogFile.exists())
		{
			String _FolderPath = p_Path.substring(0,p_Path.lastIndexOf("/"));
			IsFolderExists(_FolderPath);
			_LogFile.createNewFile();
		}
	}
	
	/**
	 * 只在SD卡上建立一级目录（"/sdcard/audio/")
	 * @param strFolder
	 * @return
	 */
	private boolean IsFolderExists(String p_Folder)
    {
        File _File = new File(p_Folder);      
        if (!_File.exists())
        {
            if (_File.mkdir())
            {
                return true;
            }
            else
                return false;
        }
        return true;
    }
}