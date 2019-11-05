package com.fos.controller.reply;

import com.fos.service.reply.ReplyService;
import com.fos.util.RestHelper;
import com.fos.vo.ReplyVO;
import com.fos.vo.RestVO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FULO2
 */
@RestController
@RequestMapping("/api/reply")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    @GetMapping("/commentId/{commentId}")
    public RestVO<List<ReplyVO>> getReplyListByCommentId(@PathVariable Integer commentId) {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByCommentId(commentId);
        return RestHelper.success(replyVOList);
    }

    @GetMapping("/userId/{userId}")
    public RestVO<List<ReplyVO>> getReplyListByUserId(@PathVariable Integer userId) {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByUserId(userId);
        return RestHelper.success(replyVOList);
    }

    @GetMapping("/parentId/{parentId}")
    public RestVO<List<ReplyVO>> getReplyListByParentId(@PathVariable Integer parentId) {
        List<ReplyVO> replyVOList = replyService.findActiveReplyByParentId(parentId);
        return RestHelper.success(replyVOList);
    }
}
