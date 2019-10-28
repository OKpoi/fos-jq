package com.util;

import org.springframework.util.DigestUtils;

/**
 * md5加密
 */
public class SpringMD5 {
    public static  String passwordMD5(String Password){
        String p_MD5 = DigestUtils.md5DigestAsHex(Password.getBytes());
        return p_MD5;
    }
}
