package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	@GetMapping(path = "/basicauth")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("You are authenticated");
	}
}
