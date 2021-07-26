package com.example.twoactivities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        getIntent().getStringExtra("");

        String message = getMessage("messageId");

        TextView textView = findViewById(R.id.secondView);
        textView.setText(message);
    }

    //criar/atualizar database
    private SharedPreferences getMyPreferences(){
        return getSharedPreferences("DataBaseName", Context.MODE_PRIVATE);
    }

    //get data from db
    private String getMessage(String key){
        return getMyPreferences().getString(key, "");
    }
}
