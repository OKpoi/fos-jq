package com.fos.entity.stars;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_stars")
public class TbStars {
  /** 用户Id */
  private Integer userId;

  /** 电影Id */
  private Integer movieId;

  /** 收藏状态 0为收藏 1为取消收藏 */
  private Integer state;

  /** 收藏时间 */
  private Date createTime;
}
