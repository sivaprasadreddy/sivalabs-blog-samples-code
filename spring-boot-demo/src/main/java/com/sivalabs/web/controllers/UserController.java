package com.sivalabs.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.config.AppProperties;

@RestController
public class UserController 
{
	@Value("${greeting}")
	String greeting;
	
	@Autowired 
	AppProperties appProps;
	
	@RequestMapping("/greet")
	String home() {
		return greeting + ", "+appProps.getGreeting();
	}
	
}