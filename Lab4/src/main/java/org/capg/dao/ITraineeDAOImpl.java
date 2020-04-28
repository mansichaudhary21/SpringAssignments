package org.capg.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.capg.entities.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.exceptions.TraineeNotFoundException;

@Repository
public class ITraineeDAOImpl implements ITraineeDAO{

	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Trainee add(Trainee trainee) {
		
		getEntityManager().persist(trainee);
		return trainee;
	}

	public Trainee findById(int id) {
		Trainee t = entityManager.find(Trainee.class, id);
		if(t == null) {
			 throw new TraineeNotFoundException("Trainee not found for id ="+id);
		 }
		
		return t;
	}

	public List<Trainee> retreiveAll() {
		String jql = "from Trainee";
		TypedQuery<Trainee> query = entityManager.createQuery(jql,Trainee.class);
		List<Trainee> list = query.getResultList();
		return list;
	}

	public boolean delete(int id) {
		
		Trainee trainee = entityManager.find(Trainee.class, id);
		if(trainee == null) {
			 throw new TraineeNotFoundException("Trainee not found for id ="+id);
		 }
		getEntityManager().remove(trainee);
		return true;
		
	}

	public Trainee modify(Trainee trainee) {
	 trainee = entityManager.merge(trainee);
	 if(trainee == null) {
		 throw new TraineeNotFoundException("Trainee not found for id ="+trainee.getTraineeId());
	 }
	
	 return trainee;
	}

}
