package com.service;

import com.BaseTest;
import com.dao.UserDao;
import com.dto.Layui;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.lang.annotation.Target;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() throws FileNotFoundException {
        User user = new User();
        user.setUserName("王五1");
        user.setPassword("admin");
        user.setAge(18);
        user.setEmail("zhangsan@qq.com");
        user.setPhone("11110");
        user.setSex(01);
        user.setCreateTime(new Date());
        user.setState(1);
        user.setUserType(1);
        File file = new File("C:/Users/Public/Pictures/Sample Pictures/1.jpg");
        InputStream inputStream = new FileInputStream(file);
        int num = userService.addUser(user, inputStream, file.getName());
        System.out.println(num);

    }
    @Test
    public void selectUserTest(){
        User user=new User();
        user.setUserName("lomofulomofu");
        user=userService.login(user);
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        System.out.println(user.getCreateTime());
        System.out.println(user.getUserImg());

    }
    @Test
    public void vaildatorTest(){
        User user=new User();
        user.setUserName("lomofulomofu");
        if(userService.ValidatorUser(user)){
            System.out.println("nice");
        }else {
            System.out.println("noooooooooooooooo");
        }
    }

}
