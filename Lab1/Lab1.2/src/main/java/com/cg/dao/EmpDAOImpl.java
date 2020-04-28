package com.cg.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cg.entities.Employee;
import com.cg.entities.SBU;

@Component
public class EmpDAOImpl implements IEmpDAO{

	private Map<Integer,Employee> store1 = new HashMap<>();
	private Map<Integer,SBU> store2 = new HashMap<>();
	
	public EmpDAOImpl()
	{
		store1.put(1, new Employee(123456,"Hariett",40000,"PES-BU",30));
		store2.put(1, new SBU("PES-BU","Kiran Rao","Product Engineering Services"));
	}
	
	@Override
	public List<Employee> showDetails() {
		Collection<Employee> emp = store1.values();
		List<Employee> list = new ArrayList<>(emp);
		return list;
	}

	@Override
	public SBU getSBUDetails() {
		// TODO Auto-generated method stub
		return new SBU();
	}

}
