package com.example.AjinProjects.Learnoz.Model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Video {
    private String url;
    private Integer likes;
    private Float rating;

    public Video(String url, Integer likes, Float rating) {
        this.url = url;
        this.likes = likes;
        this.rating = rating;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
