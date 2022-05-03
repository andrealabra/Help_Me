package com.example.project3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyViewHolder>
{
    List<Video> videoList;
    Context context;

    public VideoListAdapter(List<Video> videoList , Context context) {
        this.videoList = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item_design, null));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Video video = videoList.get(position);

        /// set values in views
        holder.title.setText(video.getSnippet().getTitle());
        holder.date.setText(video.getSnippet().getPublishedAt());
        Glide.with(context)
                .load(video.getSnippet().getThumbnails().getMedium().getUrl())
                .into(holder.videoImage);



        /// click on image to play video
        holder.videoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, YoutubeVideoPlayerActivity.class);
                intent.putExtra("videoId",video.getSnippet().getResourceId().getVideoId());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title, date;
        // private ReadMoreTextView description;
        private ImageView videoImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.videoTitle);
            date = itemView.findViewById(R.id.videoDate);
            videoImage = itemView.findViewById(R.id.videoImage);
        }
    }
}
