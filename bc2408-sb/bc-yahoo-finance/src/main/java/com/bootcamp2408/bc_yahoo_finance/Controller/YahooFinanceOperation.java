package com.bootcamp2408.bc_yahoo_finance.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface YahooFinanceOperation {
  // http://localhost:8100/v1/yahoo/quote?symbols=0388.HK,0700.HK
  @GetMapping(value = "/yahoo/quote")
  public ResponseDTO getQuote(@RequestParam List<String> symbols)
      throws JsonProcessingException;
}