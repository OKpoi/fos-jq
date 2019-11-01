package com.fos.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_log")
public class TbLog {
  @TableId(type = IdType.AUTO)
  private Long logId;

  /** 用户名 */
  private String userName;

  /** 创建日期 */
  private Date createdate;

  /** 日志内容 */
  private String content;

  /** 用户所做的操作 */
  private String operation;
}
