package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Credentials;
import com.revature.models.User;

@Repository
public class CredentialsRepository {
	
	static SessionFactory sf;
	
	@Autowired
	public CredentialsRepository(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public List<Credentials> check(Credentials credentials) {
		System.out.println(credentials.getUsername());
		
		List<Credentials> list = sf.getCurrentSession().createQuery("from Credentials where username = :code").setParameter("code", credentials.getUsername(), StringType.INSTANCE).list();
		return list;
	}

	public void save(Credentials credentials) {
		sf.getCurrentSession().save(credentials);
		
	}

	public void save(User user) {
		sf.getCurrentSession().save(user);
		
	}

	

}
