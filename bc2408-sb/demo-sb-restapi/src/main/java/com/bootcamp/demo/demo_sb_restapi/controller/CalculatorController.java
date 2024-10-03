package com.bootcamp.demo.demo_sb_restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {
  
  @GetMapping(value = "/sum/{x}/{y}")
  public int sum(@PathVariable int x, @PathVariable int y){
    return (long) x + (long) y > Integer.MAX_VALUE ? -1 : x + y;


    }

  @GetMapping(value = "/subtract/{x}/{y}")
  public int paidAmount(@PathVariable (value =  "x") int checkoutAmount,// 
  @PathVariable (value = "y") int discountAmount){

    return checkoutAmount - discountAmount;
  }

  @GetMapping(value = "/mutiply/{x}/{y}")
  public int mutiply(@PathVariable int x, @PathVariable int y){
    return x * y;
  }

    @GetMapping(value = "/divide/{x}/{y}")
    public String devide(@PathVariable String x, @PathVariable String y){
      try{
        int x1 = Integer.parseInt(x);
        int y1 = Integer.parseInt(y);
      return String.valueOf(x1 / y1);
      } catch (AbstractMethodError e){
        return "x and y should not be non-zero";
      } catch (NumberFormatException e){
        return "x and y should not be non-zero";
      }
}
  }