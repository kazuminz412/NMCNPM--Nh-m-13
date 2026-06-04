package com.bluemoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Xử lý 404 errors
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "status", 404,
            "message", "Resource not found: " + ex.getResourcePath(),
            "timestamp", System.currentTimeMillis()
        ));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        body.put("message", "Request method '" + ex.getMethod() + "' is not supported for this endpoint");
        String[] methods = ex.getSupportedMethods();
        body.put("supportedMethods", methods == null ? new String[]{} : methods);
        body.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(body);
    }

    /**
     * Xử lý các exception khác
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
            "status", 500,
            "message", "Internal Server Error",
            "error", ex.getMessage(),
            "timestamp", System.currentTimeMillis()
        ));
    }
}