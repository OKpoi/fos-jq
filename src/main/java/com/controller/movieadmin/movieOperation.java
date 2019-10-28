package com.controller.movieadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class movieOperation {

    @RequestMapping(value = "/movieinfo")
    private String movieInfo(){return "movie/movieinfo";}

    @RequestMapping(value = "/movielist.jsp")
    private String movieList(){return "redirect:movielist.jsp";}

    @RequestMapping(value = "/typelist.jsp")
    private String movieType(){return "redirect:typelist.jsp";}
}
