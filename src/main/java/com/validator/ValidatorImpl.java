package com.validator;

import com.dao.CommentDao;
import com.dao.UserDao;
import com.entity.MovieComment;
import com.entity.User;
import com.util.SpringMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
* 以下为校验类true为通过 flase为不通过
* */
@Component(value = "validatorImpl")
public class ValidatorImpl implements Validator {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    /*
    判断是否在数据库中以存在用户名true为不存在，false存在
     */
    @Override
    public boolean validatorUserName(User user) {
        User usertemp = new User();
        usertemp.setUserName(user.getUserName());
        usertemp = getDate(usertemp);
        if(usertemp != null){
            return false;
        }
        return true;
    }
    /*
    * 判断用户密码是否和数据库中的密码一致（采用MD5加密）
    * */
    @Override
    public boolean validatorPassword(User user) {
        String passwordMD5 = SpringMD5.passwordMD5(user.getPassword());
        String passwordDB = getDate(user).getPassword();
        if(passwordMD5 == passwordDB){
            return true;
        }
        return false;
    }
    /*
   判断用户登陆状态状态
   */
    @Override
    public boolean validatorState(User user) {
        int stateDB = getDate(user).getState();
        if(stateDB == 0){
            return true;
        }
        return false;
    }

    /*
    * 判断邮箱规格
    * */
    @Override
    public boolean validatorEmail(User user) {
        User usertemp = new User();
        String emil = user.getEmail();
        usertemp.setEmail(emil);
        usertemp = getDate(usertemp);
        if(usertemp != null){
            return false;
        }
        return (emil.contains("@") && emil.contains(".com"));
    }
    /*
    * 判断年龄规格
    * */
    @Override
    public boolean validatorAge(User user) {
        int age = user.getAge();
        if(age < 120 && age > 0)
            return true;
        return false;
    }
    /*
    * 判断手机规格
    * */
    @Override
    public boolean validatorPhone(User user) {
        String phone = user.getPhone();
        User usertemp = new User();
        usertemp.setPhone(phone);
        usertemp = getDate(usertemp);
        if(usertemp != null){
            return false;
        }
        int phonelength = phone.length();
        if(phonelength != 11 )
            return false;
        return true;
    }
    /*
    * 判断评论是否存在
    * */
    @Override
    public boolean validatorComment(MovieComment movieComment) {
        if(commentDao.selectComment(movieComment) == null ||  commentDao.selectComment(movieComment).equals(""))
            return true;
        else
            return false;
    }

    private User getDate(User user){
        return userDao.selectUser(user);
    }
}
