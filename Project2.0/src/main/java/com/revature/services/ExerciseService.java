package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Exercise;
import com.revature.models.User;
import com.revature.repositories.ExerciseRepository;

@Service
public class ExerciseService {
	
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	
	public Exercise[] saveExercise(Exercise[] exercise) {
		return exerciseRepository.saveExercise(exercise);
	}
	
	public List<Exercise> getExercises(User user) {
		return exerciseRepository.nativeQueryGetExercisesById(user);
	}
	
	public Exercise deleteExercise(Exercise exercise) {
		return exerciseRepository.deleteExercise(exercise);
	}
	
	

}
