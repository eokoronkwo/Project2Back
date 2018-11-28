package com.revature.repositories;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Exercise;

@Repository
public class ExerciseRepository {

	SessionFactory sf;
	
	@Autowired
	public ExerciseRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Exercise[] saveExercise(Exercise... exercises) {
		for (Exercise exercise : exercises) {
			sf.getCurrentSession().save(exercise);
		}
		return exercises;
	}
	
	public List<Exercise> nativeQueryGetExercisesById(int userId) {
		try (Session session = sf.openSession()) {
			List<Exercise> exercises = session
					.createNativeQuery("SELECT * FROM exercises WHERE user_id = :userId", Exercise.class)
					.setParameter("userId", userId).getResultList();
			return exercises;
		}
	}
	
	public Exercise deleteExercise(Exercise exercise) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			session.delete(exercise);
			tx.commit();
		}
		return exercise;
	}
}
