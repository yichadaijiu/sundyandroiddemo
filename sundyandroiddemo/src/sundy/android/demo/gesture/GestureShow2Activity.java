package sundy.android.demo.gesture;

import sundy.android.demo.R;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;

public class GestureShow2Activity extends Activity {

	private GestureLibrary myGestureLibrary ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gesture_2)  ;
		//myGestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures)  ;
		myGestureLibrary = GestureLibraries.fromFile("/sdcard/gestures") ;
		if(!myGestureLibrary.load())
			finish();
		GestureOverlayView gestureView = (GestureOverlayView)findViewById(R.id.gestureOverlayView1)  ;
		gestureView.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			
			@Override
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				// TODO Auto-generated method stub
				GestureRecognize.recognize(GestureShow2Activity.this, myGestureLibrary, gesture) ;
			}
		})  ;
	}

}
