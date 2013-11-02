package sundy.android.demo.uiadv.shake_desk;

import sundy.android.demo.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Collections;
import java.util.List;

public class ShakeDesktopActivity extends Activity implements OnItemClickListener
{

    private LayoutInflater mInflater;
    private PackageManager mPackageManager;

    private ApplicationContainerAdapter mAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPackageManager = getPackageManager();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ApplicationInfoContainer container = new ApplicationInfoContainer(this, null, 0);
        container.setAdapter(new ApplicationContainerAdapter(this));
        container.setOnItemClickListener(this);
        setContentView(container);
    }

    private class ApplicationContainerAdapter extends ItemContainerAdapter<ResolveInfo> {

        ApplicationContainerAdapter(Context context) {
            super(context, getAppInfoList(context));
        }

        @Override
        public void onBindView(View v, int position) {
            ResolveInfo info = mItemList.get(position);

            ImageView image = (ImageView)v.findViewById(android.R.id.icon);
            TextView text = (TextView)v.findViewById(android.R.id.text1);

            image.setImageDrawable(info.activityInfo.loadIcon(mPackageManager));
            text.setText(info.activityInfo.loadLabel(mPackageManager));
        }

        @Override
        public void onHideView(View v) {
            ImageView image = (ImageView)v.findViewById(android.R.id.icon);
            TextView text = (TextView)v.findViewById(android.R.id.text1);

            image.setImageResource(android.R.color.transparent);
            text.setText("");
        }

        @Override
        protected View onCreateItemView(int position, ViewGroup parent) {
            View v = mInflater.inflate(R.layout.app_container_item, null);
            return v;
        }

    };

    private static List<ResolveInfo> getAppInfoList(Context context) {
        PackageManager manager = context.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = manager.queryIntentActivities(mainIntent, 0);
        Collections.sort(apps, new ResolveInfo.DisplayNameComparator(manager));
        return apps;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id)
    {
        //Launch application
        ResolveInfo info = mAdapter.getItem(position);
        String packageName = info.activityInfo.packageName;
        String activityName = info.activityInfo.name;


//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        intent.setComponent(new ComponentName(packageName, activityName));
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
//                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//        mContext.startActivity(intent);
    }
}