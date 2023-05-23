package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.*;
import android.content.Intent;
public class MainActivity extends AppCompatActivity{
    private ListView lv;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lw);
    }
    public void on(View v){
        if(!BA.isEnabled()){
            Intent enable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enable, 0);
        }
    }
    public void off(View v){
        BA.disable();
    }
    public void visible(View v){
        Intent visible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(visible, 0);
    }
    public void list(View v){
        pairedDevices = BA.getBondedDevices();
        ArrayList devices = new ArrayList();
        for(BluetoothDevice bt: pairedDevices){
            devices.add(bt.getName());
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(getApplicationContext(), R.layout.lww, devices);
        lv.setAdapter(ad);
    }
}