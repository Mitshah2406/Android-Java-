package com.example.date;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Bored extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())){
            Toast.makeText(context, "Airplane Mode Toggled", Toast.LENGTH_LONG).show();
        }
    }
}
