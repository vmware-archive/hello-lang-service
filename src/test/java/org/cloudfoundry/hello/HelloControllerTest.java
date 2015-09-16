package org.cloudfoundry.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebIntegrationTest(value = "server.port=9876")
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class HelloControllerTest {

	@Autowired
	HelloController helloController;

	@Test
	public void testHello() {
		assertEquals("Hello", helloController.sayHello("en").getGreeting());
		assertEquals("Hola", helloController.sayHello("es").getGreeting());
		assertEquals("Bonjour", helloController.sayHello("fr").getGreeting());
		assertEquals("Buon giorno", helloController.sayHello("it").getGreeting());
		assertEquals("Hallo", helloController.sayHello("de").getGreeting());
	}
}
