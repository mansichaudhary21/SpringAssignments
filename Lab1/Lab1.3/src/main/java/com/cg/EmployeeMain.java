package com.cg;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
        context.registerShutdownHook();
        
        Employee emp = context.getBean(Employee.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        System.out.print("Employee Id:  ");
        int userInput = sc.nextInt();
        
        System.out.println("Output:");
        System.out.println("Employee Info:");
        System.out.println("Employee ID:  " +  emp.getEmployeeId());
        System.out.println("Employee Name:  " + emp.getEmployeeName());
        System.out.println("Employee Salary: " + emp.getSalary());
        
	}
}
