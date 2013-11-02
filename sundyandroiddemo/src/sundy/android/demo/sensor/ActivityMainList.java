package sundy.android.demo.sensor;

import java.util.List;

import sundy.android.demo.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ActivityMainList extends Activity implements OnClickListener {
	
//	private Button m_btnAccelerometer;
	private ListView m_lstSensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_sensor_list);
		InitView();
		InitListener();
		BindData();	
	}
	
	private void InitView() {
//		m_btnAccelerometer = (Button) findViewById(R.id.btnAccelerometer);
		m_lstSensor = (ListView) findViewById(R.id.lstSensor);
	}
	
	private void InitListener() {
//		m_btnAccelerometer.setOnClickListener(this);
		m_lstSensor.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Sensor _Sensor = (Sensor) arg0.getAdapter().getItem(arg2);
				Intent _Intent = new Intent(ActivityMainList.this, ActivitySensorShow.class);
				_Intent.putExtra("SensorType", _Sensor.getType());
				startActivity(_Intent);
			}
		});
	}
	
	private void BindData() {
		List<Sensor> _List = GetSensorList();
		m_lstSensor.setAdapter(new SensorAdapter(this, _List));
	}
	
	private List<Sensor> GetSensorList() {
		SensorManager _SM = (SensorManager) getSystemService(SENSOR_SERVICE);
		List<Sensor> _List = _SM.getSensorList(Sensor.TYPE_ALL);
		return _List;
	}

	@Override
	public void onClick(View v) {
		int _ID = v.getId();
		
		switch (_ID) {
		case R.id.btnAccelerometer:
			Intent _Intent = new Intent(ActivityMainList.this, ActivitySensorShow.class);
			_Intent.putExtra("Accelerometer", Sensor.TYPE_ACCELEROMETER);
			startActivity(_Intent);
			break;

		default:
			break;
		}
	}


}
