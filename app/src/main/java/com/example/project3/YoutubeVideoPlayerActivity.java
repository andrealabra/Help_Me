package com.example.project3;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.project3.R;
import com.example.project3.VideoListAdapter;
import com.example.project3.Video;
import com.example.project3.Singleton;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideoPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
{
    private String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_youtube_video_player);

        videoId =  getIntent().getStringExtra("videoId");
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_view);
        String KEY = "AIzaSyDLHry3kf-afitZTogzipOSOQwokQIqbUk";
        youTubePlayerView.initialize(KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
            youTubePlayer.cueVideo(videoId);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Log.d("youtubeError", "onInitializationFailure: "+youTubeInitializationResult.toString());

    }
}