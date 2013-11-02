package sundy.android.demo.sensor;

import sundy.android.demo.R;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySensorShow extends Activity {

	private TextView m_txtSensorInfo;
	private TextView m_txtSensorX;
	private TextView m_txtSensorY;
	private TextView m_txtSensorZ;
	private int m_SensorType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_sensor_show);
		InitView();
		GetSensorType();
		RegisterSensor();
	}

	private void InitView() {
		m_txtSensorInfo = (TextView) findViewById(R.id.txtSensorInfo);
		m_txtSensorX = (TextView) findViewById(R.id.txtSensorX);
		m_txtSensorY = (TextView) findViewById(R.id.txtSensorY);
		m_txtSensorZ = (TextView) findViewById(R.id.txtSensorZ);
	}
	
	private void GetSensorType() {
		m_SensorType = getIntent().getExtras().getInt("SensorType");
	}
	
	public void RegisterSensor() {
		SensorManager _SM = (SensorManager)getSystemService(SENSOR_SERVICE);
		Sensor _Sensor = _SM.getDefaultSensor(m_SensorType);
		_SM.registerListener(m_SensorEventListener, _Sensor, SensorManager.SENSOR_DELAY_UI);
	}
	
	public void SensorInfo(Sensor _Sensor) {
		String tempString = "\n" + "  设备名称：" + _Sensor.getName() + "\n" + "  设备版本：" + _Sensor.getVersion() + "\n" + "  供应商："
		+ _Sensor.getVendor() + "\n" + "  最大值：" + _Sensor.getMaximumRange() + "\n" + "  精度：" + _Sensor.getResolution() + "\n" + "  功率（毫安）：" + _Sensor.getPower() + "\n" + "  类型：" + _Sensor.getType() + "\n";
		m_txtSensorInfo.setText(tempString);
	}
	
	SensorEventListener m_SensorEventListener = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			SensorInfo(event.sensor);
			float _x = event.values[SensorManager.DATA_X];
			float _y = event.values[SensorManager.DATA_Y];
			float _z = event.values[SensorManager.DATA_Z];
			
			m_txtSensorX.setText("Current Accelero x："+_x);
			m_txtSensorY.setText("Current Accelero y："+_y);
			m_txtSensorZ.setText("Current Accelero z："+_z);
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			
		}
	};
}
