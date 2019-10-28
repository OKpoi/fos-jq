package com.service.Impl;

import com.annotation.logAnnotation;
import com.dao.CommentDao;
import com.entity.MovieComment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.CommentService;
import com.validator.ValidatorFactory;
import com.vo.VeiwMovieComment;
import com.vo.ViewRank;
import com.vo.ViewUserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ValidatorFactory validatorFactory;

    @Override
    public ArrayList<VeiwMovieComment> getAllCommentByMovieId(Integer movieId) {
        return commentDao.queryAllCommentByMovieId(movieId) ;
    }
    @Override
    public ArrayList<VeiwMovieComment> getAllCommentByMovieId(Integer movieId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList commentList= new ArrayList();
        commentList=commentDao.queryAllCommentByMovieId(movieId);
        PageInfo page = new PageInfo(commentList);
        return commentList;
    }
    @Override
    public ArrayList<ViewUserComment> getAllCommentByUserId(Integer userId) {
        return commentDao.queryAllCommentByUserId(userId);
    }
    @Override
    public ArrayList<ViewUserComment> getAllCommentByUserId(Integer userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList commentList= new ArrayList();
        commentList=commentDao.queryAllCommentByUserId(userId);
        PageInfo page = new PageInfo(commentList);
        return commentList;
    }
    @Override
    @logAnnotation(operationName = "添加评论")
    public int addComment(MovieComment movieComment) {
        int num=commentDao.insertComment(movieComment);
        return num;
    }

    @Override
    @logAnnotation(operationName = "更新评论")
    public int updateComment(MovieComment movieComment) {
        return commentDao.updateComment(movieComment);
    }

    @Override
    @logAnnotation(operationName = "删除评论")
    public int delectComment(MovieComment movieComment) {
        return commentDao.delectComment(movieComment);
    }

    @Override
    public ArrayList<MovieComment> selectComment(MovieComment movieComment) {
        return commentDao.selectComment(movieComment);
    }

    @Override
    public Boolean vaildatorComment(MovieComment movieComment) {
        return validatorFactory.CreateCommentVali(movieComment);
    }
}
