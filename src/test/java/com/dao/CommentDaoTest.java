package com.dao;

import com.BaseTest;
import com.entity.Movie;
import com.entity.MovieComment;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoTest extends BaseTest {
    @Autowired
    private CommentDao commentDao;
    @Autowired

    @Test
    public void queryAllCommentByMovieId(){
        List list=new ArrayList();
        list=commentDao.queryAllCommentByMovieId(2005);

    }

    @Test
    public void queryAllCommentByUserId(){
        List list=new ArrayList();
        list=commentDao.queryAllCommentByUserId(1002);

    }

    @Test
    public void insertComment(){
        MovieComment movieComment=new MovieComment();
        User user=new User();
        Movie movie=new Movie();
        user.setUserId(1004);
        movie.setMovieId(2007);
        movieComment.setMovie(movie);
        movieComment.setUser(user);
        movieComment.setContent("你说尼玛呢");
        movieComment.setStart(5.0f);
        movieComment.setCreateTime(new Date());
        movieComment.setState(0);
        commentDao.insertComment(movieComment);
    }

    @Test
    public void updateComment(){
        MovieComment movieComment=new MovieComment();
        User user=new User();
        Movie movie=new Movie();
        user.setUserId(1004);
        movie.setMovieId(2005);
        movieComment.setMovie(movie);
        movieComment.setUser(user);
        movieComment.setContent("看的时候就在思考这个片子中有没有所谓的正与邪，其实说深点都是关于群体利益之间的关系，药厂没有有些人中所谓的恶人，药厂也是商业啊，也要赚钱啊，不然拿爱心养护工人和公司？");
        movieComment.setStart(4.0f);
        movieComment.setCreateTime(new Date());
        movieComment.setState(0);
        commentDao.updateComment(movieComment);
    }
    @Test
    public void selectComment(){
        MovieComment movieComment=new MovieComment();
        User user=new User();
        Movie movie=new Movie();
        user.setUserId(1004);
        movie.setMovieId(2001);
        movieComment.setMovie(movie);
        movieComment.setUser(user);
        commentDao.selectComment(movieComment);
    }
}
