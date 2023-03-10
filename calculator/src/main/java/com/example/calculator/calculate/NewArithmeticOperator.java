package com.example.calculator.calculate;

public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculate(int operate1, int operate2);
}
