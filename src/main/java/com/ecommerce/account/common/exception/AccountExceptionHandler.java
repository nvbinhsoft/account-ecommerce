package com.ecommerce.account.common.exception;

import com.ecommerce.account.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  AccountExceptionHandler is global exception handler for account service.
 * <p>
 * Each {@code @ExceptionHandler} method in this class corresponds to a specific exception type.
 * When that exception is thrown, the associated handler method is invoked to produce
 * an appropriate HTTP response.
 * </p>
 * <p>
 * To extend the error handling capabilities, simply add more {@code @ExceptionHandler} methods
 * for the new exception types.
 * </p>
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@RestControllerAdvice
public class AccountExceptionHandler {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<BaseResponse<String>> handleInvalidUserException(InvalidUserException ex) {
        BaseResponse<String> errorResponse = new BaseResponse<>(ex.getCode(), ex.getMessage(), "");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
