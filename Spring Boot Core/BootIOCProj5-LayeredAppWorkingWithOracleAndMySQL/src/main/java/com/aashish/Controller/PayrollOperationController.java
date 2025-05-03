package com.aashish.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aashish.Model.Employee;
import com.aashish.Service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	public List<Employee>processEmployeeByDesgs(String desg1, String desg2, String desg3)throws Exception {
		
		List<Employee>list=empService.showEmployeeByDesgs(desg1, desg2, desg3);
		
		
		return list;
	}
	public String processEmployeeForRegistratin(Employee emp)throws Exception{
		//use service
		String msg=empService.registerEmployee(emp);
		return msg;
		
	}
	
}
