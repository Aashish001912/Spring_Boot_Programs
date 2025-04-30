package com.aashish.Service;

import java.util.List;

import com.aashish.Model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> showEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;


}
