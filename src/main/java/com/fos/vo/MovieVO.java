package com.fos.vo;

import lombok.Builder;
import lombok.Data;


import java.util.Date;


@Data
@Builder
public class MovieVO {
    private Integer movieId;

    /** 电影名 */
    private String movieName;

    /** 类型名字 */
    private String typeName;

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
