package com.fos.service.reply.Impl;

import com.fos.entity.reply.TbCommentReply;
import com.fos.service.reply.ReplyService;
import com.fos.vo.ReplyVO;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReplyServiceImplTest {

    private TbCommentReply tbCommentReply;

    @Resource
    private ReplyService replyService;

    @BeforeEach
    void mockup() {
        tbCommentReply = TbCommentReply.builder()
                .replyId(4001)
                .commentId(3003)
                .rcontent("那是你没看懂啊")
                .state(0)
                .parentId(1004)
                .userId(1003)
                .build();
    }

    @Test
    void should_return_size1_when_selectActiveCommentByReplyId() {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByCommentId(tbCommentReply.getCommentId());

        Assert.assertNotNull(replyVOList);
        Assert.assertEquals(2, replyVOList.size());
    }

    @Test
    void should_return_size1_tbCommentReply_when_selectActiveReplyByUserId() {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByUserId(tbCommentReply.getUserId());

        Assert.assertNotNull(replyVOList);
        Assert.assertEquals(1, replyVOList.size());
    }

    @Test
    void should_return_size2_when_selectActiveReplyByParentId() {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByParentId(tbCommentReply.getParentId());

        Assert.assertNotNull(replyVOList);
        Assert.assertEquals(2, replyVOList.size());
    }
}