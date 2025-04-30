package com.aashish.DAO;

import java.util.List;

import com.aashish.Model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getsEmployeeDesg(String desg1,String desg2,String desg3)throws Exception;

}
