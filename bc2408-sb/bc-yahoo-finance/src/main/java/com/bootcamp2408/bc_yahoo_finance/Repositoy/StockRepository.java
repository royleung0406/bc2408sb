package com.bootcamp2408.bc_yahoo_finance.Repositoy;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;

@Repository // One of the component for Component Scan
public interface StockRepository extends JpaRepository<StockEntity, Long> {
  @Query("SELECT s FROM StockEntity s WHERE s.symbol = :symbol")
  List<StockEntity> findPostEntity(@Param("symbol") String symbol);



}
  

