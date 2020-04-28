package org.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.capg.dao.ITraineeDAO;
import org.capg.dao.ITraineeDAOImpl;
import org.capg.entities.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ITraineeServiceImpl implements ITraineeService{
	
	
	private ITraineeDAO dao;

	public ITraineeDAO getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(ITraineeDAO dao) {
		this.dao = dao;
	}
	
	
	public Trainee add(Trainee trainee) {
			trainee = dao.add(trainee);
			return trainee;
	}

	public Trainee findById(int id) {
		Trainee trainee = dao.findById(id);
		return trainee;
	}

	public List<Trainee> retreiveAll() {
		List<Trainee> list = dao.retreiveAll();
		return list;
	}
	

	public boolean delete(int id) {
		dao.delete(id);
		return true;
	}

	public Trainee modify(Trainee trainee) {

		trainee = dao.modify(trainee);
		return trainee;
	}

}
