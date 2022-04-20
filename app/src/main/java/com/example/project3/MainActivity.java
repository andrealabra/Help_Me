package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button movePost;
    private Button moveYoutube;
    private Button moveCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movePost = findViewById(R.id.postitBtn);
        moveYoutube = findViewById(R.id.youtubeBtn);
        moveCalculator = findViewById(R.id.calculateitBtn);

        movePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostingActivity.class);
                startActivity(intent);
            }
        });

        moveYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YouTubeActivity.class);
                startActivity(intent);
            }
        });

        moveCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinalCalculator.class);
                startActivity(intent);
            }
        });

    }
}
