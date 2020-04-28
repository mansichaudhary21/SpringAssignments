package org.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.capg.dao.ITraineeDAO;
import org.capg.dao.ITraineeDAOImpl;
import org.capg.entities.Trainee;
import org.capg.entities.User;
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
	
	public ITraineeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ITraineeServiceImpl(ITraineeDAO dao) {
		this.dao = dao;
	}
	
	
	public Trainee add(Trainee trainee) {
			return dao.add(trainee);
	}

	public Trainee findById(int id) {
		
		Trainee trainee = dao.findById(id);
		return trainee;
	}

	public List<Trainee> retreiveAll() {
		List<Trainee> list = dao.retreiveAll();
		return list;
	}
	
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);

	}

	public Trainee modify(Trainee trainee) {
		// TODO Auto-generated method stub
		Trainee t = dao.modify(trainee);
		return t;
	}
	@Override
	public User findId(int id) {
		User user1 = dao.findId(id);
		return user1;
	}
	

}
