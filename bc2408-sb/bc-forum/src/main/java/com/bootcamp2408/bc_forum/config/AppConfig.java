package com.bootcamp2408.bc_forum.config;

import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


// Component Scan -> @Controller, @Service, @Configuration
// ! @Cofiguration + @Bean
@Configuration
public class AppConfig {  // bean

  // ! Usually we use "@Cofiguration + @Bean", when we use external library/class

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate(); // spring web
  }
  }
