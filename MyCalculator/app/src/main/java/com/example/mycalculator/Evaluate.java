package com.example.mycalculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.math.BigDecimal;

public class Evaluate {
    public static BigDecimal evaluate(String expression) {
        Expression e = new ExpressionBuilder(expression).build();
        return BigDecimal.valueOf(e.evaluate());
    }
}
