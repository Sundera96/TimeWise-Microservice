package com.sundera.timewise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private final Logger logger = LoggerFactory.getLogger(JwtService.class);
	private static final String Secret="ShlE+B6prFIfXGmm2OVig8lT+sjrjSNXp+LVLL1hS7w="; 
	//SecretKey key = Jwts.SIG.HS256.key().build();
	
	public String extractUsername(String token) {
		logger.info("Inside extract username function ");
		return extractClaim(token,(claim)->claim.getSubject());
	}
	
	public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public String generateToken(Map<String,Object> extractClaims, UserDetails userDetails) {
		String token = Jwts.builder()
				.claims().add(extractClaims)
				.add("password",userDetails.getPassword())
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*24))
				.and()
				.signWith(getSignInKey())
				.compact();
		
		logger.info("Token Generated"+token);
		return token;
	}
	
//	public boolean isTokenValid(String token, UserDetails userDetails) {
//		final String username = extractUsername(token);
//		return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
//	}
	
	public  boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token,(claims)->claims.getExpiration());
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(),userDetails);
	}
	
//	public void verifyToken(String token) {
//		Jwts.parser()
//		.verifyWith(getSignInKey())
//		.build()
//		.parseSignedClaims(token);
//	}
	
	
	private Claims extractAllClaims(String token) {
		logger.info("Inside extract all claims with token "+token);
		return Jwts.parser()
		.verifyWith(getSignInKey())
		.build()
		.parseSignedClaims(token).getPayload();
	}

	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(Secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractPassword(String token) {
		logger.info("Inside extract password function ");
		return extractClaim(token,(claim)->claim.getSubject());
	}
}
