package com.bootcamp2408.bc_yahoo_finance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteStock {
private String symbol;
private String regularMarketUnix;
private String regularMarketPrice;
private String regularMarketChangePercent;
private Double bid;
private Integer bidSize;
private Double ask;
private Integer askSize;
}
