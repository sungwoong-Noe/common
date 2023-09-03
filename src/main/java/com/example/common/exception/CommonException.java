package com.example.common.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommonException extends RuntimeException {

    private final Map<String, String> validation = new HashMap<>();


    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

}
