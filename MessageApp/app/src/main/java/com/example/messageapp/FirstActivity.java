package com.example.messageapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.messageapp.R.id.sendButtonOne;

public class FirstActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> intentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        //insertOrUpdateMessage("Test", "My message");
        //String test = getMessage("Test");

        //Log.i(FirstActivity.class.getSimpleName(), test);

        intentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    String message = result.getData().getStringExtra("messageResponseId");

                    TextView textView = findViewById(R.id.text_header);

                    if (message != null && !message.equals("")) {
                        textView.setText(message);
                    }
                }
        );

    }

    //get data from db
    private String getMessage(String key){
        return getMyPreferences().getString(key, "");
    }

    //create database
    private SharedPreferences getMyPreferences(){
        return getSharedPreferences("DataBaseName", Context.MODE_PRIVATE);
    }

    //save data in db
    private void insertOrUpdateMessage(String key, String value){
        SharedPreferences.Editor editor = getMyPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void openSecondView(View view) {
        EditText textField = findViewById(R.id.sendMessage);
        String message = textField.getText().toString();

        textField.getText().clear();

        insertOrUpdateMessage("messageId", message);

        Intent messenger = new Intent(this, SecondActivity.class);
        messenger.putExtra("messageId", message);

        intentLauncher.launch(messenger);
    }
}