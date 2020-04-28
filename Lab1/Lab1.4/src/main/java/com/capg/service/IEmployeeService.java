package com.capg.service;

import java.util.List;

import com.capg.entities.Employee;

public interface IEmployeeService {

	List<Employee> fetchAll(int id);
}
