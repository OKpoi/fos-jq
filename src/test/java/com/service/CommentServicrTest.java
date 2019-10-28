package com.service;

import com.BaseTest;
import com.dao.CommentDao;
import com.entity.Movie;
import com.entity.MovieComment;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CommentServicrTest extends BaseTest {
    @Autowired
    CommentService commentService;
    @Test
    public void vaildatorTesst() {
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
        System.out.println(commentService.vaildatorComment(movieComment));
    }
}
