package com.entity;

import java.util.Date;


public class MovieReply {
    private Integer replyId;
    private String content;
    private Date createTime;
    private Integer state;
    private Integer parentId;
    private User user;
    private MovieComment movieComment;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieComment getMovieComment() {
        return movieComment;
    }

    public void setMovieComment(MovieComment movieComment) {
        this.movieComment = movieComment;
    }
}
