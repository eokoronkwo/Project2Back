package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.CredentialsRepository;

@Service
public class CredentialsService {

	CredentialsRepository credentialsRepository;
	
	
	@Autowired
	public CredentialsService(CredentialsRepository credentialsRepository) {
		super();
		this.credentialsRepository = credentialsRepository;
	}



	public List<Credentials> check(Credentials credentials) {
		System.out.println("Service");
		return credentialsRepository.check(credentials);
	}



	public void saveCredentials(Credentials credentials) {
		credentialsRepository.save(credentials);
		
	}



	public void save(User user) {
		credentialsRepository.save(user);
		
	}

}
