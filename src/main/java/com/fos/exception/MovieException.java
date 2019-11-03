package com.fos.exception;

import lombok.Getter;

public class MovieException extends RuntimeException {
    @Getter
    private Integer code;

    public MovieException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
