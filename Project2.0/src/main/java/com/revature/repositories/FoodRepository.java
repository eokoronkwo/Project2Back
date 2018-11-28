package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Food;

@Repository
public class FoodRepository {
	SessionFactory sf;
	
	@Autowired
	public FoodRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public Food[] saveFood(Food... foods) {
		for (Food food : foods) {
			sf.getCurrentSession().save(food);
		}
		return foods;
	}
	
	@Transactional
	public List<Food> nativeQueryGetFoodById(int userId) {
		try (Session session = sf.openSession()) {
			List<Food> foods = session
					.createNativeQuery("SELECT * FROM food WHERE user_id = :userId", Food.class)
					.setParameter("userId", userId).getResultList();
			return foods;
		}
	}
	
	@Transactional
	public Food deleteFood(Food food) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			session.delete(food);
			tx.commit();
		}
		return food;
	}

}
