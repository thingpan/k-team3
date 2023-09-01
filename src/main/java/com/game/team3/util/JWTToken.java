package com.game.team3.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("classpath:jwt.properties")

public class JWTToken {
	@Value("${jwt.token.key")
	private 
}
