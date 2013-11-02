package sundy.android.demo.datastore;

import java.util.List;
import sundy.android.demo.* ;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 实现一个自定义的UserAdapter
 *
 */
public class AdapterUser extends BaseAdapter {

	
	/**
	 * 存放要显示的控件的实体类，方便统一管理控件
	 *
	 */
	private class Holder
	{
		TextView Name;
	}
	
	private List m_List;
	private LayoutInflater m_LayoutInflater;
	
	
	public AdapterUser(Context p_Context)
	{
		BusinessUser _BusinessUser = new BusinessUser(p_Context);
		//获取全部用户List
		m_List = _BusinessUser.GetUser("");
		//从给定的context中获取LayoutInflater实例
		m_LayoutInflater = LayoutInflater.from(p_Context);
	}
	
	@Override
	public int getCount() {
		return m_List.size();
	}
	
	@Override
	public Object getItem(int position) {
		return m_List.get(position);
	}

	@Override
	public long getItemId(int position) {
		return (long)position;
	}

	@Override
	public View getView(int p_Position, View p_ConvertView, ViewGroup p_Parent) {
		Holder _Holder;
		
		//如果View内容为空则加载内容
		if (p_ConvertView == null) {
			//用一个布局文件填充该View
			p_ConvertView = m_LayoutInflater.inflate(R.layout.user_list_item, null);
			_Holder = new Holder();
			//找到控件，并初始化Holder里的控件
			_Holder.Name = (TextView)p_ConvertView.findViewById(R.id.tvUserName);
			//给View添加一个数据
			p_ConvertView.setTag(_Holder);
		}
		else {
			//如果View内容已经加载过不为空，则直接取Tag数据，并给Holder赋值
			_Holder = (Holder) p_ConvertView.getTag();
		}
		
		//得到该行的User实体类给控件赋值
		ModelUser _ModelUser = (ModelUser)getItem(p_Position);
		_Holder.Name.setText(_ModelUser.GetUserName());
		//返回控件
		return p_ConvertView;
	}
	
	public List GetList() {
		return m_List;
	}
}
