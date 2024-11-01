package com.bootcamp2408.bc_yahoo_finance.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_yahoo_finance.Entity.Tstock_Quote_Yahoo;
import com.bootcamp2408.bc_yahoo_finance.model.StockDTO.ResponseDTO;

@Component
public class QuoteStockMapper {
  public Tstock_Quote_Yahoo map(ResponseDTO.QuoteBody.QuoteResult quotePrice) {
    LocalDateTime quoteDateTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(quotePrice.getRegularMarketTime()),
        ZoneId.systemDefault());
    return Tstock_Quote_Yahoo.builder()
        .symbol(quotePrice.getSymbol())
        .tranDatetime(LocalDateTime.now()) //
        .marketUnixTime(quotePrice.getRegularMarketTime()) //
        .marketDateTime(quoteDateTime) //
        .marketPrice(quotePrice.getRegularMarketPrice()) //
        .marketPriceChangePercent(quotePrice.getRegularMarketChangePercent()) //
        .ask(quotePrice.getAsk()) //
        .askSize(quotePrice.getAskSize()) //
        .bid(quotePrice.getBid()) //
        .bidSize(quotePrice.getBidSize()) //
        .build();
  }
}