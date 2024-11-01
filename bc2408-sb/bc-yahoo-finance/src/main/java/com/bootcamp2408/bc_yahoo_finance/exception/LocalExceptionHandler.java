package com.bootcamp2408.bc_yahoo_finance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.YahooQuoteErrorDTO;
import com.bootcamp2408.bc_yahoo_finance.util.ApiResp;
import com.bootcamp2408.bc_yahoo_finance.util.GlobalExceptionalHandler;


@RestControllerAdvice
public class LocalExceptionHandler extends GlobalExceptionalHandler {
  @ExceptionHandler({StockQuoteYahooException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<YahooQuoteErrorDTO> businessExceptionHandler(StockQuoteYahooException e) {
    return ApiResp.<YahooQuoteErrorDTO>builder() //
        .fail(e) //
        .build();
  }
}