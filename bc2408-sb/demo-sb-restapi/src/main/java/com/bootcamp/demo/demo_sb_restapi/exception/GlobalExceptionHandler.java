package com.bootcamp.demo.demo_sb_restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler({RestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String restClientExceptionHandler(){
    return "Service Unavailable. Please try again later";
  }

  @ExceptionHandler({JPHRestClientException.class})
  public String jphRestClientExceptionHandler(){
    return "Json Placeholder Service Unavailable. Please try again later";
  }
}
