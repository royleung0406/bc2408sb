package com.bootcamp2408.bc_yahoo_finance.config;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.Repositoy.StockRepository;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CookieManager;


// @Autowired(required = false)
// private CommandLineRunner runner;
// runner.run();

@Component
public class AppStartRunner implements CommandLineRunner {

@Autowired
StockRepository stockRepository;


 private CookieManager cookieManager;

@Override
public void run(String... args) throws Exception {
  
    List<StockEntity> stockEntities = List.of(
      new StockEntity("0388.HK"),
      new StockEntity("0700.HK"),
      new StockEntity("09988.HK")
    );

    this.stockRepository.saveAll(stockEntities);
  //    try {
  //           URL url = new URL("https://fc.yahoo.com");
  //           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  //           connection.setRequestMethod("GET");
            
  //           // Connect to the URL
  //           connection.connect();
            
  //           // Get the response headers
  //           Map<String, List<String>> headerFields = connection.getHeaderFields();
  //           List<String> cookies = headerFields.get("Set-Cookie");

  //           if (cookies != null) {
  //               System.out.println("Cookies:");
  //               for (String cookie : cookies) {
  //                   System.out.println(cookie);
  //               }
  //           } else {
  //               System.out.println("No cookies found in the response headers.");
  //           }
            
  //           connection.disconnect();
  //       } catch (Exception e) {
  //           e.printStackTrace();
  //       }
      
  // }
}

}
