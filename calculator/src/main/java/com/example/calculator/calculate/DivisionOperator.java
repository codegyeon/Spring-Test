package com.example.calculator.calculate;

public class DivisionOperator implements NewArithmeticOperator{

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operate1, int operate2) {
        if (operate2 == 0)
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        return operate1/operate2;
    }
}
