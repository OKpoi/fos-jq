package com.fos.util;

import com.fos.enums.RestResultEnums;
import com.fos.vo.RestVO;

public class RestHelper {

  public static RestVO success(Object data) {
    RestVO restVO =
        RestVO.builder()
            .code(RestResultEnums.SUCCESS.getCode())
            .msg(RestResultEnums.SUCCESS.getMsg())
            .data(data)
            .build();
    return restVO;
  }

  public static RestVO success(String msg, Object data) {
    RestVO restVO =
        RestVO.builder().code(RestResultEnums.SUCCESS.getCode()).msg(msg).data(data).build();
    return restVO;
  }

  public static RestVO success(Integer code, String msg, Object data) {
    RestVO restVO = RestVO.builder().code(code).msg(msg).data(data).build();
    return restVO;
  }

  public static RestVO fail() {
    RestVO restVO =
        RestVO.builder()
            .code(RestResultEnums.FAIL.getCode())
            .msg(RestResultEnums.FAIL.getMsg())
            .build();
    return restVO;
  }

  public static RestVO fail(Integer code, String msg) {
    RestVO restVO = RestVO.builder().code(code).msg(msg).build();
    return restVO;
  }
}
