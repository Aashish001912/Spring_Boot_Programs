package com.aashish.service;

import java.util.List;

import com.aashish.model.Employee;

public interface IEmployeeMgmtService {
	public  List<Employee> showEmployeeByDesgs(String desg1,String desg2, String desg3)throws Exception;
    public String registerEmployee(Employee emp)throws Exception;
}
