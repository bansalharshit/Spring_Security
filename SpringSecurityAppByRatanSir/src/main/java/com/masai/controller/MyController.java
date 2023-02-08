package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello1")
	public String sayHello() {
		return "Welcome to the Spring Security Method 1";
	}
	
	@GetMapping("/hello2")
	public String sayHello2() {
		return "Welcome to the Spring Security Method 2";
	}
}
