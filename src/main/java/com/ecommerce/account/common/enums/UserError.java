package com.ecommerce.account.common.enums;

public enum UserError {
    INVALID_PHONE_NUMBER(400, "Invalid phone number.");
    private final int code;
    private final String message;

    UserError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
