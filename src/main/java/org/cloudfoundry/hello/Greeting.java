package org.cloudfoundry.hello;

public class Greeting {

	private String greeting;

	public Greeting() {
		super();
	}

	public Greeting(String greeting) {
		this();
		setGreeting(greeting);
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
