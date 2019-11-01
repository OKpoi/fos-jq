package com.fos.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVO {
  /** 用户id */
  private Integer userId;

  /** 用户名 */
  private String userName;

  /** 密码 */
  private String password;

  /** 性别0男 1女 未添加是-1 */
  private Integer sex;

  /** 年龄 */
  private Short age;

  private String userImg;

  /** 邮箱 */
  private String email;

  /** 电话 */
  private String phone;
}
