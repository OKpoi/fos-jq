package com.fos.enums.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReplyEnums {

    REPLY_NOT_EXSIT(400, "该影评无回复");

    private Integer code;
    private String msg;
}
