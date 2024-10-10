package com.bootcamp2408.ex.sbex1.service.impl;

import org.springframework.stereotype.Service;
import com.bootcamp2408.ex.sbex1.model.CalculateResponse;
import com.bootcamp2408.ex.sbex1.model.OperationChoice;
import com.bootcamp2408.ex.sbex1.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {

  @Override
  public CalculateResponse getAns(String x, String y, String operation) {
    return CalculateResponse.builder() //
        .x(x) //
        .y(y) //
        .operation(operation)
        .result(OperationChoice.changeToEnum(operation).calculate(x, y)) //
        .build() //
    ;

  }
}
