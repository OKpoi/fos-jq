package com.fos.exception;

import com.fos.emus.user.UserEmus;

public class UserException extends RuntimeException {
  private Integer code;

  public UserException(UserEmus userEmus) {
    super(userEmus.getMsg());
    this.code = userEmus.getCode();
  }
}
