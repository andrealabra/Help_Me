package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //connect buttons to activity pages
        setContentView(R.layout.activity_main);
        move = findViewById(R.id.postitBtn);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PostingActivity.class);
                startActivity(intent);
            }
        });

        move = findViewById(R.id.youtubeBtn);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,YouTubeActivity.class);
                startActivity(intent);
            }
        });

        move = findViewById(R.id.calculateitBt);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FinalCalculator.class);
                startActivity(intent);
            }
        });

    }
}