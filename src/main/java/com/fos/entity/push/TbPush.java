package com.fos.entity.push;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_push")
public class TbPush {
  /** 用户Id */
  private Integer userId;

  /** 关注的用户Id */
  private Integer followId;

  /** 关注状态 0为关注 1为取消关注 */
  private Integer state;

  /** 关注时间 */
  private Date createTime;
}
