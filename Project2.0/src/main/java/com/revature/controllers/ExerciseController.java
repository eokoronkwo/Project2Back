package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Exercise;
import com.revature.models.User;
import com.revature.services.ExerciseService;

@RestController
@RequestMapping("exercise")
public class ExerciseController {
	
	ExerciseService exerciseService;
	
	@Autowired
	public ExerciseController(ExerciseService exerciseService) {
		super();
		this.exerciseService = exerciseService;
	}

	@PostMapping("")
	public Exercise[] saveExercise(@RequestBody Exercise[] exercises) {
		return exerciseService.saveExercise(exercises);
	}
	
	@PostMapping("calendar")
	public List<Exercise> getExercises(@RequestBody User user) {
		return exerciseService.getExercises(user);
	}
	
	@PutMapping("")
	public Exercise deleteExercise(@RequestBody Exercise exercise) {
		return exerciseService.deleteExercise(exercise);
	}
	
	
}
