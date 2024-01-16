package com.sundera.timeswise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sundera.timeswise.entity.UserCredential;
import com.sundera.timeswise.repository.UserCredentialRepository;

@Component
public class AuthenticationService {
	
	
	@Autowired
	private UserCredentialRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String saveUser(UserCredential userCred) {
		userCred.setPassword(passwordEncoder.encode(userCred.getPassword()));
		repository.save(userCred);
		return "User Added to the System";
	}
	
	public String generateToken(String userName) {
		return jwtService.generateToken(userName);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
	
	
}
