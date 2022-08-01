package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@RequestMapping(method = RequestMethod.GET,path = "/")
	public String home() {
		return "Welcome in Qeema Web App  ";
	}
}
