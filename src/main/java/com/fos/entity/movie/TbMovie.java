package com.fos.entity.movie;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_movie")
public class TbMovie {
  /** 电影ID */
  @TableId(type = IdType.AUTO)
  private Integer movieId;

  /** 电影名 */
  private String movieName;

  /** 类型id */
  private Integer typeId;

  /** 上映时间 */
  private Date onTime;

  /** 语言类型 */
  private String language;

  /** 国家/地区 */
  private String country;

  /** 电影时长 */
  private String movieTime;

  /** 导演名 */
  private String director;

  /** 演员 */
  private String actor;

  /** 图片路径 */
  private String movieImg;

  /** 视频路径 */
  private String movieVideo;

  /** 简介 */
  private String profile;
}
