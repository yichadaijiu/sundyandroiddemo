
package sundy.android.demo.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import sundy.android.demo.R;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.EditText;

/**
 * @author Sundy
 * Confirm the difference between Assets and Raw folders .
 */
public class AssetsAndRawActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_assetsandraw)  ;
		readFromAssets()  ;
		readFromRaw()  ;
	}
	
	/**
	 * 从assets读取并且显示
	 */
	private void readFromAssets()
	{
		AssetManager _assetManager = getAssets()  ;
		EditText _EditText = (EditText)findViewById(R.id.editTextReadFromRaw)  ;
		if(_EditText != null)
		{
			try {
				_EditText.setText(readStream(_assetManager.open("simple.txt"))) ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 从raw读取并且显示
	 */
	private void readFromRaw()
	{
		InputStream _InputStream = getResources().openRawResource(R.raw.simple)  ;
		EditText _EditText = (EditText)findViewById(R.id.editTextReadFromAssets)  ;
		if(_EditText != null)
		{
			_EditText.setText(readStream(_InputStream)) ;
		}
		
	}
	
	
	/**读取流
	 * @param is
	 * @return
	 */
	private String readStream(InputStream is) {
        
        try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while(i != -1) {
                        bo.write(i);
                        i = is.read();
                }
                
                return bo.toString();
        } catch (IOException e) {
                return "";
        }
	}

}
