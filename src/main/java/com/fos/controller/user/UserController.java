package com.fos.controller.user;

import com.fos.entity.user.TbUser;
import com.fos.service.user.UserService;
import com.fos.util.RestHelper;
import com.fos.vo.LoginVO;
import com.fos.vo.RestVO;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Resource private UserService userService;

  @PostMapping("/login")
  public RestVO login(@RequestBody LoginVO loginVO) {
    TbUser userByUserVOToLogin = userService.findUserByLoginVOToLogin(loginVO);
    return RestHelper.success(userByUserVOToLogin);
  }
}
