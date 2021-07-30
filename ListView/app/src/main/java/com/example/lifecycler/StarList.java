package com.example.lifecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StarList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openList(View view){
        Intent open = new Intent(this, ListActivity.class);
        open.putExtra("view","");
        startActivity(open);
    }
}