package com.fos.service.user;

import com.fos.entity.user.TbUser;
import com.fos.vo.LoginVO;
import com.fos.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    TbUser findUserByLoginVOToLogin(LoginVO loginVO);

    TbUser findUserByUserId(Integer userId);

    TbUser insert(UserVO userVO, MultipartFile file);

    TbUser update(TbUser tbUser);
}
