package sundy.android.demo.widget;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import sundy.android.demo.R;

import android.app.LauncherActivity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class SimpleWidgetDemo extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for(int appWidgetId : appWidgetIds)
		{
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_simplewidget) ;
			PendingIntent _pendingIntent = PendingIntent.getActivity(context, 1234, new Intent(context,LauncherActivity.class), 0)  ;
			
			remoteViews.setOnClickPendingIntent(R.id.buttonSimpleWidget, _pendingIntent)  ;
			appWidgetManager.updateAppWidget(appWidgetId, remoteViews)  ;
		}
	
	}

}
