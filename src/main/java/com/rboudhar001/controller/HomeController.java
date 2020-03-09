package com.rboudhar001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${spring.application.name}")
	private String appName = "Sozial";

	@GetMapping("/home")
	public String home(Model model) {

		model.addAttribute("appName", appName);
		return "home/view";
	}
}
