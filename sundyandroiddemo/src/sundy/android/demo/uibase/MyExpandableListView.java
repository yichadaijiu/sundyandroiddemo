package sundy.android.demo.uibase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class MyExpandableListView extends ExpandableListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		
		
		//设置数据源
		List<HashMap<String, String>> groupData = new ArrayList<HashMap<String,String>>()  ;
		HashMap<String, String> _map1 = new HashMap<String, String>()  ;
		_map1.put("Name", "Sundy")  ;
		groupData.add(_map1)  ;
		_map1 = new HashMap<String, String>()  ;
		_map1.put("Name", "Zengbin")  ;
		groupData.add(_map1)  ;
		_map1 = new HashMap<String, String>()  ;
		_map1.put("Address", "Chengdu")  ;
		groupData.add(_map1)  ;
		
		
		List<List<HashMap<String, String>>> childData = new ArrayList<List<HashMap<String,String>>>() ;
		List<HashMap<String, String>> childItem = new ArrayList<HashMap<String,String>>() ;
		HashMap<String, String> _map2 = new HashMap<String, String>()  ;
		_map2.put("Name", "Sundy")  ;
		_map2.put("Name", "Zengbin")  ;
		_map2.put("Name", "Chengdu")  ;
		childItem.add(_map2) ;
		childData.add(childItem)  ;
		childData.add(childItem)  ;
		childData.add(childItem)  ;
		
		
		//建立Adapter ,并且绑定数据源
	
		ExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, groupData, android.R.layout.simple_expandable_list_item_1, android.R.layout.simple_expandable_list_item_1,
				new String[]{"Name","Address"}, new int[]{android.R.id.text1,android.R.id.text2}, childData, android.R.layout.simple_expandable_list_item_2, 
				new String[]{"Name","Address"}, new int[]{android.R.id.text1,android.R.id.text2}) ;
		
		
		
		//绑定界面
		setListAdapter(adapter)  ;
		
		
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		return super.onChildClick(parent, v, groupPosition, childPosition, id);
	}

	@Override
	public void onGroupCollapse(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupCollapse(groupPosition);
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupExpand(groupPosition);
		Toast.makeText(this, ""+groupPosition, 3000).show()  ;
	}

}
