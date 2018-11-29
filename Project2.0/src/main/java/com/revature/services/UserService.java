package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.nativeQueryGetUserByUsername(username);
	}

}
