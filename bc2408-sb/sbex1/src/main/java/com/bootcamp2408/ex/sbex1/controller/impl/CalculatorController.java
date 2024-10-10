package com.bootcamp2408.ex.sbex1.controller.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.ex.sbex1.controller.CalculatorOperation;
import com.bootcamp2408.ex.sbex1.model.CalculateRequest;
import com.bootcamp2408.ex.sbex1.model.CalculateResponse;
import com.bootcamp2408.ex.sbex1.model.OperationChoice;
import com.bootcamp2408.ex.sbex1.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperation {

    @Autowired
    CalculatorService calculatorService;
    @Override
    public CalculateResponse method(String x, String y, String operation) {
        return calculatorService.getAns(x,y,operation);
    }
    

    @Override
    public CalculateResponse method2(String x, String y, String operation){
        return calculatorService.getAns(x, y, operation);
    }

    @Override
    public CalculateResponse method3(CalculateRequest calculateRequest){
        return calculatorService.getAns(calculateRequest.getX(), calculateRequest.getY(), calculateRequest.getOperation());
    }


}