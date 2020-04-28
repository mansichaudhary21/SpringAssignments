package org.capg.service;

import java.util.List;

import org.capg.entities.Trainee;

public interface ITraineeService {

	Trainee add(Trainee trainee);
	
	Trainee findById(int id);
	
	boolean delete(int id);
	
	Trainee modify(Trainee trainee);
	
	List<Trainee> retreiveAll();

}
