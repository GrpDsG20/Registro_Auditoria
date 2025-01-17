package com.springboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerIndex {
	
		
	@GetMapping({"/","/login"})
	public String login() {
		return "autenticar";
	}

}
