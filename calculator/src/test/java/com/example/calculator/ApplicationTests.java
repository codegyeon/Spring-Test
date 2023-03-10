package com.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC 패턴 기반으로 구현한다.
 */

class ApplicationTests {

	@DisplayName("사칙 연산")
	@ParameterizedTest
	@MethodSource("formulaAndResult")
	void calculateTest(int a, String b , int c, int result) {
		int calcurateresult = Calculator.calculate(a,b ,c);
		assertThat(calcurateresult).isEqualTo(result);
	}

	@DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
	@Test
	void calculateExceptionTest() {
		assertThatCode(()-> Calculator.calculate(10,"/",0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("0으로 나눌수 없습니다.");

	}

	//	@DisplayName("덧셈 연산")
//	@Test
//	void additionTest() {
//
//
//		int result = Calculator.calculate(1,"+" ,2);
//
//		assertThat(result).isEqualTo(3);
//	}
	private static Stream<Arguments> formulaAndResult(){
		return Stream.of(
				arguments(1,"+",2,3),
				arguments(1,"-",2,-1),
				arguments(4,"*",2,8),
				arguments(2,"/",2,1)
		);
	}
}
