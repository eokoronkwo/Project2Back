package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.CredentialsService;

@RestController
@RequestMapping("credentials")
public class CredentialsController {

	CredentialsService credentialsService;

	@Autowired
	public CredentialsController(CredentialsService credentialsService) {
		super();
		this.credentialsService = credentialsService;
	}

	@PostMapping("check")
	public boolean checkUsername(@RequestBody Credentials credentials) {
		System.out.println("Hello");
		List<Credentials> credentialsList = new ArrayList<>();
		credentialsList = credentialsService.check(credentials);
		if (credentialsList.size() == 0) {
			hash(credentials);
			saveCredentials(credentials);
			return true;
		}

		return false;
	}

	public void saveCredentials(Credentials credentials) {
		credentialsService.saveCredentials(credentials);
	}

	@PostMapping("save")
	public void saveUser(@RequestBody User user) {
		credentialsService.save(user);
	}

	public void hash(Credentials credentials) {
		String hashed = BCrypt.hashpw(credentials.getPassword(), BCrypt.gensalt(15));
		System.out.println(hashed);
		credentials.setPassword(hashed);
	}

	@PostMapping("login")
	public boolean login(Credentials credentials) {
		hash(credentials);
		List<Credentials> credentialsList = new ArrayList<>();
		credentialsList = credentialsService.check(credentials);
		if (credentialsList.size() == 0) {
			return true;
		}

		return false;
	}

}
