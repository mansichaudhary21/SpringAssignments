package org.capg.service;

import java.util.List;

import org.capg.entities.Trainee;
import org.capg.entities.User;

public interface ITraineeService {

    Trainee add(Trainee trainee);
	
	Trainee findById(int id);
	
	void delete(int id);
	
	Trainee modify(Trainee trainee);
	
	List<Trainee> retreiveAll();
	
	User findId(int id);
	
}
