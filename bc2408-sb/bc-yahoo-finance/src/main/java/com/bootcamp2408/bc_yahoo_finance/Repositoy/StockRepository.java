package com.bootcamp2408.bc_yahoo_finance.Repositoy;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
  Optional<StockEntity> findBySymbol(String symbol);
}
  

