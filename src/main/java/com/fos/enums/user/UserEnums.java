package com.fos.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnums {
  QUERY_USER_SUCCESS("用户查询成功", 200),
  EORROR_USERNAME_OR_PASSWORD("用户名或密码不匹配", 400),
  USER_IS_NOT_HAVE("用户不存在", 400),
  INSERT_ERROR("创建用户失败", 500),
  UPDATE_ERROR("更新用户信息失败", 500);

  private String msg;
  private Integer code;
}
