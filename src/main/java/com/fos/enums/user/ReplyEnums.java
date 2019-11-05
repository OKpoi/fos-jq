package com.fos.enums.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReplyEnums {

    REPLY_NOT_EXIST(400, "该影评无回复"),
    USER_REPLY_NOT_EXIST(400, "该用户为含回复"),
    COMMENT_REPLY_NOT_EXIST(400, "改影评未含回复");

    private Integer code;
    private String msg;
}
