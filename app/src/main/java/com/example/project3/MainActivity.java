package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Button variable to launch the Post Activity
     */
    private Button movePost;

    /**
     * Button variable to launch the Youtube Activity
     */
    private Button moveYoutube;

    /**
     * Button variable to launch the Calculator Activity
     */
    private Button moveCalculator;

    /**
     * Button variable to Logout of the application
     */
    private Button moveLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movePost = findViewById(R.id.postitBtn);
        moveYoutube = findViewById(R.id.youtubeBtn);
        moveCalculator = findViewById(R.id.calculateitBtn);
        moveLogout = findViewById(R.id.logoutBtn);

        /**
         * Represent the Id for the user to able to pass data back to firebase.
         */
        String phoneId = getIntent().getStringExtra("phoneId");

        /**
         * movePost Button to listen to the receive click event.
         * @Override onClick event handler to launch the Post screen
         */
        movePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postingQs = new Intent(MainActivity.this, PostingQs.class);
                postingQs.putExtra("phoneId", phoneId);
                startActivity(postingQs);
            }
        });

        /**
         * moveYoutube Button to listen to the receive click event.
         * @Override onClick event handler to launch the Youtube screen
         */
        moveYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainYouTubeActivity.class);
                startActivity(intent);
            }
        });

        /**
         * moveCalculator Button to listen to the receive click event.
         * @Override onClick event handler to launch the Calculator screen
         */

        moveCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinalCalculator.class);
                startActivity(intent);
            }
        });

        /**
         * moveLogout Button to listen to the receive click event.
         * @Override onClick event handler to log the user out of the app.
         */
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
