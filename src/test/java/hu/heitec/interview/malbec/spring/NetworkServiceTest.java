package hu.heitec.interview.malbec.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NetworkServiceTest {

	@Autowired
	private NetworkService networkService;

	@Test
	void testHello() {
		Assertions.assertEquals("ping", networkService.connect());
	}

}
