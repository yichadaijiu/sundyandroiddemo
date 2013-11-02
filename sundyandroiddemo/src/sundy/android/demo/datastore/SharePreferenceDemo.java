package sundy.android.demo.datastore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import sundy.android.demo.* ;

public class SharePreferenceDemo extends Activity implements OnClickListener {
	
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
//		MODE_PRIVATE：为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，如果想把新写入的内容追加到原文件中，可以使用MODE_APPEND
//		MODE_APPEND：模式会检查文件是否存在，存在就往文件追加内容，否则就创建新文件
//		MODE_WORLD_READABLE和MODE_WORLD_WRITEABLE用来控制其他应用是否有权限读写该文件
//		MODE_WORLD_READABLE：表示当前文件可以被其他应用读取；MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入
		
		//获取指定Key的SharedPreferences对象
		SharedPreferences _SP = getSharedPreferences("SharePreferenceDemo",MODE_WORLD_WRITEABLE);
		//获取编辑
		SharedPreferences.Editor _Editor = _SP.edit();
		//按照指定Key放入数据
		_Editor.putString("UserName", etUserName.getText().toString());
		//提交保存数据
		_Editor.commit();
	}
	
	private void LoadUserName()
	{
		//获取指定Key的SharedPreferences对象
		SharedPreferences _SP = getSharedPreferences("SharePreferenceDemo",MODE_WORLD_READABLE);
		//数据为空证明还不存在
		if (_SP != null) {
			//否则就获取指定Key的数据
			String _UserName = _SP.getString("UserName", "");
			etUserName.setText(_UserName);
		}
	}
	
	private void ClearUserName()
	{
		//获取指定Key的SharedPreferences对象
		SharedPreferences _SP = getSharedPreferences("SharePreferenceDemo",MODE_WORLD_READABLE);
		if (_SP != null) {
			//获取编辑
			SharedPreferences.Editor _Editor = _SP.edit();
			//清除
			_Editor.clear();
			//提交数据
			_Editor.commit();
			etUserName.setText("");
		}
	}
}