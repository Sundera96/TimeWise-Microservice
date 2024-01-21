package com.sundera.timewise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sundera.timewise.dto.AuthenticationRequest;
import com.sundera.timewise.dto.AuthenticationResponse;
import com.sundera.timewise.dto.RegistrationRequest;
import com.sundera.timewise.entity.User;
import com.sundera.timewise.repos.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;

	public AuthenticationResponse register(RegistrationRequest request) {
		User user = new User(request.getFirstName(),request.getLastName(),request.getUsername(),null,passwordEncoder.encode(request.getPassword()));
		repo.save(user);
		return new AuthenticationResponse("User Added Successfully");
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		Authentication authentication =authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),null));
		if(authentication.isAuthenticated()) {
			String token = jwtService.generateToken(new User(null,null,request.getUsername(),null,request.getPassword()));
			return new AuthenticationResponse(token);
		}
		return new AuthenticationResponse(null);
	}
}
