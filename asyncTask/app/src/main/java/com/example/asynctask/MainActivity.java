package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private ProgressBar pg;
        private TextView status;
        private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pg = findViewById(R.id.progress);
        status = findViewById(R.id.status);
        start = findViewById(R.id.start);

        egTask e = new egTask(pg,status);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.execute();
            }
        });

    }
}