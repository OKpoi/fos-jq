package com.fos.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fos.entity.user.TbUser;

public interface TbUserMapper extends BaseMapper<TbUser> {
  TbUser selectOneUserToLogin(TbUser tbUser);
}
