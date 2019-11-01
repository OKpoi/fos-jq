package com.fos.controller.user;

import com.fos.dao.comment.TbMovieCommentMapper;
import com.fos.entity.user.TbUser;
import com.fos.service.user.UserService;
import com.fos.util.RestHelper;
import com.fos.vo.LoginVO;
import com.fos.vo.RestVO;
import com.fos.vo.UserVO;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private TbMovieCommentMapper tbMovieCommentMapper;

    @PostMapping("/login")
    public RestVO login(@RequestBody LoginVO loginVO) {
        TbUser userByUserVOToLogin = userService.findUserByLoginVOToLogin(loginVO);
        return RestHelper.success(userByUserVOToLogin);
    }

    @PostMapping("/register")
    public RestVO register(@RequestBody UserVO userVO, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        TbUser tbUser = userService.insert(userVO, file);
        return RestHelper.success(tbUser);
    }


}
