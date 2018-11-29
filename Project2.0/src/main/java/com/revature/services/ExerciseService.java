package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Exercise;
import com.revature.repositories.ExerciseRepository;

@Service
public class ExerciseService {
	
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	
	public List<Exercise> saveExcercise(List<Exercise> exercises) {
		return exerciseRepository.saveExercise(exercises);
	}
	
	public List<Exercise> getExercises(int userId) {
		return exerciseRepository.nativeQueryGetExercisesById(userId);
	}
	
	public Exercise deleteExercise(Exercise exercise) {
		return exerciseRepository.deleteExercise(exercise);
	}
	
	

}
