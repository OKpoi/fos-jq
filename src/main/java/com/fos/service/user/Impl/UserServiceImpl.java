package com.fos.service.user.Impl;

import com.fos.dao.user.TbUserMapper;
import com.fos.entity.user.TbUser;
import com.fos.enums.user.UserEnums;
import com.fos.exception.CustomerException;
import com.fos.service.user.UserService;
import com.fos.util.MD5Helper;
import com.fos.vo.LoginVO;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/** @author FULO2 */
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

      TbUser resultUser = findOne(tbUser);
      if (Objects.nonNull(resultUser)) {
        if (StringUtils.hasLength(resultUser.getPassword())
            && resultUser.getPassword().equals(password)) {
          return resultUser;
        } else {
          throw new CustomerException(
              UserEnums.EORROR_USERNAME_OR_PASSWORD.getCode(),
              UserEnums.EORROR_USERNAME_OR_PASSWORD.getMsg());
        }
      } else {
        throw new CustomerException(
            UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
      }
    } else {
      throw new CustomerException(
          UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
    }
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

  @Override
  public TbUser findById(Integer id) {
    return null;
  }

  @Override
  public TbUser findOne(TbUser tbUser) {
    return tbUserMapper.selectOneUser(tbUser);
  }

  @Override
  public List<TbUser> findAll() {
    return null;
  }

  @Override
  public Boolean update(TbUser tbUser) {
    return null;
  }

  @Override
  public Boolean insert(TbUser tbUser) {
    return null;
  }
}
