package com.bootcamp2408.bc_yahoo_finance.Service;

import java.util.List;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface YahooFinanceService {
  ResponseDTO getQuote(List<String> symbols) throws JsonProcessingException;
}