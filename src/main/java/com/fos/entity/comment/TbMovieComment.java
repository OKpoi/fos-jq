package com.fos.entity.comment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_movie_comment")
public class TbMovieComment {
  /** 评论ID */
  @TableId(type = IdType.AUTO)
  private Integer commentId;

  /** 电影ID参看Movie表 */
  private Integer movieId;

  /** 用户ID参考User表 */
  private Integer userId;

  /** 内容 */
  private String content;

  /** 时间 */
  private Date createTime;

  /** 评分(从低到高 1-5) */
  private Float start;

  /** 删除与否(0-没删除,1-删除) */
  private Integer state;

  private Integer flag;
}
