package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    Button btn;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.cnv);
        txt = findViewById(R.id.txt);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int ttsLang = textToSpeech.setLanguage(Locale.US);
                    if(ttsLang== TextToSpeech.LANG_MISSING_DATA ||ttsLang== TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.d("TTS", "Lang err");
                    }
                }else{
                    Log.d("TTS", "Init fail");
                }
                Log.i("TTS","Init success");
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int speakStatus = textToSpeech.speak(txt.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                if(speakStatus==TextToSpeech.ERROR){
                    Log.d("TTS", "Faile");
                }
                Log.i("TTS", "Succes");
            }
        });


            }
            public void onDestroy(){
                super.onDestroy();
                if(textToSpeech!=null){
                    textToSpeech.stop();
                    textToSpeech.shutdown();
                }
            }
}