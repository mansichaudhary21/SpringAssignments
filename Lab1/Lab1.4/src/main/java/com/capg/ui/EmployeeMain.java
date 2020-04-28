package com.capg.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capg.config.JavaConfig;
import com.capg.entities.Employee;
import com.capg.service.IEmployeeService;
import com.capg.service.IEmployeeServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
        context.registerShutdownHook();
       
        IEmployeeService service= context.getBean(IEmployeeService.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        System.out.println("Employee Id:  ");
        int id = sc.nextInt();
        List<Employee> empList = service.fetchAll(id);
        
        System.out.println("Output:");

        System.out.println("Employee Info:");
        for (Employee employee : empList) {
        	System.out.println("Employee ID:  " +  employee.getEmployeeId());
            System.out.println("Employee Name:  " + employee.getEmployeeName());
            System.out.println("Employee Salary: " + employee.getSalary());
		}
        
        
	}
}
