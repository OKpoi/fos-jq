package com.fos.enums.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MoiveEnums {
    QUERY_ALL_MOVIE_SUCCESS(200, "查询所有电影成功"),
    QUERY_MOVIE_SUCCESS(200,"查询电影成功"),
    QUERY_MOVIE_FAIL(400,"此电影不存在"),
    MOVIE_IS_NOT_EXIT(400, "电影库为空");

    private Integer code;
    private String msg;
}
