package sundy.android.demo.uibase;

import java.util.List;

import sundy.android.demo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {

	List<User> mUsers  ;
	Context mContext  ;
	
	public UserAdapter(Context context , List<User> users)
	{
		mContext = context  ;
		mUsers = users  ;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mUsers.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mUsers.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1 = LayoutInflater.from(mContext).inflate(R.layout.user_item, null)  ;
		TextView textView1 = (TextView)arg1.findViewById(R.id.textView1)  ;
		TextView textView2 = (TextView)arg1.findViewById(R.id.textView2)  ;
		textView1.setText(mUsers.get(arg0).getUserName())  ;
		textView2.setText(mUsers.get(arg0).getUserAddress())  ;
		
		return arg1 ;
	}

}
