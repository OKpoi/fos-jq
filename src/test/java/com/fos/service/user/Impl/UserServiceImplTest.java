package com.fos.service.user.Impl;

import com.fos.entity.user.TbUser;
import com.fos.service.user.UserService;
import com.fos.vo.LoginVO;
import com.fos.vo.UserVO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    private LoginVO loginVO;
    private TbUser tbUser;
    private UserVO newUser;
    private TbUser updateUser;

    @BeforeEach
    void mockUp() {
        loginVO =
                LoginVO.builder().userId("lomofu").password("f49a421b2949039bb45e0c5014eb1daf").build();
        tbUser =
                TbUser.builder()
                        .userId(1004)
                        .userName("lomofu")
                        .email("2357650152@qq.com")
                        .state(1)
                        .build();
        newUser =
                UserVO.builder()
                        .userName("lomofu")
                        .password("123456789")
                        .email("ellie@qq.com")
                        .phone("1111")
                        .userImg("/user")
                        .sex(1)
                        .age(Short.valueOf("15"))
                        .build();
        updateUser =
                TbUser.builder()
                        .userId(1005)
                        .userName("eliee1")
                        .email("ellie@qq.com")
                        .phone("1111")
                        .userImg("/user")
                        .createTime(new Date(123456789L))
                        .sex(1)
                        .age(Short.valueOf("15"))
                        .userType(1)
                        .state(1)
                        .build();
    }

    @Test
    void should_return_username_lomofu_email_2357_when_findUserByLoginVOToLogin() {
        TbUser userByLoginVOToLogin = userService.findUserByLoginVOToLogin(loginVO);

        Assert.assertNotNull(userByLoginVOToLogin);
        Assert.assertEquals("lomofu", userByLoginVOToLogin.getUserName());
        Assert.assertEquals("2357650152@qq.com", userByLoginVOToLogin.getEmail());
    }

    @Test
    void should_return_lomofu_when_loginByAndBuild_use_lomofuVO() {
        UserServiceImpl userServiceImp = new UserServiceImpl();
        try {
            Method loginByAndBuild =
                    userServiceImp
                            .getClass()
                            .getDeclaredMethod("loginByAndBuild", new Class[]{String.class, String.class});
            loginByAndBuild.setAccessible(true);
            Object invoke =
                    loginByAndBuild.invoke(
                            userServiceImp.getClass().newInstance(), loginVO.getUserId(), loginVO.getPassword());
            TbUser tbUser = (TbUser) invoke;
            Assert.assertNotNull(tbUser);
            Assert.assertEquals("lomofu", tbUser.getUserName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_lomofuinfo_when_findUserByUserId_1004() {
        TbUser userByUserId = userService.findUserByUserId(tbUser.getUserId());
        Assert.assertNotNull(userByUserId);
        Assert.assertEquals("lomofu", userByUserId.getUserName());
        Assert.assertEquals("2357650152@qq.com", userByUserId.getEmail());
    }

    @Test
    void should_return_nonull_object_when_insert_newUser() throws IOException {
        TbUser insert = userService.insert(newUser, new MockMultipartFile("/dsdd", "/dsdd".getBytes()));
        Assert.assertNotNull(insert);
    }

    @Test
    void should_return_nonull_object_when_update_updateUser() {
        TbUser update = userService.update(updateUser);
        Assert.assertNotNull(update);
    }
}
