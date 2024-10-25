package com.bootcamp2408.bc_yahoo_finance.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CookieManager;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CrumbManager;


@RestController
public interface YahooFinanceOperation {




  @GetMapping("/test/cookie")
  public String test();


  @GetMapping("/test/crumb")
  public String testcrumb() throws IOException, InterruptedException;
  
}