package com.fos.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RankVO {
    /** 电影ID */
    private Integer movieId;

    /** 电影名 */
    private String movieName;

    /** 图片路径 */
    private String movieImg;

    /** 平均分 */
    private Short avgStar;
}
