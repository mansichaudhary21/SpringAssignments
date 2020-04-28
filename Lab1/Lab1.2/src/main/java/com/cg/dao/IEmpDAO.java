package com.cg.dao;

import java.util.List;

import com.cg.entities.Employee;
import com.cg.entities.SBU;

public interface IEmpDAO {

	List<Employee> showDetails();
	
	SBU getSBUDetails();
}
