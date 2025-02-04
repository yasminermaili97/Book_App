package com.book_app.book_app1.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FieldErrorResponse extends  ErrorResponse{

    private Map<String,String> fieldErrors;
    public FieldErrorResponse(String message, String details, int code ,Map<String, String> fieldErrors) {
        super(message, details, code);
        this.fieldErrors = fieldErrors;
    }
}
