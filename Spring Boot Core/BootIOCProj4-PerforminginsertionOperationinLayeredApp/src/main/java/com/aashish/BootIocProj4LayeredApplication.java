package com.aashish;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aashish.Controller.PayrollOperationController;
import com.aashish.Model.Employee;

@SpringBootApplication
public class BootIocProj4LayeredApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=	SpringApplication.run(BootIocProj4LayeredApplication.class, args);
		PayrollOperationController controller=ctx.getBean("payroll",PayrollOperationController.class);
		
		Scanner sc=null;
		System.out.println("=====Registering the Employee======");
		 sc=new Scanner(System.in);
		System.out.println("Enter emp name:");
		String name=sc.next();
		System.out.println("Enter emp desg:");
		String desg=sc.next();
		System.out.println("Enter emp Salary:");
	    double salary=sc.nextDouble();
	    System.out.println("Enter emp deptno(10,20,30)");
	    int deptno=sc.nextInt();
	    //create Employee class obj having data
	    Employee emp1=new Employee();
	    emp1.setEname(name);
	    emp1.setDesg(desg);
	    emp1.setSalary(salary);
	    emp1.setDeptno(deptno);
	    
	    //invoke the b.method
	    try{
	    	String msgString=controller.processEmployeeForRegistratin(emp1);
	        System.out.println(msgString);
	    }
	    catch (Exception e) {
			// TODO: handle exception
		}
	    
	    System.out.println("====getting employee details====");
		//read inputs from enduser
				sc=new Scanner(System.in);
				System.out.println("Enter the desg1:");
				String desg1=sc.next();
				System.out.println("Enter the desg2:");
				String desg2=sc.next();
				System.out.println("Enter the desg3:");
				String desg3=sc.next();
				
	 try {
	    	List<Employee> list=controller.processEmployeeByDesgs(desg1, desg2, desg3);
	        list.forEach(emp->{
	        System.out.println(emp);
	        });
	    
	    }
	     catch (Exception e) {
			e.printStackTrace();
		}
	}

}
