package com.bootcamp2408.bc_yahoo_finance.exception;

import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.YahooQuoteErrorDTO;
import com.bootcamp2408.bc_yahoo_finance.util.BusinessException;
import com.bootcamp2408.bc_yahoo_finance.util.ErrorCode;

public class StockQuoteYahooException extends BusinessException {
  public StockQuoteYahooException(YahooQuoteErrorDTO quoteErrorDTO) {
    super(ErrorCode.REST_CLIENT_EX,
        quoteErrorDTO.getBody().getError().getMessage());
  }
}