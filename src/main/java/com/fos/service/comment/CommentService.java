package com.fos.service.comment;

import com.fos.entity.comment.TbMovieComment;

import java.util.List;

public interface CommentService {
    List<TbMovieComment> findMovieCommentByMovieId(Integer movieId);

    List<TbMovieComment> findMovieCommentByUserId(Integer userId);

    int delMovieComment(Integer movieId,Integer userId);

}
