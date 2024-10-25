package com.bootcamp2408.bc_yahoo_finance.Controller.impl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_yahoo_finance.Controller.YahooFinanceOperation;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CookieManager;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CrumbManager;

@RestController
public class YahooFinanceImpl implements YahooFinanceOperation{

  @Autowired

  CookieManager cookieManager;

  @Autowired
  CrumbManager crumbManager;

  @Override
   public String test(){
    return this.cookieManager.getCookie();
   }

   @Override
   public String testcrumb() throws IOException, InterruptedException{
    return this.crumbManager.getCrumb();
   }
  
}
