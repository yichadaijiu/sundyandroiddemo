package sundy.android.demo.uiadv.style;

import sundy.android.demo.R;
import android.app.Activity;
import android.os.Bundle;

public class StyleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setTheme(R.style.MyTheme);
        setContentView(R.layout.layout_style2);
    }
    
}
