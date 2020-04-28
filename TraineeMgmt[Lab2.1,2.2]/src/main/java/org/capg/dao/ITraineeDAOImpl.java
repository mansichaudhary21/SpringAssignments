package org.capg.dao;

import java.util.ArrayList;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.capg.entities.Trainee;
import org.capg.entities.User;
import org.capg.util.JPAUtil;
import org.springframework.stereotype.Repository;

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
		 trainee = entityManager.merge(trainee);
		 return trainee;
	}

	public Trainee findById(int id) {
		Trainee trainee = entityManager.find(Trainee.class, id);
        System.out.println("Training id :: " + trainee.getTraineeId());
        System.out.println("Training Name :: " + trainee.getTraineeName());
        System.out.println("Trainee Domain :: " + trainee.getTraineeDomain());
        System.out.println("Trainee Location :: "+ trainee.getTraineeLocation());
        return trainee;
	}

	public List<Trainee> retreiveAll() {
		String query = "from Trainee";
		TypedQuery<Trainee> query2 = entityManager.createQuery(query,Trainee.class);
		List<Trainee> list = query2.getResultList();
		return list;
	}
	

	public void delete(int id) {
		System.out.println("Inside Dao:- "+ id);
		Trainee t3 = entityManager.find(Trainee.class, id);
        entityManager.remove(t3);
     }

	public Trainee modify(Trainee trainee) {
	    Trainee t2 = entityManager.merge(trainee);
        System.out.println("Training id :: " + t2.getTraineeId());
        System.out.println("Training Name :: " + t2.getTraineeName());
        System.out.println("Trainee Domain :: " + t2.getTraineeDomain());
        System.out.println("Trainee Location ::"+ t2.getTraineeLocation());
        // The entity object is physically updated in the database when the transaction
        // is committed
        return t2;
	}

	@Override
	public User findId(int id) {
		User user1=entityManager.find(User.class, id);
		return user1;
	}

	
}
