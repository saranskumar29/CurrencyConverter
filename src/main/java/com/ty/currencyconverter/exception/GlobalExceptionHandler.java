package com.ty.currencyconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CurrencyException.class)
    public Map<String, String> handleCurrencyException(CurrencyException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleGenericException(Exception ex) {
        return Map.of("error", "An unexpected error occurred: " + ex.getMessage());
    }
}
