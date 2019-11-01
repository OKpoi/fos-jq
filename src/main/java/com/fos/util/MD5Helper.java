package com.fos.util;

import org.springframework.util.DigestUtils;

/** @author FULO2 md5 加密 */
public class MD5Helper {
  public static String passwordMD5(String password) {
    String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
    return md5Password;
  }

  public static void main(String[] args) {
    //
    String s = "12345679";
    String s1 = passwordMD5(s);
    System.out.println(s);
    System.out.println(s1);
  }
}
