package com.aashish.DAO;

import java.util.List;

import com.aashish.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;

}
