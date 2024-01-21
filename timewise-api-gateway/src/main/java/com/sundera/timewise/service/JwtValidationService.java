package com.sundera.timewise.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtValidationService {
	private static final String Secret="ShlE+B6prFIfXGmm2OVig8lT+sjrjSNXp+LVLL1hS7w=";
	
//	public void validateToken(String token) {
//		Jwts.parser()
//		.verifyWith(getSignInKey())
//		.build()
//		.parseSignedClaims(token);
//	}
	
	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(Secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public  boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token,(claims)->claims.getExpiration());
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
		.verifyWith(getSignInKey())
		.build()
		.parseSignedClaims(token).getPayload();
	}
}
