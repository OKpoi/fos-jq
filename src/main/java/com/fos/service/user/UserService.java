package com.fos.service.user;

import com.fos.entity.user.TbUser;
import com.fos.vo.LoginVO;

public interface UserService {
  TbUser findUserByLoginVOToLogin(LoginVO loginVO);
}
