package com.capg.dao;

import java.util.List;

import com.capg.entities.Employee;

public interface IEmployeeDAO {

	List<Employee> fetchAll(int id);
}
