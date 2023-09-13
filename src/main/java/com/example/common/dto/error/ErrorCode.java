package com.example.common.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    DUPLICATED_USERNAME(HttpStatus.CONFLICT, "Username is duplicated."),
    LOGIN_FAIL(HttpStatus.UNAUTHORIZED, "로그인 정보가 올바르지 않습니다.");

    private HttpStatus status;

    private String message;
}
