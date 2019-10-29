package com.fos.exception;

import com.fos.enums.movietype.MovieTypeEnums;
import lombok.Getter;

@Getter
public class MovieTypeException extends RuntimeException {
  private Integer code;

  public MovieTypeException(MovieTypeEnums userEmus) {
    super(userEmus.getMsg());
    this.code = userEmus.getCode();
  }
}
