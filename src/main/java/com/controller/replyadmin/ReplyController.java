package com.controller.replyadmin;

import com.dto.Layui;
import com.entity.MovieReply;
import com.service.ReplyService;
import com.util.HttpServletRequestUtil;
import com.vo.VeiwMovieReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;


    /**
     * 查询一个用户下的所有回复
     *
     * @param request
     * @return json
     */
    @RequestMapping(value = "/replybyuserid")
    @ResponseBody
    private Layui getReplyByUserId(HttpServletRequest request) {
        Integer userId = HttpServletRequestUtil.getInt(request, "userid");
        List<VeiwMovieReply> list = new ArrayList<VeiwMovieReply>();
        Integer pageNum = HttpServletRequestUtil.getInt(request,"pageNum");
        list = replyService.getRelyByUserId(userId,pageNum,5);
        if (list.size() > 0) {
            return Layui.select(list.size(), list, "用户回复查询成功！");
        } else {
            return Layui.fail("当前用户没有回复！");
        }
    }


    /**
     * 添加回复
     *
     * @param movieReply
     * @return json
     */
    @RequestMapping(value = "/addreply")
    @ResponseBody
    private Layui addReply(@RequestBody MovieReply movieReply) {
        movieReply.setCreateTime(new Date());
        movieReply.setState(0);
        int num = replyService.addMovieReply(movieReply);
        if (num > 0) {
            return Layui.success("回复成功！");
        } else {
            return Layui.fail("回复失败！");
        }
    }


    /**
     * 删除回复
     *
     * @param movieReply
     * @return json
     */
    @RequestMapping(value = "/delectreply")
    @ResponseBody
    private Layui delectreply(@RequestBody MovieReply movieReply) {
        movieReply.setCreateTime(new Date());
        int num = replyService.delectMovieReply(movieReply);
        if (num > 0) {
            return Layui.success("回复删除成功！");
        } else {
            return Layui.fail("回复删除失败！");
        }
    }
}
