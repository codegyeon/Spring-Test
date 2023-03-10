package com.example.springTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;


class SpringTestApplicationTests {


	/**요구사항
	 비밀번호는 최소 8자 이상 12자 이하
	 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생
	 경계조건(7자 와 13자 -- 해당 조건보다 근사값으로 차이날 경우)에 대해 테스트 코드 작성
	 */
	@DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
	@Test
	void validatePasswordTest() {
		assertThatCode(() -> PasswordValidator.validate("serverwizard"))
				.doesNotThrowAnyException();
	}

	@DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다")
	@ParameterizedTest
	@ValueSource(strings = {"aabbcce","aabbccddeeffg"})
	void validatePasswordTest2(String password) {
		assertThatCode(() -> PasswordValidator.validate(password))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("비밀 번호는 최소 8자 이상 12자 이하여야한다.");
	}
}
