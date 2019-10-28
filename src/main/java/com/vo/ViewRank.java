package com.vo;

import java.io.Serializable;

public class ViewRank implements Serializable {
    private Integer movieId;
    private Integer avgStart;
    private Integer count;
    private String movieName;
    private String movieImg;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getAvgStart() {
        return avgStart;
    }

    public void setAvgStart(Integer avgStart) {
        this.avgStart = avgStart;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }
}
