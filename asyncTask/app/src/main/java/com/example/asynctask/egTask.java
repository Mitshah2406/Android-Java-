package com.example.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class egTask extends AsyncTask<Void, Integer, String> {

    private ProgressBar pg;
    private TextView status;

    public egTask(ProgressBar pg, TextView tw){
        this.pg = pg;
        this.status = tw;
    }

    @Override
    protected void onPreExecute(){
        status.setText("Starting...");
    }

    @Override
    protected String doInBackground(Void... params){
        for (int i = 0 ; i<=10; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        int progress = values[0] *10;
        pg.setProgress(progress);
        status.setText("Progress is:  " + progress + " %");
    }

    @Override
    protected void onPostExecute(String result){
        pg.setProgress(100);
        status.setText(result);
    }

}
