package com.bhavik.apps.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "contacts")
public class HomeController {

	@GetMapping("home")
	public String displayHomePage() {
		return "home";
	}

}
