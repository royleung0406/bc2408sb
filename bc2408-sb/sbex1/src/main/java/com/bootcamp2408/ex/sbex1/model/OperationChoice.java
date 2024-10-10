package com.bootcamp2408.ex.sbex1.model;

import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp2408.ex.sbex1.exception.CALRestClientHandler;
import com.bootcamp2408.ex.sbex1.exception.GlobalExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Getter
@AllArgsConstructor
public enum OperationChoice {
    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("mul"),
    DIVIDE("div");

    private String operation;

    public static OperationChoice changeToEnum(String value) {
        for (OperationChoice x : OperationChoice.values()) {
            if (x.getOperation().equals(value)) {
                System.out.println("CHECK " + x);
                return x;
            }
        }
        throw new IllegalArgumentException("Json PlaceHolder Exception");
    }

    public String calculate(@PathVariable String x, @PathVariable String y) {
        double num1 = Double.parseDouble(x);
        double num2 = Double.parseDouble(y);

        return switch (this) {
            case ADD -> String.valueOf(num1 + num2);
            case SUBTRACT -> String.valueOf(num1 - num2);
            case MULTIPLY -> String.valueOf(num1 * num2);
            case DIVIDE -> {
                if (num2 == 0) {
                    throw new CALRestClientHandler("Cannot divide by zero"); 
                }
                BigDecimal result = BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(num2), 5, RoundingMode.HALF_UP);
                yield String.valueOf(result);
                
            }
        };
    }
}