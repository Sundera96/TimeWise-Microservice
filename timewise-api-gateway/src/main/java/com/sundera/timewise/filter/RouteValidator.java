package com.sundera.timewise.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	public static final List<String> openApiEndpoint = List.of("api/auth/register","api/auth/authenticate");
	
	public Predicate<ServerHttpRequest> isSecured = (request)->openApiEndpoint
			.stream()
			.noneMatch(uri->request.getURI().getPath().contains(uri));
}
