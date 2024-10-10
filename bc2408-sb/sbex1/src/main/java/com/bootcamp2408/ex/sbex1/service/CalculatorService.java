package com.bootcamp2408.ex.sbex1.service;

import com.bootcamp2408.ex.sbex1.model.CalculateResponse;
import com.bootcamp2408.ex.sbex1.model.OperationChoice;

public interface CalculatorService {

  CalculateResponse getAns(String x, String y, String operation);
  
}