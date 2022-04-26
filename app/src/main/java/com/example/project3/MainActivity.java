package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button movePost;
    private Button moveYoutube;
    private Button moveCalculator;
    private Button moveLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movePost = findViewById(R.id.postitBtn);
        moveYoutube = findViewById(R.id.youtubeBtn);
        moveCalculator = findViewById(R.id.calculateitBtn);
        moveLogout = findViewById(R.id.logoutBtn);

        movePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostingQs.class);
                startActivity(intent);
            }
        });

        moveYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainYouTubeActivity.class);
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

        moveLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //event handling, will display toast when user has logged out
                Toast.makeText(MainActivity.this, "You have sucessfully logged out!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
