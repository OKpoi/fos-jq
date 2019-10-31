package com.fos.util;

import org.springframework.util.DigestUtils;

/** @author FULO2 md5 加密 */
public class MD5Helper {

  public static String passwordMD5(String password) {
    String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());
    return newPassword;
  }
}
