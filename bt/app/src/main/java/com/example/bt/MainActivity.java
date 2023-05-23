package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4;
    private ListView lw;
    private BluetoothAdapter BA;
        private Set<BluetoothDevice> pairedDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
        startActivityForResult(visible ,0);
    }
    public void list(View v){
        pairedDevice =  BA.getBondedDevices();
        ArrayList a = new ArrayList();
        for (BluetoothDevice bt: pairedDevice
             ) {
            a.add(bt.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.txt, a);
        lw.setAdapter(adapter);
    }
}