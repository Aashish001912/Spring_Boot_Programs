package com.aashish.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aashish.model.Employee;
@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
    private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DETPNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	
	@Override
	public List<Employee> getsEmployeeDesg(String desg1, String desg2, String desg3) throws Exception {
	
		try(//get pooled jdbc con objet
				Connection con=ds.getConnection();
				//cerate jdbc statement objet
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESG));
				{
				//set value to query params
					ps.setString(1, desg1);
					ps.setString(2, desg2);
					ps.setString(3, desg3);
				//execute the sql query
					
				}
	return null;
	}
	

}
