package com.controller.infoadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class infoOperation {

    @RequestMapping(value = "/infolist.jsp")
    private String movieList(){return "redirect:infolist.jsp";}

    @RequestMapping(value = "/info")
    private String movieInfo(){return "info/info";}
}
