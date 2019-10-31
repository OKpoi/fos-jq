package com.fos.service.user;

import com.fos.entity.user.TbUser;
import com.fos.service.BaseServiceInterface;
import com.fos.vo.LoginVO;

public interface UserService extends BaseServiceInterface<TbUser> {
  TbUser findUserByLoginVOToLogin(LoginVO loginVO);
}
