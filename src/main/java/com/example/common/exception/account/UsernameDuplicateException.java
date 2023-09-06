package com.example.common.exception.account;

import com.example.common.dto.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsernameDuplicateException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    @Override
    public String toString() {

        if (message == null) {
            return errorCode.getMessage();
        }
        return String.format("%s, %s", errorCode.getMessage(), message);
    }
}
