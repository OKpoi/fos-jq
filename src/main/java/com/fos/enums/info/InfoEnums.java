package com.fos.enums.info;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InfoEnums {
  QUERT_INFO_SUCCESS(200, "查询咨询成功"),
  INFO_NOT_EXISIT(400, "咨询查询失败"),
  HEADLINE_NOT_FOUND(400, "热点咨询查询失败");

  private Integer code;
  private String msg;
}
