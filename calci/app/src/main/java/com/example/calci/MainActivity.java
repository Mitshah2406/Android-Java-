package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText num1,num2;
    private Button add, sub, mul ,div;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        res = (TextView) findViewById(R.id.res);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("Addition: "+ (Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num1.getText().toString())));
            }
        }); mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("Mul: "+ (Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num1.getText().toString())));
            }
        }); sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("Sub: "+ (Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num1.getText().toString())));
            }
        }); div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("Div: "+ (Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num1.getText().toString())));
            }
        });


    }
}