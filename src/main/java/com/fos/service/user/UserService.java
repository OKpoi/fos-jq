package com.fos.service.user;

import com.fos.entity.user.TbUser;
import com.fos.vo.LoginVO;
import com.fos.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    TbUser findUserByLoginVOToLogin(LoginVO loginVO);

    TbUser findUserByUserId(Integer userId);

    TbUser insert(UserVO userVO, MultipartFile file) throws IOException;

    TbUser update(TbUser tbUser);
}
