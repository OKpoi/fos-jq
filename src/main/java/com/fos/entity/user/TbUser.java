package com.fos.entity.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class TbUser {
  /** 用户id */
  @Id
  @Column(name = "user_id")
  private Integer userId;

  /** 用户名 */
  @Column(name = "user_name")
  private String userName;

  /** 密码 */
  private String password;

  /** 性别0男 1女 未添加是-1 */
  private Integer sex;

  /** 年龄 */
  private Short age;

  @Column(name = "user_img")
  private String userImg;

  /** 邮箱 */
  private String email;

  /** 电话 */
  private String phone;

  /** 用户创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 登陆状态（‘0’未登陆 ，‘1’登陆状态） */
  private Integer state;

  /** 用户类型（‘0’普通用户 ‘1’超级管理员） */
  @Column(name = "user_type")
  private Integer userType;
}
