package com.bootcamp2408.ex.sbex1.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp2408.ex.sbex1.model.InvalidResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
  


  @ExceptionHandler({CALRestClientHandler.class})
  public InvalidResponse jphRestClientExceptionHandler(){
    return InvalidResponse.builder()//
    .code(9)//
    .message("Invalid Input")
    .build();
  }


  @ExceptionHandler({IllegalArgumentException.class})
  public InvalidResponse ExceptionHandler(){
    return InvalidResponse.builder()//
    .code(1)//
    .message("Wrong Operation, Operation should be 'add' / 'sub' / 'mul' / 'div'")
    .build();
  }
}
  

