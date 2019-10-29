package com.fos.enums.movietype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieTypeEnums {
  SUCCESS(200, "查询类型列表成功"),
  MOVIE_TYPE_IS_NOT_EXIT(400, "类型列表为空");

  private Integer code;
  private String msg;
}
