package com.fos.entity.comment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_movie_comment")
public class TbMovieComment {
  /** 评论ID */
  @Id
  @Column(name = "comment_id")
  private Integer commentId;

  /** 电影ID参看Movie表 */
  @Column(name = "movie_id")
  private Integer movieId;

  /** 用户ID参考User表 */
  @Column(name = "user_id")
  private Integer userId;

  /** 内容 */
  private String content;

  /** 时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 评分(从低到高 1-5) */
  private Float start;

  /** 删除与否(0-没删除,1-删除) */
  private Integer state;

  private Integer flag;
}
