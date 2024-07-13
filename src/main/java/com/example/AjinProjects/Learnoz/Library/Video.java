package com.example.AjinProjects.Learnoz.Library;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Video {
    private String url;
    private Integer likes;
    private Integer views;

    public Video(String url, Integer likes, Integer views) {
        this.url = url;
        this.likes = likes;
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
