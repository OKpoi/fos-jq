package com.aop;

import com.entity.Log;
import com.entity.User;
import com.annotation.logAnnotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService ls;

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private final static ObjectMapper jsonMapper = new ObjectMapper();
    //Controller层切点
    @Pointcut("@annotation(com.annotation.logAnnotation) ")
    public void annotationAspect() {
    }
//    @Pointcut("execution(* com.controller.*.*Controller.*(..))")
//    public void controllerAspect(){
//
//    }
    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
//    @Before("controllerAspect()")
        @After("annotationAspect()")
    public void doafter(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = (User) session.getAttribute("user");
        //请求的IP
        String ip = request.getRemoteAddr();
        if(user == null){
            user = new User();
            user.setUserName("user");
        }
//        //测试用
//        System.out.println("方法执行============================");
//        User user = new User();
//        user.setUserName("lomofu");
        try {
            String methodName = joinPoint.getSignature().getName();
            String logContent = getAnnotation(joinPoint);
            //*========控制台输出=========*//
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + logContent);
            System.out.println("请求人:" + user.getUserName());
            setLog(user.getUserName(),logContent,methodName,"Nomally");
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    /**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     */
//    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
        @AfterThrowing(pointcut = "annotationAspect()" ,throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
         //读取session中的用户
        User user = (User) session.getAttribute("user");
        System.out.println(user);
         //获取请求ip
        String ip = request.getRemoteAddr();
            if(user == null){
                user = new User();
                user.setUserName("user");
            }
//        //测试用
//      User user = new User();
//      user.setUserName("lomofu");

        String logResult = "";
        try {
            String methodName = joinPoint.getSignature().getName();
            String logContent = getAnnotation(joinPoint);
            /*========控制台输出=========*/
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + logContent);
            System.out.println("请求人:" + user.getUserName());
            setLog(user.getUserName(),logContent,methodName,"Exception");
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("异常信息:{}", ex.getMessage());
        }
        /*==========记录本地异常日志==========*/
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage());

    }
    private int setLog(String userName,String logContent,String methodName,String type){
        /*==========数据库日志=========*/
        Log log = new Log();
        log.setUsername(userName);
        log.setContent(logContent);
        log.setOperation(methodName);
        log.setCreatedate(new Date());
        log.setType(type);
        //保存数据库
        return ls.addLog(log);
    }
    private String getAnnotation(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String logContent = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    logContent = method.getAnnotation(logAnnotation.class).operationName();
                    break;
                }
            }
        }
        return logContent;
    }
}
