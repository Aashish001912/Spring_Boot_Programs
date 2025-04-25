package com.aashish;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aashish.controller.PayrollOperationsCollecter;
import com.aashish.model.Employee;

@SpringBootApplication
public class BootIocProj3RealTimeDiMiniProjApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj3RealTimeDiMiniProjApplication.class,args);
		//get controller class obj ref
		PayrollOperationsCollecter controller=ctx.getBean("payroll",PayrollOperationsCollecter.class);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("============Registring the employee==========");
		System.out.println("Enter the emp name:");
		String name=sc.next();
		System.out.println("Enter the emp desg:");
		String desg=sc.next();
		System.out.println("Enter the emp salary:");
		double salary=sc.nextDouble();
		System.out.println("Enter the emp deptno:");
		int deptno=sc.nextInt(); 
		//create Employee class obj having data
		Employee emp=new Employee();
		emp.setEname(name);emp.setDesg(desg);emp.setSalary(salary);
		emp.setDeptno(deptno);
		
		//invoke the b.method
		try {
			String msg=controller.processEmployeeForRegistration(emp);
	        System.out.println(msg);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============Getting Employee Details By Desgs==========");
		//read inputs from enduser
		System.out.println("Enter Desg1:");
		String desg1=sc.next();
		System.out.println("Enter Desg2:");
		String desg2=sc.next();
		System.out.println("Enter Desg3:");
		String desg3=sc.next();
		
		
		//invoke the b.method
		try {
			List<Employee> list=controller.processEmployeeByDesg(desg1, desg2, desg3);
		    System.out.println("Employees Deatils for the given Desg::");
			list.forEach(emp1->{
		    System.out.println(emp1);
		    });
		}
		catch (Exception e)
		{
		e.printStackTrace();
		
		}
	}
	

}
