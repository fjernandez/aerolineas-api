package ar.com.cdt.utn.aerolineasapi.utils;

import java.util.Date;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import ar.com.cdt.utn.aerolineasapi.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

public class TokenUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
	
	@Value("${aerolineas.tokenSecret}")
	private String tokenSecret;
	
	@Value("${aerolineas.tokenExpiration}")
	private int tokenExpiration;
	
	public String generateToken(Authentication auth) {
		UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
		String token = Jwts.builder().setSubject((user.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + tokenExpiration))
				.signWith(SignatureAlgorithm.HS512, tokenSecret).compact();
		return token;
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}


}
