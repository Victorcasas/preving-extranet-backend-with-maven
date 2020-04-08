package preving.extranet.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import preving.extranet.security.JwtGenerator;
import preving.extranet.security.model.JwtUser;
import preving.extranet.security.model.Login;
import preving.extranet.services.IUserService;

@RestController
@RequestMapping("/auth")
public class UserRestController {
	private JwtGenerator jwtGenerator;
	
	@Autowired
	private IUserService userService;
	
	public UserRestController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@GetMapping(value= "/login")
	public ResponseEntity<?> generate(@RequestBody final Login login){
		JwtUser jwtUser = new JwtUser();
		jwtUser = userService.existUser(login);
		if(jwtUser != null) {
			List<String> lista = new ArrayList<>();
			lista.add(jwtGenerator.generate(jwtUser));
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	private JwtUser existUser(Login login) {
		if(login.getUser().equals("alberto") && login.getPassWord().equals("1234")) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setUserName(login.getUser());
			jwtUser.setId(1);
			jwtUser.setRole("Admin");
			return jwtUser;
			
		}else {
			return null;
		}
	}
	
	
	
}
