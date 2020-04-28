package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IEmployeeDAO;
import com.capg.entities.Employee;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDAO dao;
	
	
	public IEmployeeDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}


	public List<Employee> fetchAll(int id) {
		List<Employee> list = dao.fetchAll(id);
		return list;
	}

}
