package com.fos.entity.movie;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_movie")
public class TbMovie {
  /** 电影ID */
  @Id
  @Column(name = "movie_id")
  private Integer movieId;

  /** 电影名 */
  @Column(name = "movie_name")
  private String movieName;

  /** 类型id */
  @Column(name = "type_id")
  private Integer typeId;

  /** 上映时间 */
  @Column(name = "on_time")
  private Date onTime;

  /** 语言类型 */
  private String language;

  /** 国家/地区 */
  private String country;

  /** 电影时长 */
  @Column(name = "movie_time")
  private String movieTime;

  /** 导演名 */
  private String director;

  /** 演员 */
  private String actor;

  /** 图片路径 */
  @Column(name = "movie_img")
  private String movieImg;

  /** 视频路径 */
  @Column(name = "movie_video")
  private String movieVideo;

  /** 简介 */
  private String profile;
}
