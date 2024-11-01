package com.bootcamp2408.bc_yahoo_finance.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.model.Stock;

@Component
public class StockMapper {
  public Stock map(StockEntity stockEntity) {
    return Stock.builder() //
        .id(stockEntity.getId()) //
        .symbol(stockEntity.getSymbol())
        .build();
  }
}
