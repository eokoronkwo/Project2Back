package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.decode.DecodeToken;
import com.revature.models.Food;
import com.revature.models.User;
import com.revature.services.FoodService;

@RestController
@RequestMapping("food")
public class FoodController {
	
	FoodService foodService;
	DecodeToken decodeToken;
 
	@Autowired
	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}

	@PostMapping("")
	public Food []saveFood(@RequestBody Food[] foods) {
		return foodService.saveFood(foods);
	}
	
	@PostMapping("calendar")
	public List<Food> getFoods(@RequestBody User user) {
		return foodService.getFoods(user);
	}
	
	@PutMapping("")
	public Food deleteFood(@RequestBody Food food) {
		return foodService.deleteFood(food);
	}
	
	@ExceptionHandler(NullPointerException.class) // If null pointer,
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Set HTTP Status code to bad request
	public void nullHandler() {
	
	}

}
