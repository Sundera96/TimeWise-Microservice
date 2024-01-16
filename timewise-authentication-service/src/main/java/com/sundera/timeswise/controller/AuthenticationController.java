package com.sundera.timeswise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sundera.timeswise.entity.UserCredential;
import com.sundera.timeswise.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UserCredential user) {
		System.out.println("Whats Happening");
		return authService.saveUser(user);
	}
	
	@GetMapping("/token")
	public String getToken(UserCredential user) {
		return authService.generateToken(user.getName());
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token")String token) {
		authService.validateToken(token);
		return "Token is valid";
	}
	
	
}
