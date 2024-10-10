package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.DemoSbRestapiApplication;
import com.bootcamp.demo.demo_sb_restapi.controller.BeanOperation;


@RestController
public class BeanController implements BeanOperation {

  private int x = 10; 
  @Override
  public List<String> getBeans(){
    return List.of(DemoSbRestapiApplication.context.getBeanDefinitionNames());
  }

  @Override
  public int getX(){
    return this.x;
  }
  
}
