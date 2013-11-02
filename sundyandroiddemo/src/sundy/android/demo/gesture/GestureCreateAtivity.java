package sundy.android.demo.gesture;

import sundy.android.demo.R;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GestureCreateAtivity extends Activity {

	private GestureLibrary myGestureLibrary ;
	private Gesture mGesture ;
	private Button buttonSave ;
	private EditText editTextSave ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gesturecreate)  ;
		
		setContentView(R.layout.layout_gesture_1)  ;
		//myGestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures)  ;
		myGestureLibrary = GestureLibraries.fromFile("/sdcard/gestures") ;
		if(!myGestureLibrary.load())
			finish();
		GestureOverlayView gestureView = (GestureOverlayView)findViewById(R.id.gestureOverlayViewCreate)  ;
		gestureView.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			
			@Override
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				// TODO Auto-generated method stub
				mGesture = gesture ;
				
				
			}
		})  ;
		
		editTextSave = (EditText)findViewById(R.id.editTextCreate) ;
		
		buttonSave = (Button)findViewById(R.id.buttonCreateGesture)  ;
		buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(mGesture != null)
				{
					myGestureLibrary.addGesture(editTextSave.getText().toString(), mGesture)  ;
					myGestureLibrary.save() ;
					Toast.makeText(GestureCreateAtivity.this, "生成手势："+editTextSave.getText().toString(), 3000)  ;
					buttonSave.setText("")  ;
				}
				
			}
		}) ;
		
	}

}
