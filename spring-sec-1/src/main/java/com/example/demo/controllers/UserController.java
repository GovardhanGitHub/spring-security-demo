package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;

@RestController
@RequestMapping("/auth")
public class UserController {

	private UserRepo userRepo;
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	public UserController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	private final int DEFAULT_OTP = 123;
	
	@PostMapping("/signUp")
	private User SignUp(@RequestBody User user){
		
		if(user.getPassword() ==  null &&  user.getUserName() ==  null)
			return null;
		
		if(user.getOtp() != null && user.getOtp() == DEFAULT_OTP ) {
			user.setActive(true);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(user);
		}
		else {
			user.setActive(false);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(user);
		}
		
	}

}
