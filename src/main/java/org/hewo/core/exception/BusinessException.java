package org.hewo.core.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public BusinessException(int code,String message) {
        this.message = message;
        this.code = code;
    }
}