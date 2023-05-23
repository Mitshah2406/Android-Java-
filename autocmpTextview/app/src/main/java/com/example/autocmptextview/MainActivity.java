package com.example.autocmptextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView at;
    private String[] searchItems = {"Java", "Python", "C", "C++", "Flutter", "Dart", "Swing"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        at = (AutoCompleteTextView) findViewById(R.id.at);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_eg, searchItems);
        at.setAdapter(adapter);
        at.setThreshold(1);
    }
}