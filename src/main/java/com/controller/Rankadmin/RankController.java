package com.controller.Rankadmin;


import com.dto.Layui;
import com.service.CommentService;
import com.service.RankService;
import com.util.JedisUtils;
import com.vo.ViewRank;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedis;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/rank")
public class RankController {
    @Autowired
    RankService rankService;
    @RequestMapping(value = "/rank20" ,method = RequestMethod.GET)
    @ResponseBody
    private Layui gettop20MovieRank(HttpServletRequest request) {
        List<ViewRank> list ;
        //判断有没有20个电影
        if(getMovieRank().size()<20){
            list = getMovieRank();
        }else {
            //取list中的前20
            list = getMovieRank().subList(0, 20);
        }
        if(list.size()>0){
            return Layui.select(list.size(),list,"获取电影排行成功！");
        }else {
            return Layui.fail("获取电影失败！");
        }

    }
    @RequestMapping(value = "/rank5" ,method = RequestMethod.GET)
    @ResponseBody
    private Layui gettop5MovieRank(HttpServletRequest request) {
        List<ViewRank> list ;
        //取list中的前5个
        list = getMovieRank().subList(0,5);
        if(list.size()>0){
            return Layui.select(list.size(),list,"获取电影排行成功！");
        }else {
            return Layui.fail("获取电影失败！");
        }

    }
    /*
    * 获取全部排行
    *
    * */
    private List getMovieRank() {
        //判断缓存中是否存在排行
        ArrayList list;
        System.out.println("===================================");
        Boolean index = JedisUtils.isexist("rank");
        if (index) {
            //获取redis中的JSON
            Object object = JedisUtils.get("rank");
            list = (ArrayList) object;
            if (list.size() > 0) {
                return list;
            }
            return null;
        } else {
            //查询排行
            list = rankService.getAllMovieRank();
            //放入排行表中
            int num = rankService.addRank(list);
            //放入redis
            if (num > 0) {
                JedisUtils.set("rank", list);
                return list;
            }
            return null;
        }
    }
}
