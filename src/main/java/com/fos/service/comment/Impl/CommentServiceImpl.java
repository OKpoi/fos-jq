package com.fos.service.comment.Impl;

import com.fos.dao.comment.TbMovieCommentMapper;
import com.fos.entity.comment.TbMovieComment;
import com.fos.enums.comment.CommentEnums;
import com.fos.exception.CustomerException;
import com.fos.service.comment.CommentService;
import com.fos.util.LoggerHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Resource
    TbMovieCommentMapper tbMovieCommentMapper;
    @Override
    public List<TbMovieComment> findMovieCommentByMovieId(Integer movieId) {
        Map<String,Object> filterMap = new HashMap<>();
        filterMap.put("movie_id",movieId);
        List<TbMovieComment> tbMovieComments = tbMovieCommentMapper.selectByMap(filterMap);
        if (Objects.nonNull(tbMovieComments) && tbMovieComments.size()>0){
            return tbMovieComments;
        }else{
            LoggerHelper.createCustomeExcpetionLog(
                    CommentServiceImpl.class.getSimpleName(),
                    "findMovieCommentByMovieId",
                    CommentEnums.QUERY_COMMENT_BY_MOVIEID_FAIL.getMsg()
            );
            throw new CustomerException(
                    CommentEnums.QUERY_COMMENT_BY_MOVIEID_FAIL.getCode(),
                    CommentEnums.QUERY_COMMENT_BY_MOVIEID_FAIL.getMsg()
            );
        }
    }

    @Override
    public List<TbMovieComment> findMovieCommentByUserId(Integer userId) {
        Map<String,Object> filterMap = new HashMap<>();
        filterMap.put("user_id",userId);
        List<TbMovieComment> tbMovieComments = tbMovieCommentMapper.selectByMap(filterMap);
        if (Objects.nonNull(tbMovieComments) && tbMovieComments.size()>0){
            return tbMovieComments;
        }else{
            LoggerHelper.createCustomeExcpetionLog(
                    CommentServiceImpl.class.getSimpleName(),
                    "findMovieCommentByUserId",
                    CommentEnums.QUERY_COMMENT_BY_USERID_FAIL.getMsg()
            );
            throw new CustomerException(
                    CommentEnums.QUERY_COMMENT_BY_USERID_FAIL.getCode(),
                    CommentEnums.QUERY_COMMENT_BY_USERID_FAIL.getMsg()
            );
        }
    }

    @Override
    public int delMovieComment(Integer movieId, Integer userId) {

        Map<String,Object> filterMap = new HashMap<>();
        filterMap.put("movie_id",movieId);
        filterMap.put("user_id",userId);
        int delState = tbMovieCommentMapper.deleteByMap(filterMap);
        if (delState != 0){
            return delState;
        }else{
            LoggerHelper.createCustomeExcpetionLog(
                    CommentServiceImpl.class.getSimpleName(),
                    "delMovieComment",
                    CommentEnums.DELETE_COMMENT_BY_MOIVEIDANDUSERID_FAIL.getMsg()
            );
            throw new CustomerException(
                    CommentEnums.DELETE_COMMENT_BY_MOIVEIDANDUSERID_FAIL.getCode(),
                    CommentEnums.DELETE_COMMENT_BY_MOIVEIDANDUSERID_FAIL.getMsg()
            );
        }
    }
}
