package org.cloudfoundry.hello;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Resource(name = "hellos")
	private Map<String, String> hellos;

	@RequestMapping(value = "/{lang}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String lang) {
		if (lang == null || !hellos.containsKey(lang)) {
			return "";
		}
		return hellos.get(lang);
	}
}