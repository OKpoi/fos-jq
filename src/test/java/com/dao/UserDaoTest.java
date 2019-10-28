package com.dao;

import com.BaseTest;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void selectUserTest(){
        User user=new User();
        User user2=new User();
        user.setEmail("11@qq.com");
        user2.setPhone("110");
        User user1=userDao.selectUser(user);
        User user3=userDao.selectUser(user2);
        System.out.println(user1.getUserName());
        System.out.println(user3.getUserName());

    }

    @Test
    public void insertUserTest(){
        User user=new User();
        user.setUserName("a三");
        user.setPassword("admin");
        user.setAge(18);
        user.setEmail("zhangsan@qq.com");
        user.setPhone("11110");
        user.setSex(1);
        user.setUserImg("张三的图片");
        user.setCreateTime(new Date());
        user.setState(1);
        user.setUserType(1);

        int num=userDao.insertUser(user);
        assertEquals(1,num);


    }

    @Test
    public void updateUserTest(){
        User user=new User();
        user.setUserId(98);
        user.setEmail("2357650154@qq.com");
        user.setAge(20);
        int num=userDao.updateUser(user);
    }
}
