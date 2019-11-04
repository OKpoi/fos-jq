package com.fos.service.reply.Impl;

import com.fos.dao.reply.TbCommentReplyMapper;
import com.fos.entity.reply.TbCommentReply;
import com.fos.enums.user.ReplyEnums;
import com.fos.exception.CustomerException;
import com.fos.service.reply.ReplyService;
import com.fos.util.LoggerHelper;
import com.fos.vo.ReplyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ReplyServicImpl implements ReplyService {


    @Resource
    private TbCommentReplyMapper tbCommentReplyMapper;


    @Override
    public List<ReplyVO> findActiveReplyByCommentId(Integer commentId) {
        List<TbCommentReply> tbCommentReplyList = tbCommentReplyMapper.selectActiveReplyByCommentId(commentId);
        if (Objects.nonNull(tbCommentReplyList) && tbCommentReplyList.size() > 0) {
            List<ReplyVO> replyVOList = new ArrayList<>(8);
            tbCommentReplyList.forEach(e -> {
                ReplyVO replyVO = new ReplyVO();
                BeanUtils.copyProperties(e, replyVO);
                replyVOList.add(replyVO);
            });
            return replyVOList;
        } else {
            LoggerHelper.createCustomeExcpetionLog(this.getClass().getSimpleName(), "findActiveReplyByCommentId", ReplyEnums.REPLY_NOT_EXSIT.getMsg());
            throw new CustomerException(ReplyEnums.REPLY_NOT_EXSIT.getCode(), ReplyEnums.REPLY_NOT_EXSIT.getMsg());
        }
    }
}
