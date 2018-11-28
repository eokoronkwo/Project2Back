package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Exercise;
import com.revature.repositories.ExerciseRepository;

@Service
public class ExerciseService {
	
	private ExerciseRepository exerciseRepository;

	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	
	public Exercise[] saveExcercise(Exercise... exercises) {
		return exerciseRepository.saveExercise(exercises);
	}
	
	public List<Exercise> getExercises(int userId) {
		return exerciseRepository.nativeQueryGetExercisesById(userId);
	}
	
	public Exercise deleteExercise(Exercise exercise) {
		return exerciseRepository.deleteExercise(exercise);
	}
	
	

}
