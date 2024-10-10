package com.bootcamp2408.ex.sbex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConfig {  // bean

  // ! Usually we use "@Cofiguration + @Bean", when we use external library/class

  @Bean(name = "CalRestTemplate")
  RestTemplate restTemplateForCal() {
    return new RestTemplate(); // spring web
  }
}