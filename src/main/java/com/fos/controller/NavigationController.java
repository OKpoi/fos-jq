package com.fos.controller;

import com.fos.common.ConstantURL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NavigationController {

    @GetMapping
    public String defaultPage() {
        return ConstantURL.INDEX;
    }

    @GetMapping("/index")
    public String index() {
        return ConstantURL.INDEX;
    }

    @GetMapping("/nav")
    public String nav() {
        return ConstantURL.NAV;
    }

    @GetMapping("/footer")
    public String footer() {
        return ConstantURL.FOOTER;
    }

    @GetMapping("/user")
    public String userinfo() {
        return ConstantURL.USER;
    }

    @GetMapping("/movie")
    public String movie() {
        return ConstantURL.MOVIE;
    }

    @GetMapping("/movieinfo")
    public String movieInfo() {
        return ConstantURL.MOVIEINFO;
    }

}

