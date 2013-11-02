package sundy.android.demo.sensor;

import java.util.List;

import sundy.android.demo.R;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SensorAdapter extends BaseAdapter {

	private Context m_Context; 
	private List<Sensor> m_List;
	private LayoutInflater m_LayoutInflater;
	
	private class Holder
	{
		String SensorName;
		int SensorType;
	}
	
	public SensorAdapter(Context p_Context,List<Sensor> p_List) {
		super();
		m_Context = p_Context;
		m_List = p_List;
		m_LayoutInflater = LayoutInflater.from(p_Context);
	}

	@Override
	public int getCount() {
		return m_List.size();
	}

	@Override
	public Sensor getItem(int position) {
		return m_List.get(position);
	}

	@Override
	public long getItemId(int position) {
		return (long) position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder _Holder;
		TextView _txtSensorName = null;
		if (convertView == null) {
			convertView = m_LayoutInflater.inflate(R.layout.layout_sensor_listitem, null);
			_Holder = new Holder();
			_txtSensorName = (TextView)convertView.findViewById(R.id.txtSensorInfo);
			convertView.setTag(_Holder);
		}
		else {
			_Holder = (Holder) convertView.getTag();
		}	
		Sensor _Sensor = getItem(position);
		_Holder.SensorName = _Sensor.getName();
		_txtSensorName.setText(_Holder.SensorName);
		
		return convertView;
	}

}
