package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private ProgressBar pg;
        private Button btn;
        private TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg = findViewById(R.id.pbH);
        btn = findViewById(R.id.btn);
        tw = findViewById(R.id.tw);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility(View.VISIBLE);
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {

                                try{
                                    for(int i =1 ; i<=100;i++){

                                        Thread.sleep(50);
                                        pg.setProgress(i);
                                    }
                                }catch(Exception e){}
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        pg.setVisibility(View.GONE);
                                    }
                                });
                            }


                        }
                ).start();

            }
        });
    }

    private void runOnUiThread() {
    }
}