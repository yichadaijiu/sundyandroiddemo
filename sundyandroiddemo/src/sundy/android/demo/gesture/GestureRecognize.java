package sundy.android.demo.gesture;

import java.util.ArrayList;

import sundy.android.demo.configration.CommonConstants;

import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.Prediction;
import android.util.Log;

public class GestureRecognize {
	
	//page index mark
	private static int index = 1 ;
	
	
	
	/**
	 * 识别手势，匹配手势库返回结果
	 * @param curContext 当前的activity上下文
	 * @param myGestureLibrary 需要对比的手势库
	 * @param gesture 当前监听到的手势
	 */
	static void recognize(Context curContext ,GestureLibrary myGestureLibrary , Gesture gesture)
	{		
		
		ArrayList<Prediction> predictions = myGestureLibrary.recognize(gesture) ;
		if(predictions.size()>0)
		{
			Prediction prediction = predictions.get(0)  ;
			if(prediction.score > 3.0)
			{
				Log.i(CommonConstants.LOGCAT_TAG_NAME, prediction.name) ;
				if(prediction.name.equals("next"))
				{
					switch (index) {
					case 1:
						curContext.startActivity(new Intent(curContext,GestureShow2Activity.class))  ;
						++ index ;
						break ;
					case 2:
						curContext.startActivity(new Intent(curContext,GestureShow3Activity.class))  ;
						++ index ;
						break ;
					case 3:
						curContext.startActivity(new Intent(curContext,GestureShow4Activity.class))  ;
						++ index ;
						break ;
					case 4:
						curContext.startActivity(new Intent(curContext,GestureShow1Activity.class))  ;
						index = 1 ;
						break;

					default:
						break;
					}
					
					
				}else if(prediction.name.equals("end"))
					curContext.startActivity(new Intent(curContext,GestureShow4Activity.class))  ;
				else if(prediction.name.equals("first"))
					curContext.startActivity(new Intent(curContext,GestureShow1Activity.class))  ;
				else if(prediction.name.equals("prev"))
				{
					
				}
				else if(prediction.name.equals("create"))
				{
					curContext.startActivity(new Intent(curContext,GestureCreateAtivity.class))  ;
				}
			}
		}
	}
}
