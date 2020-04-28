package org.capg.dao;

import java.util.List;

import org.capg.entities.Trainee;

public interface ITraineeDAO {
	
	Trainee add(Trainee trainee);
	
	Trainee findById(int id);
	
	boolean delete(int id);
	
	Trainee modify(Trainee trainee);
	
	List<Trainee> retreiveAll();

}
