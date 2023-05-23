package com.example.wifinew;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button enableBtn, disableBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableBtn = (Button) findViewById(R.id.enable);
        disableBtn = (Button) findViewById(R.id.disable);

        enableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

                wifi.setWifiEnabled(true);
                Toast.makeText(MainActivity.this, "Enabled", Toast.LENGTH_SHORT).show();
            }
        });

        disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

                wifi.setWifiEnabled(false);
                Toast.makeText(MainActivity.this, "Disabled", Toast.LENGTH_SHORT).show();
            }
        });


    }
}