package com.cg;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.JavaConfig;

public class ProjectMain {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
        context.registerShutdownHook();
        
        SBU sbu=context.getBean(SBU.class);
        sbu.show();
        
        List<Employee> employees = sbu.getEmpList();
        ProjectMain obj = new ProjectMain();
        System.out.println("Employee Details:");
        obj.showEmployees(employees);
        
  	}

   	public void showEmployees(List<Employee> employees) 
   	{
   		for(Employee e : employees) {
   			System.out.println("Employee ["+"EmpName :"+e.getEmployeeName()+", "+"EmpId:"+e.getEmployeeId()+", "+"EmpAge:"+e.getAge()+", "+"EmpSalary:"+e.getSalary()+"]");
   		}
   	
        
	}

}
