package com.entity;

import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * 排名
 */
public class Rank {
    private Integer rankId;
    private Integer movieId;
    private Integer avgStart;
    private Integer count;
    private Date date;
    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
