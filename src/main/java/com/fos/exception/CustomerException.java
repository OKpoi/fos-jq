package com.fos.exception;

import lombok.Getter;

public class CustomerException extends RuntimeException {

  @Getter private Integer code;

  public CustomerException(Integer code, String msg) {
    super(msg);
    this.code = code;
  }
}
