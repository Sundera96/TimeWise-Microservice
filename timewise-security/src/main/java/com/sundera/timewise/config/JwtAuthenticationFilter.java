package com.sundera.timewise.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sundera.timewise.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String username;
		final String password;
		if(authHeader==null||!authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);
		logger.info("Jwt Token Received "+jwt);
		username = jwtService.extractUsername(jwt);
		password = jwtService.extractPassword(jwt);
		logger.info("Username is "+username);
		if(username!=null&&password!=null&&!jwtService.isTokenExpired(jwt)) {
			 UsernamePasswordAuthenticationToken userNamePasswordToken = new UsernamePasswordAuthenticationToken(username, password,null);
			 userNamePasswordToken.setDetails(new WebAuthenticationDetails(request));
			 SecurityContextHolder.getContext().setAuthentication(userNamePasswordToken);
		}
		filterChain.doFilter(request, response);
	}

}
