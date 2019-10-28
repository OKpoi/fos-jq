package com.validator;


import com.entity.MovieComment;
import com.entity.User;
import org.springframework.stereotype.Component;

/*
* 创建检验工厂分登陆检验和注册校验
* */
@Component(value = "validatorFactory")
public interface ValidatorFactory {
    String CreateLoginVali(User user);
    boolean CreateRegisterVali(User user);
    boolean CreateCommentVali(MovieComment movieComment);
}
