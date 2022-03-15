package com.revice.mindorder.error;

public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code, String description) {
        super(description);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
