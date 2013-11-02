package sundy.android.demo.sensor;

import sundy.android.demo.R;
import android.app.Activity;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityMain extends Activity {
    TextView myTextView1;//t
    //gen
    TextView myTextView2;//x
    TextView myTextView3;//y
    TextView myTextView4;//z
    //acc
    TextView myTextView5;//x
    TextView myTextView6;//y
    TextView myTextView7;//z
   //ori
    TextView myTextView8;//x
    TextView myTextView9;//y
    TextView myTextView10;//z
    //Light
    TextView myTextView11;//z
    //Proximity
    TextView myTextView12;//z
    
    SensorManager  mySensorManager;//
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sensor_main);
        myTextView1 = (TextView) findViewById(R.id.myTextView1);
        myTextView2 = (TextView) findViewById(R.id.myTextView2);
        myTextView3 = (TextView) findViewById(R.id.myTextView3);
        myTextView4 = (TextView) findViewById(R.id.myTextView4);
        myTextView5 = (TextView) findViewById(R.id.myTextView5);
        myTextView6 = (TextView) findViewById(R.id.myTextView6);
        myTextView7 = (TextView) findViewById(R.id.myTextView7);
        myTextView8 = (TextView) findViewById(R.id.myTextView8);
        myTextView9 = (TextView) findViewById(R.id.myTextView9);
        myTextView10 = (TextView) findViewById(R.id.myTextView10);
        myTextView11 = (TextView) findViewById(R.id.myTextView11);
        myTextView12 = (TextView) findViewById(R.id.myTextView12);
        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    private SensorListener mySensorListener = new SensorListener(){
    	@Override
    	public void onAccuracyChanged(int sensor, int accuracy) {}	
    	@Override
    	public void onSensorChanged(int sensor, float[] values) {		
    		if(sensor == SensorManager.SENSOR_TEMPERATURE){
    			myTextView1.setText("Current Temprature£º"+values[0]);	
    		}else if(sensor == SensorManager.SENSOR_MAGNETIC_FIELD){
    			myTextView2.setText("Current Magnetic x£º"+values[0]);
    			myTextView3.setText("Current Magnetic y£º"+values[1]);
    			myTextView4.setText("Current Magnetic z£º"+values[2]);
    		}else if(sensor == SensorManager.SENSOR_ACCELEROMETER){
    			myTextView5.setText("Current Accelero x£º"+values[0]);
    			myTextView6.setText("Current Accelero y£º"+values[1]);
    			myTextView7.setText("Current Accelero z£º"+values[2]);
    		}else if(sensor == SensorManager.SENSOR_ORIENTATION){
    			myTextView8.setText("Current Oraenttation x£º"+values[0]);
    			myTextView9.setText("Current Oraenttation y£º"+values[1]);
    			myTextView10.setText("Current Oraenttation z£º"+values[2]);
    		}else if(sensor == SensorManager.SENSOR_LIGHT){
    			myTextView11.setText("Current Oraenttation x£º"+values[0]);
    		}else if(sensor == SensorManager.SENSOR_PROXIMITY){
    			myTextView12.setText("Current Proximity x£º"+values[0]);
    		}
    	}
    };
    @Override
    protected void onResume() {
    	mySensorManager.registerListener(
    			mySensorListener, 
    			SensorManager.SENSOR_TEMPERATURE | 
    			SensorManager.SENSOR_MAGNETIC_FIELD | 
    			SensorManager.SENSOR_ACCELEROMETER | 
    			SensorManager.SENSOR_LIGHT |
                SensorManager.SENSOR_ORIENTATION |
                SensorManager.SENSOR_PROXIMITY,
    			SensorManager.SENSOR_DELAY_UI
    			);
    	super.onResume();
    }	
    @Override
    protected void onPause() {
    	mySensorManager.unregisterListener(mySensorListener);
    	super.onPause();
    }

}