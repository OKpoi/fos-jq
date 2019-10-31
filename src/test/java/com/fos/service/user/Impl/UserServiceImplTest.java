package com.fos.service.user.Impl;

import com.fos.entity.user.TbUser;
import com.fos.service.user.UserService;
import com.fos.vo.LoginVO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootTest
class UserServiceImplTest {

  @Resource private UserService userService;

  private LoginVO loginVO;

  @BeforeEach
  void setUp() {
    loginVO =
        LoginVO.builder().userId("lomofu").password("6ee9118a9edc61838c152ff10b66c07c").build();
  }

  @Test
  void findUserByLoginVOToLogin() {
    TbUser userByLoginVOToLogin = userService.findUserByLoginVOToLogin(loginVO);

    Assert.assertNotNull(userByLoginVOToLogin);
    Assert.assertEquals(userByLoginVOToLogin.getUserName(), "lomofu");
    Assert.assertEquals(userByLoginVOToLogin.getEmail(), "2357650152@qq.com");
  }

  @Test
  void loginByAndBuild() {

    UserServiceImpl userServiceImp = new UserServiceImpl();
    try {
      Class[] cAgr = new Class[2];
      Object[] oAgr = new Object[2];
      cAgr[0] = String.class;
      cAgr[1] = String.class;
      oAgr[0] = loginVO.getUserId();
      oAgr[1] = loginVO.getPassword();
      Method loginByAndBuild = userServiceImp.getClass().getDeclaredMethod("loginByAndBuild", cAgr);
      System.out.println(loginByAndBuild.getName());
      loginByAndBuild.setAccessible(true);
      loginByAndBuild.invoke(String.class, oAgr);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
