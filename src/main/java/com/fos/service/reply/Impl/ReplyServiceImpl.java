package com.fos.service.reply.Impl;

import com.fos.dao.reply.TbCommentReplyMapper;
import com.fos.entity.reply.TbCommentReply;
import com.fos.enums.user.ReplyEnums;
import com.fos.exception.CustomerException;
import com.fos.service.reply.ReplyService;
import com.fos.util.LoggerHelper;
import com.fos.vo.ReplyVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * @author FULO2
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private TbCommentReplyMapper tbCommentReplyMapper;

    @Override
    public List<ReplyVO> findActiveReplyByCommentId(Integer commentId) {
        List<TbCommentReply> tbCommentReplyList = tbCommentReplyMapper.selectActiveReplyByCommentId(commentId);
        if (Objects.nonNull(tbCommentReplyList) && tbCommentReplyList.size() > 0) {
            return convertEntityListToVOList(tbCommentReplyList);
        } else {
            LoggerHelper.createCustomeExcpetionLog(this.getClass().getSimpleName(), "findActiveReplyByCommentId", ReplyEnums.REPLY_NOT_EXIST.getMsg());
            throw new CustomerException(ReplyEnums.REPLY_NOT_EXIST.getCode(), ReplyEnums.REPLY_NOT_EXIST.getMsg());
        }
    }

    @Override
    public List<ReplyVO> findActiveReplyByUserId(Integer userId) {
        List<TbCommentReply> tbCommentReplyList = tbCommentReplyMapper.selectActiveReplyByUserId(userId);
        if (Objects.nonNull(tbCommentReplyList) && tbCommentReplyList.size() > 0) {
            return convertEntityListToVOList(tbCommentReplyList);
        } else {
            throw new CustomerException(ReplyEnums.USER_REPLY_NOT_EXIST.getCode(), ReplyEnums.USER_REPLY_NOT_EXIST.getMsg());
        }
    }

    @Override
    public List<ReplyVO> findActiveReplyByParentId(Integer parentId) {
        List<TbCommentReply> tbCommentReplyList = tbCommentReplyMapper.selectActiveReplyByParentId(parentId);
        if (Objects.nonNull(tbCommentReplyList) && tbCommentReplyList.size() > 0) {
            return convertEntityListToVOList(tbCommentReplyList);
        } else {
            throw new CustomerException(ReplyEnums.COMMENT_REPLY_NOT_EXIST.getCode(), ReplyEnums.COMMENT_REPLY_NOT_EXIST.getMsg());
        }
    }

    private List<ReplyVO> convertEntityListToVOList(List list) {
        List<ReplyVO> replyVOList = new ArrayList<>(8);
        list.forEach(item -> {
            ReplyVO replyVO = new ReplyVO();
            BeanUtils.copyProperties(item, replyVO);
            replyVOList.add(replyVO);
        });
        return replyVOList;
    }

}
