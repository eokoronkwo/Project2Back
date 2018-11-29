package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = "*")
	public boolean checkUsername(@RequestBody Credentials credentials) {
		System.out.println("Hello");
		List<Credentials> credentialsList = new ArrayList<>();
		credentialsList = credentialsService.check(credentials);
		for (int x = 0; x < credentialsList.size(); x++) {
			if (credentialsList.get(x).getUsername().equals(credentials.getUsername())) {
				System.out.println("false");
				return false;
			}

		}

		hash(credentials);
		saveCredentials(credentials);
		System.out.println("true");
		return true;

	}

	public void saveCredentials(Credentials credentials) {
		credentialsService.saveCredentials(credentials);
	}

	@PostMapping("save")
	@CrossOrigin(origins = "*")
	public void saveUser(@RequestBody User user) {
		System.out.println(user);
		credentialsService.save(user);
	}

	public void hash(Credentials credentials) {
		String hashed = BCrypt.hashpw(credentials.getPassword(), BCrypt.gensalt(15));
		System.out.println(hashed);
		credentials.setPassword(hashed);
	}

	@PostMapping("login")
	@CrossOrigin(origins = "*")
	public boolean login(@RequestBody Credentials credentials) {

		System.out.println(credentials.getUsername());
		System.out.println(credentials.getPassword());

		System.out.println(credentials.getPassword());
		List<Credentials> credentialsList = new ArrayList<>();
		credentialsList = credentialsService.check(credentials);
		for (int x = 0; x < credentialsList.size(); x++) {
			if ((credentialsList.get(x).getUsername().equals(credentials.getUsername())) && (BCrypt.checkpw(credentials.getPassword(), credentialsList.get(x).getPassword()))) {

				System.out.println("It matches");
				return true;
			} 

		}
		System.out.println("failed");
		return false;
	}

}
