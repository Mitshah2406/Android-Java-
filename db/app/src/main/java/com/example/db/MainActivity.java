package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import  android.widget.*;
import android.util.Log;

import android.database.sqlite.SQLiteDatabase;


import android.database.Cursor;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sql;

    private EditText name, email, pass, search;
    private Button insert, select, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        search = findViewById(R.id.searchQuery);
        select = findViewById(R.id.select);
        insert = findViewById(R.id.insert);

        sql = openOrCreateDatabase("atharva", Context.MODE_PRIVATE, null);

        sql.execSQL("CREATE TABLE IF NOT EXISTS customer(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name VARCHAR, email VARCHAR, pass VARCHAR )");

        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    sql.execSQL("INSERT INTO customer(name,email,pass) VALUES('"+name.getText().toString()+"','"+email.getText().toString()+"','"+ pass.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_LONG).show();

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "fail insert", Toast.LENGTH_LONG).show();
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Entered", Toast.LENGTH_LONG).show();

                try{
//                    String st = "SELECT * FROM customer WHERE 'email'='" + search.getText().toString() + "'";
//                    Cursor c = sql.rawQuery(st, null);
                    String query = "SELECT * FROM customer WHERE email ='"+search.getText().toString()+"'";
                    Cursor c = sql.rawQuery(query, null);
                    while (c.moveToNext()) {
                        Toast.makeText(getApplicationContext(), c.getString(0).toString(), Toast.LENGTH_LONG).show();
                        Log.i("Helloooooo", c.getString(2));
                    }
                    Toast.makeText(getApplicationContext(), "after while", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Log.d("Err", e.toString());
                }
            }
        });

    }
}

