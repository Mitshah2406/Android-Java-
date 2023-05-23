package com.example.service;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

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
