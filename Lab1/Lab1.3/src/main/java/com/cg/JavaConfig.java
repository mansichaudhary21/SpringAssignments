package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cg")
@PropertySource("classpath:empdetails")
public class JavaConfig {
	
	@Bean
	public SBU sbu() {
		Employee employee1 = new Employee(12345,"Harriett",30,40000);
		Employee employee2 = new Employee(12346,"John",30,45000);
		List<Employee>list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		SBU sbu1 = new SBU();
		sbu1.setEmpList(list);
		return sbu1;
	}

}
