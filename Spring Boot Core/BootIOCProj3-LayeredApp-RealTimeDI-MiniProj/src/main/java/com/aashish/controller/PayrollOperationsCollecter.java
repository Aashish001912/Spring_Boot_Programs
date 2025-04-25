package com.aashish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aashish.model.Employee;
import com.aashish.service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationsCollecter {
	@Autowired
	private IEmployeeMgmtService empService;
	
	public List<Employee> processEmployeeByDesg(String desg1,String desg2,String desg3) throws Exception {
		
		//use service
		List<Employee>list=empService.showEmployeeByDesgs(desg1,desg2,desg3);
		return list;
	}
	public String processEmployeeForRegistration(Employee emp)throws Exception{
		//use service
		String msg=empService.registerEmployee(emp);
		
		return msg;
		
	}
	
}
