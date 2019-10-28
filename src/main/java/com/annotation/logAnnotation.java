package com.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface logAnnotation {
/** 要执行的具体操作比如：添加用户 **/
   String operationName() default "";
}