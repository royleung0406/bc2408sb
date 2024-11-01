package com.bootcamp2408.bc_yahoo_finance.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Data
@Builder
@ToString

public class Stock {
private Integer id;
private String symbol;
}
