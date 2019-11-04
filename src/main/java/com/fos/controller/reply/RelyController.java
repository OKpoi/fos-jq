package com.fos.controller.reply;

import com.fos.service.reply.ReplyService;
import com.fos.util.RestHelper;
import com.fos.vo.ReplyVO;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/reply")
public class RelyController {

    @Resource
    private ReplyService replyService;

    @GetMapping("/get/{id}")
    public RestVO<List<ReplyVO>> getReplyById(@PathVariable Integer commentId) {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByCommentId(commentId);
        return RestHelper.success(replyVOList);
    }


}
