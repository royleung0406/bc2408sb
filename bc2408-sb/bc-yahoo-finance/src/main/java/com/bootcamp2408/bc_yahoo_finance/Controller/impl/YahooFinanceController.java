package com.bootcamp2408.bc_yahoo_finance.Controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_yahoo_finance.Controller.YahooFinanceOperation;
import com.bootcamp2408.bc_yahoo_finance.Service.YahooFinanceService;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/v1")
public class YahooFinanceController implements YahooFinanceOperation {

  @Autowired
  private YahooFinanceService yahooFinanceService;

  @Override
  public ResponseDTO getQuote(List<String> symbols) throws JsonProcessingException {
    return yahooFinanceService.getQuote(symbols);
  }
}