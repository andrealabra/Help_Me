package com.example.project3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }


    public class Default {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

    public class High {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

    public class Medium {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

    public class ResourceId {

        @SerializedName("kind")
        @Expose
        private String kind;
        @SerializedName("videoId")
        @Expose
        private String videoId;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

    }

    public class Snippet {

        @SerializedName("publishedAt")
        @Expose
        private String publishedAt;
        @SerializedName("channelId")
        @Expose
        private String channelId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("thumbnails")
        @Expose
        private Thumbnails thumbnails;
        @SerializedName("channelTitle")
        @Expose
        private String channelTitle;
        @SerializedName("playlistId")
        @Expose
        private String playlistId;
        @SerializedName("position")
        @Expose
        private Integer position;
        @SerializedName("resourceId")
        @Expose
        private ResourceId resourceId;
        @SerializedName("videoOwnerChannelTitle")
        @Expose
        private String videoOwnerChannelTitle;
        @SerializedName("videoOwnerChannelId")
        @Expose
        private String videoOwnerChannelId;

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }

        public void setThumbnails(Thumbnails thumbnails) {
            this.thumbnails = thumbnails;
        }

        public String getChannelTitle() {
            return channelTitle;
        }

        public void setChannelTitle(String channelTitle) {
            this.channelTitle = channelTitle;
        }

        public String getPlaylistId() {
            return playlistId;
        }

        public void setPlaylistId(String playlistId) {
            this.playlistId = playlistId;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public ResourceId getResourceId() {
            return resourceId;
        }

        public void setResourceId(ResourceId resourceId) {
            this.resourceId = resourceId;
        }

        public String getVideoOwnerChannelTitle() {
            return videoOwnerChannelTitle;
        }

        public void setVideoOwnerChannelTitle(String videoOwnerChannelTitle) {
            this.videoOwnerChannelTitle = videoOwnerChannelTitle;
        }

        public String getVideoOwnerChannelId() {
            return videoOwnerChannelId;
        }

        public void setVideoOwnerChannelId(String videoOwnerChannelId) {
            this.videoOwnerChannelId = videoOwnerChannelId;
        }

    }

    public class Standard {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

    public class Thumbnails {

        @SerializedName("default")
        @Expose
        private Default _default;
        @SerializedName("medium")
        @Expose
        private Medium medium;
        @SerializedName("high")
        @Expose
        private High high;
        @SerializedName("standard")
        @Expose
        private Standard standard;

        public Default getDefault() {
            return _default;
        }

        public void setDefault(Default _default) {
            this._default = _default;
        }

        public Medium getMedium() {
            return medium;
        }

        public void setMedium(Medium medium) {
            this.medium = medium;
        }

        public High getHigh() {
            return high;
        }

        public void setHigh(High high) {
            this.high = high;
        }

        public Standard getStandard() {
            return standard;
        }

        public void setStandard(Standard standard) {
            this.standard = standard;
        }

    }

}
