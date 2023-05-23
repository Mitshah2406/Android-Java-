package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startService(new Intent(MainActivity.this, MusicService.class));
                    }
                }
        ); stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        stopService(new Intent(MainActivity.this, MusicService.class));
                    }
                }
        );

    }
}