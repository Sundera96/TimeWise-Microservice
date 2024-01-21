package com.sundera.timewise.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.sundera.timewise.service.JwtValidationService;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	public AuthenticationFilter() {
		super(Config.class);
	}
	
	@Autowired
	private RouteValidator routeValidator;
	
	@Autowired
	private JwtValidationService jwtValidationService;
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain)->{
			if(routeValidator.isSecured.test(exchange.getRequest())) {
				final String authHeader=exchange.getRequest().getHeaders().get("Authorization").get(0);
				System.out.println(authHeader);
				//final String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				final String token;
				if(authHeader!=null&&authHeader.startsWith("Bearer")) {
					token = authHeader.substring(7);
					System.out.println(jwtValidationService.isTokenExpired(token));
//					jwtValidationService.isTokenExpired(token);
				}
			}
			return chain.filter(exchange);
		});
	}
	
	public static class Config{
		
	}
	
}
