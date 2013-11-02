/**
 * 
 */
package sundy.android.demo.uibase;

import java.util.ArrayList;
import java.util.Calendar;

import sundy.android.demo.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker.OnDateChangedListener;

/**
 * @author Administrator
 *
 */
public class ViewActivity extends Activity {

	private String[] cities = {"成都","北京","上海","郑州"} ;
	private ArrayAdapter<String> adapter ;
	private Calendar cal ;
	private CustomView customView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_view)  ;
		
		
		//CustomView
		/*customView = (CustomView)findViewById(R.id.customView) ;
		customView.setText("Hello Custom View") ;
		if(customView != null)
		{
			customView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(ViewActivity.this, customView.getText(), 3000).show() ;
				}
			}) ;
		}
		
		//RadioButton
		RadioButton radioButton1 = (RadioButton)findViewById(R.id.radioButton1)  ;
		radioButton1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(ViewActivity.this, "RadioButton1 checked = "+arg1, Toast.LENGTH_LONG).show() ;
			}
			
		})  ;
		
		//RadioGroup
		RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1)  ;
		radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			
			//RadioButton radio1 = (RadioButton)findViewById(R.id.radio0)  ;
			//RadioButton radio2 = (RadioButton)findViewById(R.id.radio1)  ;
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == R.id.radio0)
					Toast.makeText(ViewActivity.this, "你选择了男性", Toast.LENGTH_SHORT).show() ;
				else if(checkedId == R.id.radio1)
					Toast.makeText(ViewActivity.this, "你选择了女性", Toast.LENGTH_SHORT).show() ;
				
			}
			
		}) ;*/
		
		//Spinner 
		Spinner spinner1 = (Spinner)findViewById(R.id.spinner1) ;
		adapter = new ArrayAdapter<String>(this,R.layout.layout_spinner_item,cities)  ;
		spinner1.setAdapter(adapter) ;
		/*ArrayList<MyItem> items = new ArrayList<MyItem>()  ;
		items.add(new MyItem("Sundy", "Tieto"))  ;
		items.add(new MyItem("Tudou", "Youku")) ;
		MySpinnerAdapter adapter = new MySpinnerAdapter(this, items)  ;
		spinner1.setAdapter(adapter) ;*/
		
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(ViewActivity.this, "你选择的城市是："+cities[arg2], Toast.LENGTH_SHORT).show() ;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(ViewActivity.this, "你什么都没有选中", Toast.LENGTH_SHORT).show() ;
			}
			
		}) ;
		
		//DatePicker 
		DatePicker dp = (DatePicker)findViewById(R.id.datePicker1) ;
		cal = Calendar.getInstance() ;
		dp.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener(){

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// TODO Auto-generated method stub
				cal.set(year, monthOfYear, dayOfMonth) ;
				Toast.makeText(ViewActivity.this, "时间是："+cal.getTime().toLocaleString() , Toast.LENGTH_SHORT).show() ;
				
				//AnalogClock acTest = (AnalogClock)findViewById(R.id.analogClock1) ;
				
			}


			
		}) ;
		
		
		//Menu
		
	}
	
	/*private void addNewButton()
	{
		LinearLayout ll = (LinearLayout)findViewById(R.id.linerLayout1)  ;
		
		Button newButton = new Button(this) ;
		newButton.setText("新按钮")  ;
		newButton.setHeight(123)  ;
		newButton.setId(123213213)  ;
		
		ll.addView(newButton)
	}*/
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_DPAD_UP)
		{
			Log.i("sundydemo", "你按下了五项按钮的上") ;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater mi = this.getMenuInflater()  ;
		mi.inflate(R.menu.view, menu) ;
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.itemAbout)//Notification
		{
			//Toast.makeText(ViewActivity.this, "Notification" , Toast.LENGTH_SHORT).show() ;
			
			//得到NotificationManager对象
			NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			
			int icon = R.drawable.icon;
			CharSequence tickerText = "催费通知";
			long when = System.currentTimeMillis();

			//构造一个Notification实例
			Notification notify = new Notification(icon, tickerText, when);
			
			PendingIntent pi = PendingIntent.getActivity(ViewActivity.this, 1234, new Intent(Intent.ACTION_DIAL,Uri.parse("tel:10086")), 0)  ;
			//Notification设置最新事件信息
			notify.setLatestEventInfo(ViewActivity.this, "你好，提醒缴费!", "您已经欠费三个月了，请尽快缴费", pi)  ;
			//启动提醒
			notifyManager.notify(1123, notify) ;
		}
			
		else if(item.getItemId() == R.id.itemExit)
			finish() ;
		else if(item.getItemId() == R.id.itemDialog)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
			builder.setTitle("关于我们")
			.setIcon(R.drawable.icon)
			.setMessage("我们是害虫") 
			.setNegativeButton("确定", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					arg0.cancel() ;
				}
				
			}) ;
			
			builder.create().show() ;
		}
		return super.onOptionsItemSelected(item);
	}

}
