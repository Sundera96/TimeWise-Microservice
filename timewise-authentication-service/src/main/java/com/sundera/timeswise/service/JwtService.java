package com.sundera.timeswise.service;

import java.util.Date;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;

import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	public final static String SECRET = "6d5af825400b9f8c5c8991f116fcb68f145ac7c8ef415217e006f30b12c7d5f4";
	
	public String generateToken(String userName) {
		return Jwts.builder().subject(userName)
		.issuedAt(new Date(System.currentTimeMillis()))
		.expiration(new Date(System.currentTimeMillis()+1000*60*30))
		.signWith(getSignKey(),Jwts.SIG.HS256).compact();
	}
	
	public void validateToken(final String token){
		Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token);
	}
	

	private SecretKey getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
