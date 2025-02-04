package com.book_app.book_app1.exception;

import ch.qos.logback.core.model.processor.ModelHandlerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "Error not Found Exception", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Formato incorrecto en la solicitud. Verifique los valores permitidos.";

        if (ex.getCause() != null && ex.getCause().getMessage() != null) {
            String causa = ex.getCause().getMessage();

            if (causa.contains("Types")) {
                errorMessage = "Tipo no válido para 'type'. Valores permitidos: DRAMA,SCIFI, MANGA, SPORT,COOKING.";
            } else if (causa.contains("Status")) {
                errorMessage = "Estado no válido para 'status'. Valores permitidos: ONSALE, PREORDER.";
            }
        }

        ErrorResponse errorResponse = new ErrorResponse(
                errorMessage,
                "Error validatión de datos de entrada",
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FieldErrorResponse(ex.getMessage(), "Erroresde validatión de datos de entrada",HttpStatus.BAD_REQUEST.value(), errors));
    }
}
