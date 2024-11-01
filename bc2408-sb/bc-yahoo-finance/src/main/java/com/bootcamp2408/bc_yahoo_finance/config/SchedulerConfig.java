package com.bootcamp2408.bc_yahoo_finance.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.Entity.Tstock_Quote_Yahoo;
import com.bootcamp2408.bc_yahoo_finance.Repositoy.QuoteRespository;
import com.bootcamp2408.bc_yahoo_finance.Service.StockService;
import com.bootcamp2408.bc_yahoo_finance.Service.YahooFinanceService;
import com.bootcamp2408.bc_yahoo_finance.mapper.QuoteStockMapper;
import com.bootcamp2408.bc_yahoo_finance.model.Stock;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class SchedulerConfig {
  @Autowired
  private YahooFinanceService yahooFinanceService;
  @Autowired
  private QuoteStockMapper quoteStockMapper;
  @Autowired
  private StockService stockService;
  @Autowired
  private QuoteRespository quoteRespository;
 
  // ! Every 15 minutes
  @Scheduled(fixedRate = 300_000)
  // @Scheduled(cron = "0 */5 9-16 * * MON-FRI")
  public void stockQuote() throws JsonProcessingException {
    List<Stock> stocks = this.stockService.findAllWithCache();
    if (stocks == null || stocks.size() == 0)
      return;
    List<String> symbols = stocks.stream() //
        .map(s -> s.getSymbol()) //
        .collect(Collectors.toList());
    // System.out.println("symbols=" + symbols);
    ResponseDTO quoteDTO = this.yahooFinanceService.getQuote(symbols);
    quoteDTO.getBody().getResults().forEach(s -> {
      StockEntity stockEntity = this.stockService.findBySymbol(s.getSymbol());
      Tstock_Quote_Yahoo stockPriceEntity = this.quoteStockMapper.map(s);
      stockPriceEntity.setStock(stockEntity);
      stockPriceEntity.setSymbol(stockEntity.getSymbol());
      stockPriceEntity.setTranType("5MIN");
      this.quoteRespository.save(stockPriceEntity);
    });
  }
}