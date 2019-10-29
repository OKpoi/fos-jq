package com.fos.entity.push;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_push")
public class TbPush {
  /** 用户Id */
  @Column(name = "user_id")
  private Integer userId;

  /** 关注的用户Id */
  @Column(name = "follow_id")
  private Integer followId;

  /** 关注状态 0为关注 1为取消关注 */
  private Integer state;

  /** 关注时间 */
  @Column(name = "create_time")
  private Date createTime;
}
