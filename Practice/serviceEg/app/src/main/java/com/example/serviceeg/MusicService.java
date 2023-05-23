package com.example.serviceeg;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MusicService extends Service{

    public IBinder onBind(Intent intent){
        return  null;
    }
    MediaPlayer mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
    public int onStartCommand(Intent intent, int flags, int startId){
        mp.start();
        mp.setLooping(true);
        return START_NOT_STICKY;
    }
    public void onDestroy(){
        mp.stop();
        super.onDestroy();
    }
}
