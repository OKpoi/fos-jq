package com.fos.dao.reply;

import com.fos.entity.reply.TbCommentReply;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TbCommentReplyMapperTest {

    private TbCommentReply tbCommentReply;


    @BeforeEach
    void mockup() {
        tbCommentReply = TbCommentReply.builder()
                .replyId(4001)
                .commentId(3003)
                .rcontent("那是你没看懂啊")
                .state(0).parentId(1004)
                .userId(1003)
                .build();
    }

    @Resource
    private TbCommentReplyMapper tbCommentReplyMapper;

    @Test
    void should_return_like_tbCommentReply_when_selectActiveCommentByReplyId() {
        List<TbCommentReply> tbCommentReplyList = tbCommentReplyMapper.selectActiveReplyByCommentId(3003);

        Assert.assertNotNull(tbCommentReplyList);
        Assert.assertEquals(2, tbCommentReplyList.size());
    }
}