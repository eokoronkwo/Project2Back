package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Food;
import com.revature.models.User;
import com.revature.repositories.FoodRepository;

@Service
public class FoodService {
	
	private FoodRepository foodRepository;
	
	@Autowired
	public FoodService(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}
	
	public Food[] saveFood(Food[] foods) {
		return foodRepository.saveFood(foods);
	}
	
	public List<Food> getFoods(User user) {
		return foodRepository.nativeQueryGetFoodById(user);
	}
	
	public Food deleteFood(Food food) {
		return foodRepository.deleteFood(food);
	}
	
}
