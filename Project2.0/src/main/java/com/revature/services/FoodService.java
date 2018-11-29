package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Food;
import com.revature.repositories.FoodRepository;

@Service
public class FoodService {
	
	private FoodRepository foodRepository;
	
	
	public FoodService(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}
	
	public Food[] saveFood(Food... foods) {
		return foodRepository.saveFood(foods);
	}
	
	public List<Food> getFoods(int userId) {
		return foodRepository.nativeQueryGetFoodById(userId);
	}
	
	public Food deleteFood(Food food) {
		return foodRepository.deleteFood(food);
	}
	
}
