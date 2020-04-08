package preving.extranet.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import preving.extranet.constants.Const;
import preving.extranet.security.model.JwtUser;

@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Const.YOUT_SECRET)
					.parseClaimsJws(token)
					.getBody();
			jwtUser = new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get(Const.USER_ID)));
			jwtUser.setRole((String)body.get(Const.ROLE));
			
		}catch(Exception ex) {
			System.out.println("Error "+ ex.getMessage());
		}
		
		return  jwtUser;
	}
}
