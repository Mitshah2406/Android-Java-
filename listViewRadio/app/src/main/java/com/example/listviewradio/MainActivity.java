package com.example.listviewradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private ListView lw;
        private RadioGroup rg;
        private RadioButton male;
        private RadioButton female;
        private Button sub;
        private DatePicker date;
        private String[] arr = {"a", "b", "c"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lw = (ListView) findViewById(R.id.list);
        rg = (RadioGroup) findViewById(R.id.grp);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        sub = (Button) findViewById(R.id.sub);
        date = (DatePicker) findViewById(R.id.date);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_eg, arr);

        lw.setAdapter(adapter);

        sub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(male.isChecked()){
                            Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_LONG).show();
                        }else if(female.isChecked()){
                            Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            date.setOnDateChangedListener(
                    new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            Toast.makeText(MainActivity.this, ((String) dayOfMonth), Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }
    }
}