package com.deft.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(PriceException priceException) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(priceException.getCode(), priceException.getMessage(), new String[]{priceException.getField()});
    }

        @Data
        @AllArgsConstructor
        private static class ErrorMessage {
            private String code;
            private String message;
            private String[] fields;
        }
    }




