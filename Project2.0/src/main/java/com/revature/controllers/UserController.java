package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	UserService userService;
	
	

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}




	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
}
