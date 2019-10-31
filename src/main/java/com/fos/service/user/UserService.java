package com.fos.service.user;

import com.fos.entity.user.TbUser;
import com.fos.vo.LoginVO;

import java.util.concurrent.ExecutionException;

public interface UserService {
  TbUser findUserByLoginVOToLogin(LoginVO loginVO);

  TbUser findUserByUserId(Integer userId);

  TbUser insert(TbUser tbUser) throws ExecutionException, InterruptedException;

  TbUser update(TbUser tbUser);
}
