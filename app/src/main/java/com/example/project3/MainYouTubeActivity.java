package com.example.project3;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainYouTubeActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState onCreate(Bundle) is called when the activity first starts up.
     * and save the state of the application in a bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_youtube);
    }

    /**
     *
     * @param view  Making button link that takes play ID and URL of the video
     */
    public void playListClick(View view)
    {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PLSQl0a2vh4HDYIB-tq4HUJj3WR0n6hxRg"));


    }
    /**
     *
     * @param view  Making button link that takes play ID and URL of the video
     */

    public void playListClick2(View view)
    {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListyId", "PLSQl0a2vh4HBrIb03_adNggSGabJHtyAM"));
    }
    /**
     *
     * @param view  Making button link that takes play ID and URL of the video
     */

    public void playListClick4(View view) {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PLSQl0a2vh4HBxoP1tZaejDjVn2Ysf_WDj"));
    }
    /**
     *
     * @param view  Making button link that takes play ID and URL of the video
     */


    public void testClick(View view) {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PL8dPuuaLjXtMwmepBjTSG593eG7ObzO7s"));
    }
}