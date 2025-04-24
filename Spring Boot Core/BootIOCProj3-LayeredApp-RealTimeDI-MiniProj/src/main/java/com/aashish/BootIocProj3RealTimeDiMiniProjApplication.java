package com.aashish;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aashish.controller.PayrollOperationsCollecter;
import com.aashish.model.Employee;
import com.aashish.service.IEmployeeMgmtService;

@SpringBootApplication
public class BootIocProj3RealTimeDiMiniProjApplication {

	public static void main(String[] args) {
		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Desg1:");
		String desg1=sc.next();
		System.out.println("Enter Desg2:");
		String desg2=sc.next();
		System.out.println("Enter Desg3:");
		String desg3=sc.next();
		//get IOC container
		ApplicationContext ctx= SpringApplication.run(BootIocProj3RealTimeDiMiniProjApplication.class, args);
	    
		//get controller class obj ref
		PayrollOperationsCollecter controller=ctx.getBean("payroll",PayrollOperationsCollecter.class);
		//invoke the b.method
		try {
			List<Employee> list=controller.processEmployeeByDesg(desg1, desg2, desg3);
		    System.out.println("Employees Deatils for the given Desg::");
			list.forEach(emp->{
		    System.out.println(emp);
		    });
		}
		catch (Exception e)
		{
		e.printStackTrace();
		
		}
	}
	

}
