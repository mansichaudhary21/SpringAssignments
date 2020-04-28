package com.cg.service;

import java.util.List;

import com.cg.entities.Employee;
import com.cg.entities.SBU;

public interface IEmpService {
	
	List<Employee> showDetails();

	SBU getSBUDetails();
}
