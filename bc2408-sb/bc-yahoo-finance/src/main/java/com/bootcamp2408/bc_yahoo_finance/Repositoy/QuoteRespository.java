package com.bootcamp2408.bc_yahoo_finance.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp2408.bc_yahoo_finance.Entity.Tstock_Quote_Yahoo;


@Repository
public interface QuoteRespository
    extends JpaRepository<Tstock_Quote_Yahoo, Long> {

}