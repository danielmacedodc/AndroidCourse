package com.example.twoactivities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityOne extends AppCompatActivity {

    private ActivityResultLauncher<Intent> intentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

    public void openSecondView(View view){
        Intent open = new Intent(this, SecondActivity.class);
        open.putExtra("Intent_ID","01");

        startActivity(open);
    }

    //criar database
    private SharedPreferences getMyPreferences(){
        return getSharedPreferences("DataBaseName", Context.MODE_PRIVATE);
    }

    //inserir registro na base de dados
    private void insertOrUpdateMessage(String key, String value){
        SharedPreferences.Editor editor = getMyPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void sendText(View view)
    {
        EditText textField = findViewById(R.id.edText);
        String message = textField.getText().toString();

        textField.getText().clear();

        insertOrUpdateMessage("messageId", message);

        Intent messenger = new Intent(this, SecondActivity.class);
        //messenger.putExtra("messageId", message);
        messenger.putExtra("","");

        startActivity(messenger);
    }


}