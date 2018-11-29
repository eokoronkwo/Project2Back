package com.revature.decode;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class DecodeToken {
	
	public static DecodedJWT decode(Object object) {
		try {
			DecodedJWT jwt = JWT.decode((String) object);
			return jwt;
		}catch (JWTDecodeException e) {
			// invalid input 
			return null;
		}
		
	}
}
