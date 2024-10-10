package com.bootcamp2408.ex.sbex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.ex.sbex1.model.CalculateRequest;
import com.bootcamp2408.ex.sbex1.model.CalculateResponse;

public interface CalculatorOperation {

  @GetMapping("/operation/")
  public CalculateResponse method2(@RequestParam String x, @RequestParam String y, @RequestParam String operation);

  @GetMapping("/operation/{x}/{y}/{operation}")
  public CalculateResponse method(@PathVariable String x, @PathVariable String y, @PathVariable String operation);

  @PostMapping("/operation/")
  public CalculateResponse method3(@RequestBody CalculateRequest calculateRequest);
}
