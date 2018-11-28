package com.revature.decode;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class DecodeToken {
	public static DecodedJWT decode(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt;
		}catch (JWTDecodeException e) {
			// invalid input 
			return null;
		}
		
	}
}
