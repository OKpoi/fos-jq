package com.controller.movietypeadmin;

import com.dto.Layui;
import com.entity.MovieType;
import com.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping(value = "/movietype")

public class movieTypeController {

    @Autowired
    private MovieTypeService movieTypeService;


    /**
     * 查询所有电影类型 并返回json数据类型
     *
     * @return
     */
    @RequestMapping(value = "/allmovietype", method = RequestMethod.GET)
    @ResponseBody
    private Layui getAllMovieType() {
        List<MovieType> list = movieTypeService.getAllMovieType();
        if(list.size()>0){
            return Layui.select(list.size(),list,"查询电影类型成功！");
        }else {
            return Layui.fail("查询电影类型失败！");
        }

    }


}
