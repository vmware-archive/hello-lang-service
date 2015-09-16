package org.cloudfoundry.hello;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Resource(name = "hellos")
	private Map<String, String> hellos;

	@RequestMapping(value = "/hello/{lang}", method = RequestMethod.GET)
	public Greeting sayHello(@PathVariable String lang) {
		if (lang == null || !hellos.containsKey(lang)) {
			return null;
		}
		return new Greeting(hellos.get(lang));
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Set<String> langs() {
		return hellos.keySet();
	}
}