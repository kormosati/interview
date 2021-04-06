package hu.heitec.interview.chardonnay.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTest {

	private static final String WELCOME_MSG = "Hello Heitec!";

	@Autowired
	private HelloService helloService;

	@Test
	void testHello() {
		Assertions.assertEquals(WELCOME_MSG, helloService.hello());
	}

}
