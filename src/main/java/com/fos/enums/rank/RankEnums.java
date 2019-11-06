package com.fos.enums.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RankEnums {
    QUERY_ALL_MOVIE_RANK_SUCCESS(200,"电影排行查询成功"),
    QUERY_ALL_MOVIE_RANK_FAIL(400,"排行榜不存在");


    private Integer code;
    private String msg;
}
