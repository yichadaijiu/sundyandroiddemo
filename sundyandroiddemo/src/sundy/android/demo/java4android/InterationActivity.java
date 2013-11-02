/**
 * @author Sundy
 * @description Interation demo
 */
package sundy.android.demo.java4android;

import sundy.android.demo.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.LinearLayout;

/**
 * @author Administrator
 *
 */
public class InterationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//String aColors[] = getResources().getStringArray(R.array.colorsArray);
		String aColors[] = getResources().getStringArray(R.array.colorsArray);
		//looping display ...
		Log.i("sundy", String.valueOf(aColors.length)) ;
		
		LinearLayout layoutRoot = new LinearLayout(this) ;
		layoutRoot.setOrientation(LinearLayout.VERTICAL)  ;
		LinearLayout.LayoutParams lpFF = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT) ;
		LayoutParams lpWW = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT) ;
		layoutRoot.setLayoutParams(lpFF)  ;
		
		
		TextView tempTextView  ;
		for(int i=0 ; i<aColors.length;i++)
		{
			tempTextView = new TextView(this) ;
			tempTextView.setText("ÑÕÉ«²âÊÔ") ;
			tempTextView.setBackgroundColor(Color.parseColor(aColors[i])) ;
			layoutRoot.addView(tempTextView, lpWW) ;
		}
		
		setContentView(layoutRoot) ;
		
	}

}
