package com.fos.service.user.Impl;

import com.fos.common.Constant;
import com.fos.dao.user.TbUserMapper;
import com.fos.entity.user.TbUser;
import com.fos.enums.RestResultEnums;
import com.fos.enums.user.UserEnums;
import com.fos.exception.CustomerException;
import com.fos.service.user.UserService;
import com.fos.util.LoggerHelper;
import com.fos.util.MD5Helper;
import com.fos.vo.LoginVO;
import com.fos.vo.UserVO;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author FULO2
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static Pattern patternEmail = Pattern.compile(Constant.EMAIL_REGX);
    private static Pattern patternPhone = Pattern.compile(Constant.PHONE_REGX);

    @Resource
    private TbUserMapper tbUserMapper;

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
                    LoggerHelper.createCustomeExcpetionLog(
                            UserService.class.getSimpleName(),
                            "findUserByLoginVOToLogin",
                            UserEnums.EORROR_USERNAME_OR_PASSWORD.getMsg());
                    throw new CustomerException(
                            UserEnums.EORROR_USERNAME_OR_PASSWORD.getCode(),
                            UserEnums.EORROR_USERNAME_OR_PASSWORD.getMsg());
                }
            } else {
                LoggerHelper.createCustomeExcpetionLog(
                        UserServiceImpl.class.getSimpleName(),
                        "findUserByLoginVOToLogin",
                        UserEnums.USER_IS_NOT_HAVE.getMsg());
                throw new CustomerException(
                        UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
            }
        } else {
            LoggerHelper.createCustomeExcpetionLog(
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
            LoggerHelper.createCustomeExcpetionLog(
                    UserServiceImpl.class.getSimpleName(),
                    "findUserByUserId",
                    UserEnums.USER_IS_NOT_HAVE.getMsg());
            throw new CustomerException(
                    UserEnums.USER_IS_NOT_HAVE.getCode(), UserEnums.USER_IS_NOT_HAVE.getMsg());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public TbUser insert(UserVO userVO, MultipartFile file) throws CustomerException {
        TbUser tbUser = TbUser.builder().build();
        log.info("================begin to insert a new user==================");
        if (Objects.nonNull(userVO)) {
            // CompletableFuture.supplyAsync(() ->);

            BeanUtils.copyProperties(userVO, tbUser);
            tbUser.setState(0);
            tbUser.setUserType(0);
            tbUser.setCreateTime(new Date());
            tbUser.setPassword(MD5Helper.passwordMD5(userVO.getPassword()));
            int row = tbUserMapper.insert(tbUser);
            if (row > 0) {
                log.info("====================success to create a new ================");
                return tbUser;
            } else {
                LoggerHelper.createCustomeExcpetionLog(
                        UserServiceImpl.class.getSimpleName(), "insert", UserEnums.INSERT_ERROR.getMsg());
                throw new CustomerException(
                        UserEnums.INSERT_ERROR.getCode(), UserEnums.INSERT_ERROR.getMsg());
            }
        }
        LoggerHelper.createCustomeExcpetionLog(
                UserServiceImpl.class.getSimpleName(), "insert", UserEnums.INSERT_ERROR.getMsg());
        throw new CustomerException(UserEnums.INSERT_ERROR.getCode(), UserEnums.INSERT_ERROR.getMsg());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public TbUser update(TbUser tbUser) {
        int update = tbUserMapper.updateById(tbUser);
        if (update > 0) {
            return tbUser;
        } else {
            LoggerHelper.createCustomeExcpetionLog(
                    UserServiceImpl.class.getSimpleName(), "update", UserEnums.UPDATE_ERROR.getMsg());
            throw new CustomerException(
                    UserEnums.UPDATE_ERROR.getCode(), UserEnums.UPDATE_ERROR.getMsg());
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


    private String generateUserImgPath(MultipartFile file) {
        try {
            @Cleanup InputStream fileInputStream = file.getInputStream();
            String fileOriginalFilename = file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
