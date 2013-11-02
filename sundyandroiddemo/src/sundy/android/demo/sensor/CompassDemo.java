package sundy.android.demo.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class CompassDemo extends Activity
{
    //传感器管理对象
	SensorManager manager;
                //传感器对象
	Sensor sensor;
                //界面
	OrenView view;
	
                //新建一个传感器事件监听器，重写其方法，主要是重写  onSensorChanged
	SensorEventListener listener = new SensorEventListener(){
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event)
	{
        //这个浮点数详细说明一下，是一个长度为三的浮点型数组，每一个元素在不同的传感器都有不同的含义。此处因为使用的是方向传感器，所以只关注第一个浮点数，即角度。而且这个角度是以相对于北方度数的一个角度（北方为0，顺时针转动，东方为90，南方为180，西方为270）
		float orentation = event.values[0];
		Log.i("####",""+orentation);
                                            //将这个值传向页面
		view.setDegree(orentation);
	}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //产生页面对象
        view = new OrenView(this);
        setContentView(view);
        
        //得到传感器管理对象
        manager = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
        //得到传感器对象，Sensor.TYPE_ORIENTATION是个静态int常量，表示不同的传感器
        sensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        //注册传感器，返回一个布尔值，用来判断是否注册成功，确定下一步操作
        //第三个参数表示传感器的灵敏度或者说刷新率
        //boolean reg = 
        	manager.registerListener(listener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    
    //注意重写这个方法，在这个方法中要执行传感器的注销
//否则当退出应用时传感器已然运作
    public void onStop(){
    	super.onStop();
    	manager.unregisterListener(listener, sensor);
    }
}
