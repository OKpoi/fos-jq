package com.fos.service.user.Impl;

import com.fos.dao.user.TbUserMapper;
import com.fos.entity.user.TbUser;
import com.fos.enums.RestResultEnums;
import com.fos.enums.user.UserEnums;
import com.fos.exception.CustomerException;
import com.fos.service.user.UserService;
import com.fos.util.LogHelper;
import com.fos.util.MD5Helper;
import com.fos.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author FULO2 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private static Pattern patternEmail =
      Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
  private static Pattern patternPhone =
      Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");

  @Resource private TbUserMapper tbUserMapper;

  @Override
  public TbUser findUserByLoginVOToLogin(LoginVO loginVO) throws CustomerException {
    if (Objects.nonNull(loginVO)
        && StringUtils.hasLength(loginVO.getUserId())
        && StringUtils.hasLength(loginVO.getPassword())) {
      String username = loginVO.getUserId();
      String password = MD5Helper.passwordMD5(loginVO.getPassword());
      TbUser tbUser = loginByAndBuild(username, password);

      TbUser resultUser = tbUserMapper.selectOneUserToLogin(tbUser);
      if (Objects.nonNull(resultUser)) {
        if (StringUtils.hasLength(resultUser.getPassword())
            && resultUser.getPassword().equals(password)) {
          return resultUser;
        } else {
          LogHelper.createCustomeExcpetionLog(
              UserService.class.getSimpleName(),
              "findUserByLoginVOToLogin",
              UserEnums.EORROR_USERNAME_OR_PASSWORD.getMsg());
          throw new CustomerException(
              UserEnums.EORROR_USERNAME_OR_PASSWORD.getCode(),
              UserEnums.EORROR_USERNAME_OR_PASSWORD.getMsg());
        }
      } else {
        LogHelper.createCustomeExcpetionLog(
            UserServiceImpl.class.getSimpleName(),
            "findUserByLoginVOToLogin",
            UserEnums.USER_IS_NOT_HAVE.getMsg());
        throw new CustomerException(
            UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
      }
    } else {
      LogHelper.createCustomeExcpetionLog(
          UserService.class.getSimpleName(),
          "findUserByLoginVOToLogin",
          RestResultEnums.FAIL.getMsg());
      throw new CustomerException(RestResultEnums.FAIL.getCode(), RestResultEnums.FAIL.getMsg());
    }
  }

  @Override
  public TbUser findUserByUserId(Integer userId) throws CustomerException {
    TbUser tbUser = tbUserMapper.selectById(userId);
    if (Objects.nonNull(tbUser)) {
      return tbUser;
    } else {
      LogHelper.createCustomeExcpetionLog(
          UserServiceImpl.class.getSimpleName(),
          "findUserByUserId",
          UserEnums.USER_IS_NOT_HAVE.getMsg());
      throw new CustomerException(
          UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
    }
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public TbUser insert(TbUser tbUser)
      throws CustomerException, ExecutionException, InterruptedException {
    log.info("================begin to insert a new user==================");

    boolean tbUserCompletableFuture =
        CompletableFuture.supplyAsync(() -> tbUserMapper.insert(tbUser))
            .thenApply(integer -> tbUserMapper.selectById(integer))
            .complete(tbUser);

    if (tbUserCompletableFuture) {
      log.info("====================success to create a new ================");
      return tbUser;
    } else {
      LogHelper.createCustomeExcpetionLog(
          UserServiceImpl.class.getSimpleName(), "insert", UserEnums.INSERT_ERROR.getMsg());
      throw new CustomerException(
          UserEnums.INSERT_ERROR.getCode(), UserEnums.INSERT_ERROR.getMsg());
    }
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public TbUser update(TbUser tbUser) {
   CompletableFuture.supplyAsync(()->tbUserMapper.update(tbUser)).thenApply()
    if (update > 0) {}

    return null;
  }

  private TbUser loginByAndBuild(String username, String password) {
    TbUser tbUser = null;
    Matcher matcherEmail = patternEmail.matcher(username);
    Matcher matcherPhone = patternPhone.matcher(username);
    if (matcherEmail.find()) {
      tbUser = TbUser.builder().email(username).password(password).build();
    } else if (matcherPhone.find()) {
      tbUser = TbUser.builder().phone(username).password(password).build();
    } else {
      tbUser = TbUser.builder().userName(username).password(password).build();
    }
    return tbUser;
  }
}
