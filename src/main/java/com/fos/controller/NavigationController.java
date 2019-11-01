package com.fos.controller;

import com.fos.common.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NavigationController {

  @GetMapping
  public String defaultPage() {
    return Constant.INDEX;
  }

  @GetMapping("/index")
  public String index() {
    return Constant.INDEX;
  }

  @GetMapping("/nav")
  public String nav() {
    return Constant.NAV;
  }
}
