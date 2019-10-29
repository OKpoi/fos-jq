package com.fos.entity.log;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_log")
public class TbLog {
  @Id
  @Column(name = "log_id")
  private Long logId;

  /** 用户名 */
  @Column(name = "user_name")
  private String userName;

  /** 创建日期 */
  private Date createdate;

  /** 日志内容 */
  private String content;

  /** 用户所做的操作 */
  private String operation;
}
