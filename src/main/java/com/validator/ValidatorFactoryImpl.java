package com.validator;

import com.entity.MovieComment;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "validatorFactoryImpl")
public class ValidatorFactoryImpl  implements  ValidatorFactory{
    @Autowired
    Validator validator;
    @Override
    public String CreateLoginVali(User user) {
        boolean login_name = validator.validatorUserName(user);
        boolean login_password = validator.validatorPassword(user);
        boolean login_state = validator.validatorState(user);
        if(login_name) {
            return "用户不存在";
        }else if(!login_password){
            return "密码错误";
        }else if(!login_state){
            return "用户一登陆";
        }
        return "验证通过";
    }

    @Override
    public boolean  CreateRegisterVali(User user) {
        if(validator.validatorUserName(user) && validator.validatorEmail(user) && validator.validatorPhone(user))
            return true;
        return false;
    }

    @Override
    public boolean CreateCommentVali(MovieComment movieComment) {
        if (validator.validatorComment(movieComment))
            return true;
        else
            return false;
    }
}
