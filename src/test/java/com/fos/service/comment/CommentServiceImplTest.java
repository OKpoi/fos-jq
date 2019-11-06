package com.fos.service.comment;

import com.fos.entity.comment.TbMovieComment;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class CommentServiceImplTest {
    @Resource
    CommentService commentService;
    Integer movieId = 2001;
    Integer userId = 1004;
    @Test
    void should_return_list_size1_when_findMovieCommentByMovieId() {
        List<TbMovieComment> tbMovieComments = commentService.findMovieCommentByMovieId(movieId);
        Assert.assertEquals(1, tbMovieComments.size());
    }
    @Test
    void should_return_list_size8_when_findMovieCommentByUserId() {
        List<TbMovieComment> tbMovieComments = commentService.findMovieCommentByUserId(userId);
        Assert.assertEquals(8, tbMovieComments.size());
    }
    @Test
    void should_return_int_1_when_delMovieComment() {
        int state = commentService.delMovieComment(movieId,userId);
        Assert.assertEquals(1, state);
    }
}
