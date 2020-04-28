package com.capg.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capg.entities.Employee;

@Repository
public class IEmployeeDAOImpl implements IEmployeeDAO{

	private Map<Integer,Employee> store = new HashMap<Integer,Employee>();
	
	public IEmployeeDAOImpl()
	{
		store.put(101, new Employee(101,"Rama",40000));
		//store.put(102, new Employee(102,"John",45000));	
	}
	
	
	public List<Employee> fetchAll(int id) {
		// TODO Auto-generated method stub
		Collection<Employee> values = store.values();
		List<Employee> employees = new ArrayList<Employee>(values);
		return employees;
	}
	
	

}
