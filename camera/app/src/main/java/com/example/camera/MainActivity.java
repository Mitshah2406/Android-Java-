package com.example.camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.provider.MediaStore;

import android.graphics.Bitmap;

public class MainActivity extends AppCompatActivity{
    private ImageView iv;

    private Button camBtn;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camBtn = findViewById(R.id.camBtn);
        iv = findViewById(R.id.iv);

        camBtn.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Intent on = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(on,  100);


           }
        });
    }
    @Override
    public void onActivityResult(int req,int res, Intent i){
        super.onActivityResult(req,res,i);

        if(res==RESULT_OK){
            if(req==100){
                Bitmap b= (Bitmap) i.getExtras().get("data");
                iv.setImageBitmap(b);
            }
        }
    }

}