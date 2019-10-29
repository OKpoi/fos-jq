package com.fos.util;

import com.fos.enums.RestResultEnums;
import com.fos.vo.RestVO;

public class RestHelpyer {

  private static RestVO restVO;

  public static RestVO success() {
    return success(null);
  }

  public static RestVO success(Object data) {
    restVO.setCode(RestResultEnums.SUCCESS.getCode());
    restVO.setData(RestResultEnums.SUCCESS.getMsg());
    restVO.setData(data);
    return restVO;
  }

  public static RestVO fail() {
    restVO.setCode(RestResultEnums.FAIL.getCode());
    restVO.setData(RestResultEnums.FAIL.getMsg());
    return restVO;
  }
}
