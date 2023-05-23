package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity{
    private EditText num,msg;
    private Button btn;
    private SmsManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        msg = findViewById(R.id.msg);
        btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm = SmsManager.getDefault();
                sm.sendTextMessage(num.getText().toString(), null ,msg.getText().toString(), null,null);
                Toast.makeText(getApplicationContext(), "Sent", Toast.LENGTH_LONG).show();
            }
        });
    }
}