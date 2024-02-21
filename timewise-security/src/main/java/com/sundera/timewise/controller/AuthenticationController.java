package com.sundera.timewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sundera.timewise.dto.AuthenticationRequest;
import com.sundera.timewise.dto.AuthenticationResponse;
import com.sundera.timewise.dto.RegistrationRequest;
import com.sundera.timewise.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request){
		System.out.println("is it reaching");
		System.out.println(request.getFirstName());
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
}
