package com.fos.exception;

import com.fos.enums.info.InfoEnums;
import lombok.Getter;

public class HeadLineException extends RuntimeException {
  @Getter private Integer code;

  public HeadLineException(InfoEnums infoEnums) {
    super(infoEnums.getMsg());
    this.code = infoEnums.getCode();
  }
}
