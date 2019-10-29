package com.fos.entity.stars;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_stars")
public class TbStars {
  /** 用户Id */
  @Column(name = "user_id")
  private Integer userId;

  /** 电影Id */
  @Column(name = "movie_id")
  private Integer movieId;

  /** 收藏状态 0为收藏 1为取消收藏 */
  private Integer state;

  /** 收藏时间 */
  @Column(name = "create_time")
  private Date createTime;
}
