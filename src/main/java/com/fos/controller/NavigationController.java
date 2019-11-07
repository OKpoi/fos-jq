package com.fos.controller;

import com.fos.common.ConstantURL;
import com.fos.common.InfoURL;
import com.fos.common.MovieURL;
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
        return MovieURL.MOVIE;
    }

    @GetMapping("/infolist")
    public String infolist() {
        return InfoURL.INFOLIST;
    }
    @GetMapping("/info")
    public String info() {
        return InfoURL.INFO;
    }
}
