package com.example.creditcardapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.creditcardapplication.response.APIResponse;
import com.example.creditcardapplication.response.UserResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        APIResponse apiResponse = new APIResponse(
                "FAILED",
                new UserResponse(null, ex.getMessage()) // Customize as needed
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleGenericException(Exception ex) {
        APIResponse apiResponse = new APIResponse(
                "FAILED",
                new UserResponse(null, "Internal Server Error: " + ex.getMessage())
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
