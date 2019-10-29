package com.fos.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEmus {
  QUERY_USER_SUCCESS("用户查询成功", 200),
  USER_IS_NOT_HAVE("用户不存在", 400);

  private String msg;
  private Integer code;
}
