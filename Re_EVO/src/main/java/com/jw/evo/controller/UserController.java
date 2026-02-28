package com.jw.evo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jw.evo.dto.UserSignupDTO;
import com.jw.evo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	

	@GetMapping("/login")
	public String login() {
		return "loginPage";

	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signupPage";
	}

	@PostMapping("/signupProc")
	public String signupProc(UserSignupDTO userSignupDTO) {
		userService.signupProc(userSignupDTO);
		return "redirect:/login";
	}

	
}
