package com.util;
import com.auth0.jwt.interfaces.Claim;
import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * http请求获取内容通过key
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();

            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static User JsonToClass(HttpServletRequest request) throws IOException {
        String userString = HttpServletRequestUtil.getString(request, "userString");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        user = mapper.readValue(userString, User.class);
        user.setPassword(SpringMD5.passwordMD5(user.getPassword()));
        return user;
    }

    public static CommonsMultipartFile getUserImg(HttpServletRequest request) {
        CommonsMultipartFile userImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            userImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("userImg");
            return userImg;
        } else {
            return userImg;
        }
    }

    public static String getTokenFromRedis( HttpServletRequest request) {
        System.out.println(request.getHeader("Authorization"));
        String token = (String) request.getHeader("Authorization");
        Map<String, Claim> verifyToken = null;
        if (token != null) {

            try {
                verifyToken = JWTUtils.verifyToken(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String userId = verifyToken.get("userId").asString();
            //缓存中的token
            String usertoken = JedisUtils.getToken(userId);
            return usertoken;
        }else {
            return null;
        }
    }
}
