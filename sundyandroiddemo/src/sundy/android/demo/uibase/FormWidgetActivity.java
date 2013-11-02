package sundy.android.demo.uibase;

import java.util.ArrayList;
import java.util.Calendar;

import org.xml.sax.XMLReader;

import sundy.android.demo.R;

import android.R.anim;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract.QuickContact;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.QuickContactBadge;
import android.widget.RatingBar;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormWidgetActivity extends Activity {
    /** Called when the activity is first created. */
	private ToggleButton toggButton  ;
	private ProgressBar mProgressBar  ;
	private SeekBar mSeekBar ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_formwidget)  ;
        //showTextView()  ;
        showButton() ;
        showToggleButton() ;
        showCheckBox() ;
        showRadioGroup() ;
        showSpinner() ;
        //showSpinner2()  ;
        showProgressBar() ;
        showSeekBar() ;
        
        showQuickContactBadge()  ;
        showRatingBar() ;
        showAutoCompleteTextView() ;
       
        GridView gridView1 = (GridView)findViewById(R.id.gridView1) ;
        String[] db = new String[]{"helo","sundy","googd morning","goode endfudf","dfsddf","todeath"} ;
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, db); 
        gridView1.setAdapter(adapter) ;
        showDatePicker()  ;
    }

    private void showDatePicker()
    {
    	DatePicker datePicker1 = (DatePicker)findViewById(R.id.datePicker1) ;
    	Calendar calendar = Calendar.getInstance()  ;
    	datePicker1.init(calendar.get(Calendar.YEAR)+1, calendar.get(Calendar.MONTH), 
    			calendar.get(Calendar.DAY_OF_MONTH), new OnDateChangedListener() {
					
					@Override
					public void onDateChanged(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						Toast.makeText(FormWidgetActivity.this, "Year:"+year+" Month:"+monthOfYear+" Day:"+dayOfMonth, 3000).show() ;
					}
				}) ;
    }
    
    private void showAutoCompleteTextView()
    {
    	AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1) ;
    	//建立数据源
    	String[] countries = new String[]{
    		  "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
    		  "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
    		  "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
    		  "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
    		  "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
    		  "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
    		  "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
    		  "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
    		  "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
    		  "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
    		  "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
    		  "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
    		  "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
    		  "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
    		  "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
    		  "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
    		  "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
    		  "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
    		  "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
    		  "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
    		  "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
    		  "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
    		  "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
    		  "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
    		  "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
    		  "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
    		  "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
    		  "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
    		  "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
    		  "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
    		  "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
    		  "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
    		  "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
    		  "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
    		  "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
    		  "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
    		  "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
    		  "Ukraine", "United Arab Emirates", "United Kingdom",
    		  "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
    		  "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
    		  "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"}  ; 
    	
    	//建立adapter 并且绑定数据源
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,countries)  ;
    	
    	//绑定ui
    	autoCompleteTextView.setAdapter(adapter)  ;
    }
    
    private void showRatingBar()
    {
    	RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1) ;
    	ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				Toast.makeText(FormWidgetActivity.this, "Rate:"+rating, 3000).show() ;
				
			}
		}) ;
    }
    
    private void showQuickContactBadge()
    {
    	QuickContactBadge qcb = (QuickContactBadge)findViewById(R.id.quickContactBadge1) ;
    	qcb.assignContactFromPhone("15608071832", true)  ;
    }
    
    private void showSeekBar()
    {
    	mSeekBar = (SeekBar)findViewById(R.id.seekBar1)  ;
    	mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Log.i("sundylog","stop:"+seekBar.getProgress())  ;
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Log.i("sundylog","start:"+seekBar.getProgress())  ;
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				Log.i("sundylog","start:"+"change:"+arg1)  ;
			}
		})  ;
    }
    
    private void showProgressBar()
    {
    	mProgressBar =(ProgressBar)findViewById(R.id.progressBar1) ;
    	
    }
    
    private void showSpinner2()
    {
    	Spinner spinner = (Spinner)findViewById(R.id.spinner1)  ;
    	//建立数据源
    	ArrayList<User> users = new ArrayList<User>() ;
    	users.add(new User("Sundy", "Chengdu"))  ;
    	users.add(new User("Zengbin", "Chengdu"))  ;
    	users.add(new User("luhe", "Beijing"))  ;
    	users.add(new User("All", "World")) ;
    	//建立Adapter并且制定数据源
    	UserAdapter userAdapter = new UserAdapter(this, users)  ;
    	//bind
    	spinner.setAdapter(userAdapter)  ;
    }
    
    private void showSpinner()
    {
    	Spinner spinner = (Spinner)findViewById(R.id.spinner1)  ;
    	//建立数据源
    	String[] myItemsStrings = getResources().getStringArray(R.array.spinnername)  ;
    	//建立Adapter ， 连接了数据源
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, myItemsStrings)  ;
    	//绑定adapter 到UI组件
    	spinner.setAdapter(adapter)  ;
    	/*spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String textString = ((TextView)(arg1.findViewById(R.id.textView1))).getText().toString() ; 
				Toast.makeText(FormWidgetActivity.this, textString , 3000).show() ;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		})  ;*/
    }
    
    private void showRadioGroup()
    {
    	RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1)  ;
    	radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    	{

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radio0:
					Toast.makeText(FormWidgetActivity.this, "RadioButton 1", 2000).show() ;
					break;
				case R.id.radio1:
					Toast.makeText(FormWidgetActivity.this, "RadioButton 2", 2000).show() ;
				case R.id.radio2:
					Toast.makeText(FormWidgetActivity.this, "RadioButton 3", 2000).show() ;
				default:
					break;
				}
			}
    		
    	}) ;
    }
    
    private void showCheckBox()
    {
    	CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox1)  ;
    	checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
			}
		})  ;
    }
    
    private void showToggleButton()
    {
    	toggButton = (ToggleButton)findViewById(R.id.toggleButton1) ;
    	toggButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					toggButton.setBackgroundResource(R.drawable.button1)  ;
					Toast.makeText(FormWidgetActivity.this, "开", 2000).show() ;
				}
				else
				{
					toggButton.setBackgroundResource(R.drawable.button2)  ;
					Toast.makeText(FormWidgetActivity.this, "关", 2000).show() ;
					
				}
			}
		}) ;
    }
    
    private void showButton()
    {
    	Button button1 = (Button)findViewById(R.id.button1)  ;
    	button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i("sundylog","onClicked")  ;
				mSeekBar.setProgress(mSeekBar.getProgress() + 3)  ;
				if(mSeekBar.getProgress() >= mSeekBar.getMax())
				{
					mSeekBar.setProgress(0)  ;
				}
				
			}
		})  ;
    	
    	button1.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				Log.i("sundylog","onLongClicked") ;
				return true ;
			}
		}) ;
    	
    }
    
    private void showTextView()
    {
    	
    	
    	
    	/*ImageGetter imageGetter = new Html.ImageGetter() {
			
			@Override
			public Drawable getDrawable(String source) {
				if(source != null)
				{
					// TODO Auto-generated method stub
					BitmapDrawable returnDrawable = (BitmapDrawable)getResources().getDrawable(R.drawable.name) ;
					returnDrawable.setBounds(0, 0, returnDrawable.getIntrinsicWidth(), returnDrawable.getIntrinsicHeight()) ;
					return returnDrawable ;
				}else {
					return null ;
				}
				
			}
		};
		
		TagHandler tagHandler = new Html.TagHandler() {
			
			@Override
			public void handleTag(boolean opening, String tag, Editable output,
					XMLReader xmlReader) {
				// TODO Auto-generated method stub
			
				Toast.makeText(FormWidgetActivity.this, tag, 2000).show()  ;
				
			}
		};*/
    	
    	TextView textView1 = (TextView)findViewById(R.id.textView1)  ;    	
    	SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("#大家好#，今天天气不错哦！")  ;    	
    	ImageSpan imageSpan = new ImageSpan(FormWidgetActivity.this, R.drawable.name)  ;
    	ClickableSpan clickableSpan = new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				// TODO Auto-generated method stub
				Toast.makeText(FormWidgetActivity.this, "你点击了", 3000).show() ;
			}
		};
    	
		
    	spannableStringBuilder.setSpan(imageSpan, 4, 5,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)  ;
    	spannableStringBuilder.setSpan(clickableSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE) ;
    	textView1.setText(spannableStringBuilder)  ;
    }
    
}