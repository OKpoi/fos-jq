package com.fos.entity.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_admin")
public class TbAdmin {

  @TableId(type = IdType.AUTO)
  private Integer adminId;

  private String adminName;

  private String password;

  private Date loginTime;

  private Date createTime;
}
