package com.ecommerce.account.configuration.config;

import com.ecommerce.account.entity.User;
import io.jsonwebtoken.*;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The JwtTokenProvider class is responsible for the generation, validation, and extraction of information from JWT (JSON Web Tokens).
 * <p>
 * This class provides methods to:
 * <ul>
 *     <li>Generate a JWT for a given user with a specified expiry time.</li>
 *     <li>Validate the authenticity and integrity of a provided JWT.</li>
 * </ul>
 * The JWT secret key, used for signing and verifying tokens, is injected from application properties.
 * </p>
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Component
public class JwtTokenProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value(value = "${app.jwtSecret}")
	private String jwtSecret;


	public String getEmailFromJWT(String token) {
		this.validateToken(token);
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();

		return claims.getSubject();
	}

	public void validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		} catch (SignatureException ex) {
			LOGGER.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			LOGGER.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			LOGGER.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			LOGGER.error("JWT claims string is empty");
		}
	}

	public String generateToken(User user, int expiry) {

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + expiry);

		return Jwts.builder()
				.setSubject(user.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}



}
