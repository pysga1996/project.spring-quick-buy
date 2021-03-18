package com.omega.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Log4j2
@RestControllerAdvice
public class ApiErrorHandler {

    private final MessageSource messageSource;

    @Autowired
    public ApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGeneralException(Exception ex) {
        log.error(ex);
        return new ApiError(500, ex.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException ex) {
        log.error(ex);
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

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleBusinessException(BusinessException ex, WebRequest request) {
        log.error(ex);
        String transMsg = this.messageSource.getMessage(ex.getMessage(), null, request.getLocale());
        return new ApiError(ex.getCode(), transMsg);
    }
}
