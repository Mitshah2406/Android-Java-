package com.example.asynceg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
//import android
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.btn);
        ProgressBar pg = findViewById(R.id.prg);
        TextView t = findViewById(R.id.st);
        myTask task = new myTask(pg,t);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.execute();
            }
        });

    }
}