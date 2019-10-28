package com.fos.util;

import com.fos.emus.RestResultEmus;
import com.fos.vo.RestVO;

public class Rest {

  private static RestVO restVO;

  public static RestVO success() {
    return success(null);
  }

  public static RestVO success(Object data) {
    restVO.setCode(RestResultEmus.SUCCESS.getCode());
    restVO.setData(RestResultEmus.SUCCESS.getMsg());
    restVO.setData(data);
    return restVO;
  }

  public static RestVO fail() {
    restVO.setCode(RestResultEmus.FAIL.getCode());
    restVO.setData(RestResultEmus.FAIL.getMsg());
    return restVO;
  }
}
