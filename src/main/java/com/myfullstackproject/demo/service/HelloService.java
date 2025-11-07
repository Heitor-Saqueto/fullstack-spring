package com.myfullstackproject.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getHelloMessage() {
		return "Hello Full Stack Developer! This message came from the Service Layer via Dependency Injection.";
	}
}
