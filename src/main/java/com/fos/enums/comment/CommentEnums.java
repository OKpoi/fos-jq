package com.fos.enums.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CommentEnums {
    QUERY_COMMENT_SUCCESS(200,"查询评论成功"),
    DELETE_COMMENT_SUCCESS(200,"删除评论成功"),
    QUERY_COMMENT_BY_MOVIEID_FAIL(400,"通过电影ID查询评论失败"),
    QUERY_COMMENT_BY_USERID_FAIL(400,"通过用户ID查询评论失败"),
    DELETE_COMMENT_BY_MOIVEIDANDUSERID_FAIL(400,"删除评论失败");

    private Integer code;
    private String msg;
}
