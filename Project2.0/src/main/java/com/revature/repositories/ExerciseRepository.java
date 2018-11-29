package com.revature.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Exercise;
import com.revature.models.User;

@Repository
public class ExerciseRepository {

	SessionFactory sf;
	
	@Autowired
	public ExerciseRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Exercise[] saveExercise(Exercise[] exercises) {
			for (Exercise exercise : exercises) {
				sf.getCurrentSession().save(exercise);
			}
			return exercises;
	}
	
	public List<Exercise> nativeQueryGetExercisesById(User user) {
			List<Exercise> exercises = sf.getCurrentSession()
					.createNativeQuery("SELECT * FROM exercises WHERE userid = :userId", Exercise.class)
					.setParameter("userId", user.getId()).getResultList();
			System.out.println(user.getId());
			return exercises;
	}

	public Exercise deleteExercise(Exercise exercise) {
			Transaction tx = sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(exercise);
			tx.commit();
		return exercise;
	}
}
