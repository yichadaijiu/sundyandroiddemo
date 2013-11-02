package sundy.android.demo.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		MediaPlayer mp = MediaPlayer.create(this, sundy.android.demo.R.raw.maria) ;
		mp.start() ;
		return super.onStartCommand(intent, flags, startId);
	}

}
