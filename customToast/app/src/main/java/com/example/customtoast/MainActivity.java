package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
       btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               LayoutInflater inflater = getLayoutInflater();
               View layout = inflater.inflate(R.layout.mytoast, findViewById(R.id.ctRoot));
               Toast t = new Toast(getApplicationContext());
               t.setView(layout);
               t.setDuration(Toast.LENGTH_LONG);
               t.show();
           }
       });
    }
}