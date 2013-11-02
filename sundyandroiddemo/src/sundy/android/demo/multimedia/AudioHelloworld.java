/**
 * @author Sundy
 * @description Multimedai application demo .
 */
package sundy.android.demo.multimedia;

import java.io.IOException;

import sundy.android.demo.R;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author cninsuzh
 *
 */
public class AudioHelloworld extends Activity {

	private final String EXTENAL_FILE_PATH = "file:///sdcard/maria.mp3"  ;
	private final String INITENT_FILE_PATH = "http://zhangmenshiting.baidu.com/data/music/9530498/%E9%AD%94%E9%AC%BC%E4%B8%AD%E7%9A%84%E5%A4%A9%E4%BD%BF.mp3?xcode=f15decd30d7945b192a179a2c2755e2c&mid=0.28647020591845" ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_audiohelloworld) ;
		//set the first audio playing listener . 
		Button buttonSimple = (Button)findViewById(R.id.buttonFirstAudio)  ;
		buttonSimple.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				MediaPlayer mp = MediaPlayer.create(AudioHelloworld.this, sundy.android.demo.R.raw.maria) ;
				mp.start() ; // no need to call prepare(); create() does that for you
			}
			
		}) ;
		
		//play the audio file from extental card  . 
		//Notification: before this demo  , please push one mp3 file into the sdcard path
		Button buttonExtenalCard = (Button)findViewById(R.id.ButtonAudioDatasource)  ;
		buttonExtenalCard.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Uri myUri = Uri.parse(EXTENAL_FILE_PATH)  ;
				MediaPlayer mediaPlayer = new MediaPlayer()  ;
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)  ;
				
				try {
					mediaPlayer.setDataSource(AudioHelloworld.this, myUri)  ;
					mediaPlayer.prepare()  ;
					mediaPlayer.start()  ;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			
		}) ;
		
		
		//Play the audio file from internet  .
		Button buttonAudioUri = (Button)findViewById(R.id.ButtonAudioUri)  ;
		buttonAudioUri.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Uri myUri = Uri.parse(INITENT_FILE_PATH)  ;
				MediaPlayer mediaPlayer = new MediaPlayer()  ;
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)  ;
				
				try {
					mediaPlayer.setDataSource(AudioHelloworld.this, myUri)  ;
					//might take long time ! (for buffering , etc) 
					mediaPlayer.prepare()  ;
					mediaPlayer.start()  ;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		})  ;
		
		//Play the audio file from AsyncPrepare
		Button buttonAsyncPrepare = (Button)findViewById(R.id.ButtonAsynchPrepare)  ;
		buttonAudioUri.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Uri myUri = Uri.parse(INITENT_FILE_PATH)  ;
				MediaPlayer mediaPlayer = new MediaPlayer()  ;
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)  ;
				mediaPlayer.setOnPreparedListener(new OnPreparedListener()
				{

					@Override
					public void onPrepared(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						arg0.start()  ;
					}
					
				}) ;
				mediaPlayer.prepareAsync()  ;
			}
			
		})  ;
		
		//Control the states of playback  .
		
		//Using a Service with MediaPlayer  .
		
		//Handling asynchronous erros 
		
		//using wake locks  .
		
		//Running as a foreground service 
		
	}

}
