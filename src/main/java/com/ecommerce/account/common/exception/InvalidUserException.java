package com.ecommerce.account.common.exception;

public class InvalidUserException extends RuntimeException {
    private final Long code;
    private final String errorMessage;

    public InvalidUserException(Long code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public Long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
