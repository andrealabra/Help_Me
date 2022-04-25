package com.example.project3;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.project3.R;
import com.example.project3.VideoListAdapter;
import com.example.project3.Video;
import com.example.project3.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity {

    private String VIDEO_URL;
    private static final String KEY = "AIzaSyDLHry3kf-afitZTogzipOSOQwokQIqbUk";

    private RecyclerView recyclerViewPlayListVideo;
    private List<Video> playList;
    private VideoListAdapter adapter;
    private String nextPageToken;

    private ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        initViews();

    }

    private void initViews() {
        String playListId = getIntent().getStringExtra("playListId");
        VIDEO_URL = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&" +
                "playlistId="+playListId+"&maxResults=200&order=date&key="+ KEY;
        progressBar = new ProgressDialog(VideoListActivity.this);
        progressBar.setMessage("Loading Playlist...");
        progressBar.setCanceledOnTouchOutside(false);

        recyclerViewPlayListVideo = findViewById(R.id.videoList);
        recyclerViewPlayListVideo.setLayoutManager(new LinearLayoutManager(this));

        playList = new ArrayList<>();
        adapter = new VideoListAdapter(playList, VideoListActivity.this);
        getAllVideos();

    }


    // get video according play list id
    private void getAllVideos() {

        progressBar.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, VIDEO_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("items");

//                    if (response.get("nextPageToken").toString() != null) {
//                        nextPageToken = response.get("nextPageToken").toString();
//                        Log.d("nextPageToken", "onResponseAllVIdeo: " + jsonArray.length());
//                    }

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Log.d("arshTag", "onResponse: " + object.get("id").toString());
                        Gson gson = new Gson();
                        /// convert json to java
                        Type collectionType = new TypeToken<Video>() {
                        }.getType();
                        Video videoList = gson.fromJson(String.valueOf(object), collectionType);
                        playList.add(videoList);
                    }

                    recyclerViewPlayListVideo.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                    progressBar.dismiss();


                } catch (JSONException e) {
                    e.printStackTrace();
                    progressBar.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.dismiss();
                Toast.makeText(VideoListActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });

        Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

//        StringRequest request = new StringRequest(Request.Method.GET, VIDEO_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("items");
//
//                    nextPageToken = jsonObject.get("nextPageToken").toString();
//                    Log.d("nextPageToken", "onResponseAllVIdeo: "+nextPageToken);
//
//
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject object = jsonArray.getJSONObject(i);
//                        Log.d("uzairTag", "onResponse: "+object.get("id").toString());
//                        Gson gson = new Gson();
//                        /// convert json to java
//                        Video videoList = gson.fromJson(String.valueOf(object), Video.class);
//                        playList.add(videoList);
//                    }
//
//                    recyclerViewPlayListVideo.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//
//
//                    progressBar.dismiss();
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    progressBar.dismiss();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                progressBar.dismiss();
//                Toast.makeText(VideoListActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        Singleton.getInstance(this).addToRequestQueue(request);

    }
}