package com.example.MenuItem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 음식점에서 음식 주문하는 과정 구현
 *
 * 요구사항
 *
 * 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 * 객체들 간의 관계를 고민
 * 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링
 * 협력을 설계
 * 객체들을 포괄하는 타입에 적절한 책임을 할당
 * 구현
 */

class MenuItemApplicationTests {

	@DisplayName("메뉴이름에 해당하는 주문을 한다.")
	@Test
	void orderTest() {
		Customer customer = new Customer();
		Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면" , 7000)));
		Cooking cooking = new Cooking();

		assertThatCode(() -> customer.order("돈까스" , menu, cooking))
				.doesNotThrowAnyException();
	}

}
