package com.fos.controller.comment;

import com.fos.entity.comment.TbMovieComment;
import com.fos.enums.comment.CommentEnums;
import com.fos.service.comment.CommentService;
import com.fos.util.RestHelper;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    @GetMapping("/movieid")
    public RestVO findMovieCommentByMovieId(@RequestParam("movieId") Integer movieId) {
        List<TbMovieComment> tbMovieComments = commentService.findMovieCommentByMovieId(movieId);
        return RestHelper.success(CommentEnums.QUERY_COMMENT_SUCCESS.getMsg(), tbMovieComments);
    }

    @GetMapping("/userid")
    public RestVO findMovieCommentByUserId(@RequestParam("userId") Integer userId) {
        List<TbMovieComment> tbMovieComments = commentService.findMovieCommentByUserId(userId);
        return RestHelper.success(CommentEnums.QUERY_COMMENT_SUCCESS.getMsg(), tbMovieComments);
    }

    @GetMapping("/delete")
    public RestVO delMovieComment(@RequestParam("movieId") Integer movieId, @RequestParam("userId") Integer userId) {
        int delState = commentService.delMovieComment(movieId, userId);
        return RestHelper.success(CommentEnums.DELETE_COMMENT_SUCCESS.getMsg(), delState);
    }
}
