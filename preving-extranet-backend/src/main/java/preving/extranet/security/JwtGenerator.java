package preving.extranet.security;

import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import preving.extranet.constants.Const;
import preving.extranet.security.model.JwtUser;

@Component
public class JwtGenerator {
	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		claims.put(Const.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Const.ROLE, jwtUser.getRole());
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Const.YOUT_SECRET)
				.compact();
		
	}
}
