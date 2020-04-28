package org.capg.dao;

import java.util.List;


import org.capg.entities.Trainee;
import org.capg.entities.User;

public interface ITraineeDAO {
	
	Trainee add(Trainee trainee);
	
	Trainee findById(int id);
	
	void delete(int id);
	
	Trainee modify(Trainee trainee);
	
	List<Trainee> retreiveAll();
	
	User findId(int id);

}
