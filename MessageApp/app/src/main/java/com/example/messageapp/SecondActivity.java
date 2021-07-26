package com.example.messageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String messageReceived = getIntent().getStringExtra("messageId");

        TextView txtReceived = findViewById(R.id.text_header_return);
        txtReceived.setText(messageReceived);

    }

    public void openFirstView(View view) {

        EditText textView = findViewById(R.id.secondViewMessage);

        Intent newMessenger = new Intent();
        String message = textView.getText().toString();
        newMessenger.putExtra("messageResponseId", message);

        setResult(RESULT_OK, newMessenger);
        finish();
    }
}
