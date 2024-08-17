package com.example.BookStore.BookStore.Common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(Exception e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setError("Something Went Wrong");
        apiResponse.setStatus(500);

        return ResponseEntity.status(500).body(apiResponse);
    }

    @ExceptionHandler
    public ResponseEntity handleBadRequestException(BadRequestException e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setError(e.getErrors());
        apiResponse.setStatus(400);

        return ResponseEntity.status(400).body(apiResponse);
    }
}
