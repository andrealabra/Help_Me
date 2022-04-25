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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_youtube);
    }

    public void playListClick(View view)
    {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PLSQl0a2vh4HDYIB-tq4HUJj3WR0n6hxRg"));


    }


    public void playListClick2(View view)
    {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PLSQl0a2vh4HBrIb03_adNggSGabJHtyAM"));
    }

    public void playListClick4(View view) {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PLSQl0a2vh4HBxoP1tZaejDjVn2Ysf_WDj"));
    }


    public void testClick(View view) {
        startActivity(new Intent(this , VideoListActivity.class)
                .putExtra("playListId", "PL8dPuuaLjXtMwmepBjTSG593eG7ObzO7s"));
    }
}