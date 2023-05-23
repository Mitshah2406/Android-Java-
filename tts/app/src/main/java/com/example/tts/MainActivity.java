package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText text;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        text = (EditText) findViewById(R.id.text);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int ttsLang = textToSpeech.setLanguage(Locale.US);
                    if(ttsLang==TextToSpeech.LANG_NOT_SUPPORTED || ttsLang==TextToSpeech.LANG_MISSING_DATA){
                        Log.d("TTS", "Language Not supoorted");
                    }else{
                        Log.i("TTS", "Language supoorted");
                    }
                }else{
                    Log.d("TTS", "Initialization Failed");
                }
                Log.i("TTS", "Initialization Success");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int speakStatus = textToSpeech.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                if(speakStatus == TextToSpeech.ERROR){
                    Log.d("TTS", "ERROR in converting text to speech");
                }
                Log.i("TTS", "Convert success");
            }
        });
    }
@Override
    public void onDestroy(){
        super.onDestroy();
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}