package com.aashish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashish.DAO.IEmployeeDAO;
import com.aashish.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
    //convert desgs into uppercase letter
	desg1=desg1.toUpperCase();
	desg2=desg2.toUpperCase();		
	desg3=desg3.toUpperCase();
	
	//use DAO
	List<Employee>list=empDAO.getEmployeeByDesgs(desg1, desg2, desg3);
	//calculate gross salary and net salary
	list.forEach(emp->{
		emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.40));
		emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
	
	});
	
	return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		//use DAO
		int count=empDAO.insertEmployee(emp);
		return count==0?"Employee is not registered":"Employee is registered";
		
	}

}
