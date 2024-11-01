package com.bootcamp2408.bc_yahoo_finance.Service;

import java.util.List;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.model.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockService {
  List<StockEntity> saveAll(List<StockEntity> entities);
  List<StockEntity> findAll();
  List<Stock> findAllWithCache() throws JsonProcessingException;
  StockEntity findBySymbol(String Symbol);
}