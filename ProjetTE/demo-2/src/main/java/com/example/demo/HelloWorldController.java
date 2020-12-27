package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping
	public HelloWorld hello() {
		return new HelloWorld("hello");
	}
	
	@PostMapping
	public String helloPost() {
		return "hello post";
	}
	
	@PutMapping
	public String helloPut() {
		return "hello put";
	}
}

class HelloWorld{
	
	public String message;
	
	public HelloWorld(String message) {
		this.message = message;
		
	}
}
