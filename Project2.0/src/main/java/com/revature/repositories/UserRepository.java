package com.revature.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepository {

	SessionFactory sf;

	@Autowired
	public UserRepository(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public User save(User user) {
		sf.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	public User nativeQueryGetUserByUsername(String username) {
		User user = sf.getCurrentSession()
				.createNativeQuery("SELECT * FROM users WHERE username = :userName", User.class)
				.setParameter("userName", username).getSingleResult();
		return user;
	}

}
