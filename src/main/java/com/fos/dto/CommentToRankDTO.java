package com.fos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentToRankDTO {
    //电影ID
    private Integer movieId;;
    //电影评论总数
    private Integer commentCount;
}
