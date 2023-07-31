package com.deft.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PriceException extends RuntimeException{

    private String code;
    private String message;
    private String field;

    public PriceException(String code, String message, String field) {
        this.code = code;
        this.message = message;
        this.field = field;
    }

//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    @Override
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
}
