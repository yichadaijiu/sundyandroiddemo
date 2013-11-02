package sundy.android.demo.maplocation;

import sundy.android.demo.R;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class GeoDemoActivity extends MapActivity implements LocationListener{
    /** Called when the activity is first created. */
	
	private MapView mMapView  ;
	private MapController mMapController  ;
	private GeoPoint point  ;
	private LocationManager mLocationManager ;
	private Location mLocation ;
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
    	menu.add(0, 1, 1, "交通地图")  ;
    	menu.add(0, 2, 2, "卫星地图")  ;
    	menu.add(0, 3, 3, "街景地图")  ;
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case 1:
			mMapView.setTraffic(true) ;
			mMapView.setSatellite(false)  ;
			mMapView.setStreetView(false)  ;
			break ;
		case 2:
			mMapView.setSatellite(true) ;
			mMapView.setTraffic(false) ;
			mMapView.setStreetView(false)  ;
			break  ;
		case 3:
			mMapView.setStreetView(true)  ;
			mMapView.setTraffic(false) ;
			mMapView.setSatellite(false)  ;			
			break ;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_geodemo);
        
        /**
         * 进行地图的加载
         */
        mMapView = (MapView)findViewById(R.id.mapView1)  ;
        //是否允许缩放
        mMapView.setBuiltInZoomControls(true)  ;
        //是否允许点击
        mMapView.setClickable(true)  ;
        //是否允许屏幕一直亮着
        mMapView.setKeepScreenOn(true) ;
        //设置长点击事件
        mMapView.setLongClickable(true)  ;
        //设置交通视图
        mMapView.setTraffic(true) ;
        
        /**
         * 加入设置位置功能
         */
        
        //得到地图控制对象
        mMapController = mMapView.getController()  ;
        mMapController.setZoom(18)  ;
        //得到成都天府广场的经纬度        
        updateMapShow(30.659259, 104.065762)   ;
        mMapController.setCenter(point)  ;
        
        /**
         * 给这个地点，加上一个mark
         * 标签
         */
        mMapView.getOverlays().add(new MyOverlay())  ;
        
        /**
         * 加入定位功能
         */
        
        mLocationManager =(LocationManager)getSystemService(LOCATION_SERVICE)  ;
        //1,得到我们的位置
        mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)  ;
        //2，更新我们的位置
        if(mLocation != null)
        {
        	updateMapShow(mLocation.getLatitude(), mLocation.getLongitude())  ;
        	mMapController.setCenter(point)  ;
        }
        else
        {
        	mLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)  ;
        	if(mLocation != null)
        	{
        		updateMapShow(mLocation.getLatitude(), mLocation.getLongitude())  ;
        		mMapController.setCenter(point)  ;
        	}
        	else
        		Toast.makeText(this, "得不到地理位置信息", 5000).show()  ;
        }   
        
    }
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		mLocationManager.removeUpdates(this) ;
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		/**
         * 跟踪我们的位置变化
         */
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 3, this)  ;
        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 5, this)  ;
		super.onResume();
	}

	/**根据 实际经纬度来显示地图
	 * @param lat
	 * @param lng
	 */
	private void updateMapShow(Double lat,Double lng) 
	{
		Double latI = lat*1E6  ;
		Double lngI = lng*1E6  ;
		point = new GeoPoint(latI.intValue(),lngI.intValue())  ;
		mMapController.animateTo(point)  ;
        
	}
	
	
	class MyOverlay extends Overlay
	{

		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow,
				long when) {
			// TODO Auto-generated method stub
			//得到位图
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.portal)  ;
			//得到了坐标点
			Point out = null ;
			out = mMapView.getProjection().toPixels(point, out)  ;
			//Paint paint = new Paint() ;
			//把位图画到画布上
			if(out != null)
				canvas.drawBitmap(bitmap, out.x, out.y, new Paint())  ;
			
			return true  ;
		}

		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			// TODO Auto-generated method stub
			Toast.makeText(GeoDemoActivity.this, "你点击了："+p.getLatitudeE6()+":"+p.getLongitudeE6(), Toast.LENGTH_LONG).show()  ;
			return true ;
		}

		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if(location != null)
			updateMapShow(location.getLatitude(), location.getLongitude())  ;
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}