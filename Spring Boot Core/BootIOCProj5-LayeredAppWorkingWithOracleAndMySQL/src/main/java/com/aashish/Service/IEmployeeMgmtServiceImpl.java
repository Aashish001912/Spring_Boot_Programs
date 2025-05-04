package com.aashish.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aashish.DAO.IEmployeeDAO;
import com.aashish.Model.Employee;
@Service("empService")
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	@Qualifier("empMysqlDAO")
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		//convert desgs into UPPERCASE letters
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		
		//Use the DAO
		List<Employee>list=empDAO.getsEmployeeDesg(desg1, desg2, desg3);
		//calculate gross salary net salary
		list.forEach(emp->{
          emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
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
