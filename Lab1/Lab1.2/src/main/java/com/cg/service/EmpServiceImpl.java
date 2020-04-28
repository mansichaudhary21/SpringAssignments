package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IEmpDAO;
import com.cg.entities.Employee;
import com.cg.entities.SBU;

@Service
public class EmpServiceImpl implements IEmpService{

	private IEmpDAO dao;
	
	public IEmpDAO getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(IEmpDAO dao) {
		this.dao = dao;
	}

	public EmpServiceImpl(IEmpDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Employee> showDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = dao.showDetails();
		return list;
	}

	@Override
	public SBU getSBUDetails() {
		// TODO Auto-generated method stub
		return new SBU();
	}

}
