package com.service;

import com.dto.Layui;
import com.entity.User;

import java.io.InputStream;

public interface UserService {
    int addUser(User user, InputStream userImgInputStream,String fileName);

    User selectByUserId(User user);

    User login(User user);

    int updateUserInfo(User user);

    int updateUserImg(User user,InputStream userImgInputStream,String fileName);

    Boolean ValidatorUser(User user);
}
