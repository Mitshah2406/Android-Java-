package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate() method", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart() method", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause() method", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume() method", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop() method", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy() method", Toast.LENGTH_LONG).show();
    }
}