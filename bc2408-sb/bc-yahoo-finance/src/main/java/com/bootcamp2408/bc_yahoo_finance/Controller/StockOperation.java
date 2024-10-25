package com.bootcamp2408.bc_yahoo_finance.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.model.Stock;

public interface StockOperation {

  @GetMapping("/bcyf/stocks")
  List<Stock> getStocks();

  @PostMapping("/bcf/stocks")
  List<StockEntity> saveStocks();

  
  @PutMapping("/bcf/stocks") // by PK
  StockEntity updateUser(@RequestParam Long id, @RequestBody StockEntity entity);
  
} 
  

