package com.aashish;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aashish.Controller.PayrollOperationController;
import com.aashish.Model.Employee;

@SpringBootApplication
public class BootIocProj3MiniLayeredApplication {

	public static void main(String[] args) {
		//read inputs from enduser
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the desg1:");
				String desg1=sc.next();
				System.out.println("Enter the desg2:");
				String desg2=sc.next();
				System.out.println("Enter the desg3:");
				String desg3=sc.next();
				
	ApplicationContext ctx=	SpringApplication.run(BootIocProj3MiniLayeredApplication.class, args);
	PayrollOperationController controller=ctx.getBean("payroll",PayrollOperationController.class);
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
