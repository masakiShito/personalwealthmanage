package com.spring.project.personalwealthmanage.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

	/**
	 *
	 * */
	@GetMapping
	public String showIndex() {
		return "pwm_002";
	}

	@GetMapping("/pwm_001")
	public String showLogin() {
		return "pwm_001";
	}

}
