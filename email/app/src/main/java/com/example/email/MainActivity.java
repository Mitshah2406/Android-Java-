package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText sendTo, sub, body;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendTo = findViewById(R.id.sendto);
        sub = findViewById(R.id.sub);
        submit = findViewById(R.id.submit);
        body = findViewById(R.id.body);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent send = new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL, new String[] {sendTo.getText().toString()});
                send.putExtra(Intent.EXTRA_SUBJECT, sub.getText().toString());
                send.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                send.setType("message/cfg822");
                startActivity(Intent.createChooser(send,"Choose Email bc"));
            }
        });
    }
}