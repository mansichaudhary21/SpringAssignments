package com.capg.spring.ui;

import java.util.List;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capg.spring.config.JavaConfig;
import com.capg.spring.entities.Employee;
//import com.capg.spring.service.EmpServiceImpl;
//import com.capg.spring.service.IEmpService;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
        context.registerShutdownHook();
        Employee emp = context.getBean(Employee.class);
        System.out.println("Employee Details");
        System.out.println("------------------------------");
        System.out.println("Employee ID: " + emp.getEmployeeId());
    	System.out.println("Employee Name: " + emp.getEmployeeName());
    	System.out.println("Employee Salary: " + emp.getSalary());
    	System.out.println("Employee BussinessUnit: " + emp.getBusinessUnit());
    	System.out.println("Employee Age: " + emp.getAge());
        }
	
	
}
