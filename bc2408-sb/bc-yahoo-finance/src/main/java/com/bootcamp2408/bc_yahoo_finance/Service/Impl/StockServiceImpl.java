package com.bootcamp2408.bc_yahoo_finance.Service.Impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.Repositoy.StockRepository;
import com.bootcamp2408.bc_yahoo_finance.Service.StockService;
import com.bootcamp2408.bc_yahoo_finance.mapper.StockMapper;
import com.bootcamp2408.bc_yahoo_finance.model.Stock;
import com.bootcamp2408.bc_yahoo_finance.util.BusinessException;
import com.bootcamp2408.bc_yahoo_finance.util.ErrorCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  @Autowired
  private StockMapper stockMapper;
  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public List<StockEntity> saveAll(List<StockEntity> entities) {
    return this.stockRepository.saveAll(entities);
  }

  @Override
  public List<StockEntity> findAll() {
    return this.stockRepository.findAll();
  }

  @Override
  public StockEntity findBySymbol(String Symbol) {
    return this.stockRepository.findBySymbol(Symbol).orElseThrow(
        () -> new BusinessException(ErrorCode.Entity_NOT_FOUND_EX));
  }

  @Override
  public List<Stock> findAllWithCache() throws JsonProcessingException {
    // read from Redis ...
    String json = this.redisTemplate.opsForValue().get("stock-list");
    if (json == null) {
      // read from DB ...
      List<Stock> stocks = this.stockRepository.findAll().stream() //
          .map(s -> this.stockMapper.map(s)) //
          .collect(Collectors.toList());
      // write to Redis ...
      String jsonToWrite = this.objectMapper.writeValueAsString(stocks);
      this.redisTemplate.opsForValue().set("stock-list", jsonToWrite,
          Duration.ofMinutes(10));
      return stocks;
    }
    StockEntity[] stockEntities =
        this.objectMapper.readValue(json, StockEntity[].class);
    return Arrays.asList(stockEntities).stream() //
        .map(e -> this.stockMapper.map(e)) //
        .collect(Collectors.toList());
  }
}