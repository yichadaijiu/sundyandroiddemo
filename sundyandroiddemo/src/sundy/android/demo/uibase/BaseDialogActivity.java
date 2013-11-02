package sundy.android.demo.uibase;

import sundy.android.demo.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_basedialog)  ;
		showAlertDialog()  ;
		showCustomDialog() ;
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if(id == 110)
		{
			Dialog dialog = new Dialog(BaseDialogActivity.this) ;
			dialog.setContentView(R.layout.layout_customdialog) ;
			dialog.setTitle("Custom Dialog") ;
			return dialog  ;
		}
		return super.onCreateDialog(id);
	}

	private void showCustomDialog()
	{
		Button buttonAlert = (Button)findViewById(R.id.buttonCustomDialog) ;
		
		buttonAlert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Dialog dialog = new Dialog(BaseDialogActivity.this) ;
				dialog.setContentView(R.layout.layout_customdialog) ;
				dialog.setTitle("Custom Dialog") ;
				//showDialog(110) ;
				dialog.show()  ;
			}
		})  ;
	}
	
	private void showAlertDialog()
	{
		Button buttonAlert = (Button)findViewById(R.id.buttonAlertDialog) ;
		
		buttonAlert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog dialog = new AlertDialog.Builder(BaseDialogActivity.this).setIcon(R.drawable.icon)
				.setMessage("Hello Sundy ,Exit ?")
				.setCancelable(false)
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						arg0.cancel()  ;
					}
				})  
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						BaseDialogActivity.this.finish() ;
					}
				})
				.setTitle("Exit Dialog")
				.show()  ;
				
				
			}
		})  ;
	}

}
