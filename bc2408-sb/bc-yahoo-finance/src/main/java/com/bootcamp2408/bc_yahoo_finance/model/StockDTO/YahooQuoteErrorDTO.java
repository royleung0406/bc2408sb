package com.bootcamp2408.bc_yahoo_finance.model.StockDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class YahooQuoteErrorDTO {
  @JsonProperty("finance")
  private ResponseDTO.QuoteBody body;
}