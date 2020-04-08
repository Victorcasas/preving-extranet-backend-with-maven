package com.example.curso.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import preving.extranet.entities.User;
import preving.extranet.security.JwtGenerator;
import preving.extranet.security.model.JwtUser;
import preving.extranet.services.IUserService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.POST})
@RequestMapping("/auth")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping(value= "/auth")
	public ResponseEntity<?> loginUser(@RequestBody User user){
		User userDb = userService.checkUserLogin(user);
		if(userDb != null) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(userDb.getId());
			jwtUser.setUserName(userDb.getEmail());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	} 

}
