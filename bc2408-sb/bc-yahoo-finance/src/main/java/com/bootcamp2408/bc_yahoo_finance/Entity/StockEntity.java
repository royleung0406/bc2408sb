package com.bootcamp2408.bc_yahoo_finance.Entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Stock")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity implements Serializable{
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Integer id;
  private String symbol;

  public StockEntity(String symbol){
    this.symbol = symbol;
  }
}  

