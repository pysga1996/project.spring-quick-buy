package com.omega.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGeneralException(Exception ex, WebRequest request) {
        return new ApiError(500, ex.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        String transMsg;
        for (ObjectError objectError: ex.getAllErrors()) {
            if (objectError.getDefaultMessage() != null) {
                transMsg = objectError.getDefaultMessage();
                sb.append(transMsg);
                sb.append("\n");
            }
        }
        String transMsgGroup = sb.toString();
        return new ApiError(400, transMsgGroup);
    }
}
