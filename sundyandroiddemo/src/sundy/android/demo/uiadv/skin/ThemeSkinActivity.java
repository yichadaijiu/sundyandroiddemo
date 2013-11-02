package sundy.android.demo.uiadv.skin;

import sundy.android.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThemeSkinActivity extends Activity{

    private final static String KEY_USE_THEME = "USE_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null)
        {
            int themeId = intent.getIntExtra(KEY_USE_THEME, 0);
            if (themeId != 0)
            {
                setTheme(themeId);
            }
        }

        setContentView(R.layout.theme_skin);

        Button btn1 = (Button) findViewById(android.R.id.button1);
        Button btn2 = (Button) findViewById(android.R.id.button2);

        btn1.setOnClickListener(new ThemeButtonOnClickListener(R.style.MyTextStyle1));
        btn2.setOnClickListener(new ThemeButtonOnClickListener(R.style.MyTextStyle2));
    }

    private class ThemeButtonOnClickListener implements OnClickListener {

        private final int mThemeId;
        public ThemeButtonOnClickListener(int themeId) {
            mThemeId = themeId;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ThemeSkinActivity.this, ThemeSkinActivity.class);
            intent.putExtra(KEY_USE_THEME, mThemeId);
            startActivity(intent);
            finish();
        }

    }

}
