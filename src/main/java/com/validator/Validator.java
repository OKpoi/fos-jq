package com.validator;

import com.entity.MovieComment;
import com.entity.User;
import org.springframework.stereotype.Component;

@Component(value = "validator")
public interface Validator {
    //验证用户名是否存在
    boolean validatorUserName(User user);
    //验证密码是否错误
    boolean validatorPassword(User user);
    //验证邮箱格式
    boolean validatorEmail(User user);
    //验证年龄范围
    boolean validatorAge(User user);
    //判断手机规格
    boolean validatorPhone(User user);
    //检查是否以登陆
    boolean validatorState(User user);
    //查询影评
    boolean validatorComment(MovieComment movieComment);
}
