package com.fos.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@TableName("tb_user")
public class TbUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别0男 1女 未添加是-1
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Short age;

    private String userImg;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 登陆状态（‘0’未登陆 ，‘1’登陆状态）
     */
    private Integer state;

    /**
     * 用户类型（‘0’普通用户 ‘1’超级管理员）
     */
    private Integer userType;
}
