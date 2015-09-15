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
		assertEquals("Hello", helloController.sayHello("en"));
		assertEquals("Hola", helloController.sayHello("es"));
		assertEquals("Bonjour", helloController.sayHello("fr"));
		assertEquals("Buon giorno", helloController.sayHello("it"));
		assertEquals("Hallo", helloController.sayHello("de"));
	}
}
