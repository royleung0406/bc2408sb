package com.bootcamp2408.bc_yahoo_finance.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp2408.bc_yahoo_finance.Service.YahooFinanceService;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.YHRestClient;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class YahooFinanceServiceImpl implements YahooFinanceService {
  @Autowired
  private YHRestClient yahooRestClient;

  @Override
  public ResponseDTO getQuote(List<String> symbols) throws JsonProcessingException {
    return yahooRestClient.getQuote(symbols);
  }
}