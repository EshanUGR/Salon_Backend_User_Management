package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.payload.response.ExceptionResponse;

@ControllerAdvice
public class GlobleExceptionHandler {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> ExceptionHandler(Exception ex,WebRequest req)
  {
  
    ExceptionResponse response=new ExceptionResponse(
ex.getMessage(),
req.getDescription(false),
LocalDateTime.now()


    );

    return ResponseEntity.ok(response);
  }
  
}
