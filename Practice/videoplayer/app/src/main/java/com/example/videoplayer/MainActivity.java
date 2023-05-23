package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {
        private VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv=  findViewById(R.id.vv);

        vv.setVideoURI(Uri.parse("https://youtu.be/LTylMlbwMRM"));
        vv.start();

        MediaController mc = new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
    }
}