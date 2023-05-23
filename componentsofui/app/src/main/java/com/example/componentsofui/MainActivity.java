package com.example.componentsofui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.tw);
        EditText e = (EditText) findViewById(R.id.et);
        Button b = (Button) findViewById(R.id.btn);
        Button toastBtn = (Button) findViewById(R.id.toastBtn);
        ImageButton imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        ToggleButton tgBtn = (ToggleButton) findViewById(R.id.tgBtn);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        CheckBox java = (CheckBox) findViewById(R.id.java);
        CheckBox py = (CheckBox) findViewById(R.id.py);
        ProgressBar horizontal  = (ProgressBar) findViewById(R.id.horz);
        ProgressBar vertical = (ProgressBar) findViewById(R.id.vert);
        ListView lw = (ListView) findViewById(R.id.lw);
        GridView gw = (GridView) findViewById(R.id.gw);
        ImageView king = (ImageView) findViewById(R.id.king);
        TimePicker clock = (TimePicker) findViewById(R.id.clock);
        TimePicker spinner = (TimePicker) findViewById(R.id.spinner);
        DatePicker calendar = (DatePicker) findViewById(R.id.calendar);
        DatePicker spinnerDate = (DatePicker) findViewById(R.id.spinnerDate);

        String[] arr = {"Java", "Python", "MongoDb", "js", "nodejs", "expressjs", "rest api", "Django", "flutter", "dart", "swing","vb.net", "php","mysql", "linux"};
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    t.setText("Name"+ e.getText().toString()+" "+tgBtn.isChecked());

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkId = rg.getCheckedRadioButtonId();
                RadioButton checkedRb = (RadioButton) findViewById(checkId);

                Toast.makeText(getApplicationContext(), checkedRb.getText().toString(), Toast.LENGTH_LONG ).show();
            }
        });
        king.setImageResource(R.drawable.king);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.txt, arr);
        lw.setAdapter(adapter);
        gw.setAdapter(adapter);

    tgBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(getApplicationContext(), isChecked? "On":"Off", Toast.LENGTH_LONG).show();
        }
    });
    clock.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getApplicationContext(), String.valueOf(hourOfDay), Toast.LENGTH_LONG).show();

        }
    });
    calendar.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Toast.makeText(getApplicationContext(), String.valueOf(dayOfMonth), Toast.LENGTH_LONG).show();

        }
    });

    imgBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"Atharva Gaandu", Toast.LENGTH_LONG).show();

        }
    });


    toastBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.root));
            Toast t = new Toast(getApplicationContext());
            t.setView(layout);
            t.setDuration(Toast.LENGTH_LONG);
            t.show();
        }
    });
    }

}