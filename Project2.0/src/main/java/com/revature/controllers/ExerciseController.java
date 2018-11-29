package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Exercise;
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
		return exerciseService.saveExcercise(exercises);
	}
	
	@GetMapping("")
	public List<Exercise> getExercises(@RequestBody int userId) {
		return exerciseService.getExercises(userId);
	}
	
	@DeleteMapping("")
	public Exercise deleteExercise(@RequestBody Exercise exercise) {
		return exerciseService.deleteExercise(exercise);
	}
	
	@ExceptionHandler(NullPointerException.class) // If null pointer,
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Set HTTP Status code to bad request
	public void nullHandler() {
	}
	
}
