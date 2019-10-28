package com.service.Impl;

import com.annotation.logAnnotation;
import com.dao.ReplyDao;
import com.entity.MovieReply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ReplyService;
import com.vo.VeiwMovieReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ReplyServiceImpl  implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Override
    public ArrayList<VeiwMovieReply> getRelyByUserId(Integer userId) {
        return replyDao.queryRelyByUserId(userId);
    }

    @Override
    public ArrayList<VeiwMovieReply> getRelyByUserId(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList replyList= new ArrayList();
        replyList=replyDao.queryRelyByUserId(userId);
        PageInfo page = new PageInfo(replyList);
        return replyList;
    }

    @Override
    @logAnnotation(operationName = "添加回复")
    public int addMovieReply(MovieReply movieReply) {
        return replyDao.inserMovieReply(movieReply);
    }

    @Override
    @logAnnotation(operationName = "删除回复")
    public int delectMovieReply(MovieReply movieReply) {
        return replyDao.delectMovieReply(movieReply);
    }
}
