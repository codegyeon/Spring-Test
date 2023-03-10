package com.example.calculator.calculate;

public class SubtractionOperator implements NewArithmeticOperator{


    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(int operate1, int operate2) {
        return operate1 - operate2;
    }
}
