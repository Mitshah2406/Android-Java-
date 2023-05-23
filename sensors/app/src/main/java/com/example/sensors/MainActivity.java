package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lw = findViewById(R.id.list);
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

        ArrayList<String> sensors = new ArrayList<>();


        for(int i=0;i<sensorList.size();i++){
            sensors.add((sensorList.get(i).getName()));
        }

        ArrayAdapter<String> a = new ArrayAdapter<>(getApplicationContext(), R.layout.mylist, sensors);
        lw.setAdapter(a);
    }
}