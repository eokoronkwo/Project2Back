package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Food;
import com.revature.models.User;

@Repository
public class FoodRepository {
	SessionFactory sf;
	
	@Autowired
	public FoodRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Food[] saveFood(Food[] foods) {
			for (Food food : foods) {
				sf.getCurrentSession().save(food);
			}
			return foods;
	}
	
	public List<Food> nativeQueryGetFoodById(User user) {
			List<Food> foods = sf.getCurrentSession()
					.createNativeQuery("SELECT * FROM food WHERE userid = :userId", Food.class)
					.setParameter("userId", user.getId()).getResultList();
			return foods;
	}
	
	public Food deleteFood(Food food) {
			Transaction tx = sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(food);
			tx.commit();
		return food;
	}

}
