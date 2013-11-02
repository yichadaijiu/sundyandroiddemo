package sundy.android.demo.uiadv.performance;

import sundy.android.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DelayLoadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delay_load);

        Button btn = (Button) findViewById(android.R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                ViewStub stub = (ViewStub) findViewById(R.id.stub);
                View inflated = stub.inflate();
            }});
    }

}
