package com.Interceptors;
import com.auth0.jwt.interfaces.Claim;
import com.util.JWTUtils;
import com.util.JedisUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("=================拦截=================");
        response.setCharacterEncoding("utf-8");
        //拿到用户请求的token
        String token = (String) request.getHeader("Authorization");
        Map<String, Claim> verifyToken= JWTUtils.verifyToken(token);
        String userId=verifyToken.get("userId").asString();
        //缓存中的token
        String usertoken=JedisUtils.getToken(userId);
        if(usertoken!=null) {
            System.out.println("=================token验证成功=================");
            return true;
        }else {

            System.out.println("=================token失效=================");

            response.sendRedirect("index.jsp");
            throw new RuntimeException("用户不存在，请重新登录");
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
