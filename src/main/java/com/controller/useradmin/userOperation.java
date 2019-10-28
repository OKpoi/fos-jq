package com.controller.useradmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class userOperation {
    @RequestMapping(value = "/index.jsp")
    private String index(){return "redirect:index.jsp";}
    @RequestMapping(value = "/movielist.jsp")
    private String movieList(){return "redirect:movielist.jsp";}

    @RequestMapping(value = "/success")
    private String success(){return "register/success";}

    @RequestMapping(value = "/centre",method = RequestMethod.GET)
    private String centre(){return "usercentre/centre";}

    @RequestMapping(value = "/otheruser",method = RequestMethod.GET)
    private String othercentre(){return "usercentre/otheruser";}

    @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    private String info(){return "usercentre/modifyinfo";}

    @RequestMapping(value = "/ok")
    private  String successinfo(){return "usercentre/success";}

    @RequestMapping(value = "/goback")
    private String goback(){return "usercentre/successpassword";}

}
