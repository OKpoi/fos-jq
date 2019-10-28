package com.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJ {



    @Before(value = "execution(* com.service.MovieTypeService.getAllMovieType(..))")
    public void before(){
        System.out.println("权限验证===================");
    }
}
