package com.fos.service.reply;

import com.fos.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    List<ReplyVO> findActiveReplyByCommentId(Integer commentId);


}
