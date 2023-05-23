package com.example.sms;

import android.content.*;
import android.telephony.*;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context c, Intent i){
        try{
            Log.d("ssss", "recieve");
            Bundle b = i.getExtras();
            Object[] sms = (Object[]) b.get("pdus");
            for (Object obj : sms) {
                SmsMessage msg = SmsMessage.createFromPdu((byte[]) obj);
                String num = msg.getDisplayOriginatingAddress();
                String ogMsg = msg.getMessageBody();
                Toast.makeText(c.getApplicationContext(), num + " " + ogMsg, Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){
            Toast.makeText(c.getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

        }

    }


}