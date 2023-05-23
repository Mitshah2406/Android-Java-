package com.example.asynceg;


import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.widget.*;
import android.view.View;

import org.w3c.dom.Text;

public class myTask extends AsyncTask<Void, Integer, String>{
    ProgressBar pg;
    TextView st;
    public myTask(ProgressBar pg, TextView st){
        this.pg = pg;
        this.st = st;
    }

    public void onPreExecute(){ st.setText("Starting...");}

    public String doInBackground(Void... params){
        for(int i =0; i<=10;i++) {
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            publishProgress(i);
        }
        return "Completed";
    }

    public void onProgressUpdate(Integer... vals){
        pg.setProgress(vals[0]*10);
        st.setText("Progress is "+(vals[0]*10)+"%");
    }
    public void onPostExecute(String res){
        st.setText(res);
    }
}
