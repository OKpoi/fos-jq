package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUser(User user);

    User selectUserById(User user);
    //增加新用户
    int insertUser(User user);
    //更新用户信息
    int updateUser(User user);
}
