package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class Response<T> {

    private Integer statusCode;
    private String resultMessage;
    private T result;

    public static Response<Void> error(HttpStatus httpStatus, String resultMessage) {
        return new Response(httpStatus.value() ,resultMessage, null);
    }
    public static <T> Response<T> success(T result) {
        return new Response(HttpStatus.OK.value() ,"Success", result);
    }
}


