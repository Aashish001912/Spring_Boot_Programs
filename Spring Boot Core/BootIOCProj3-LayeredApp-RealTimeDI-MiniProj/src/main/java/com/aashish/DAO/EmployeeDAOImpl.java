package com.aashish.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aashish.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHRE JOB IN(?,?,?)ORDER BY JOB";
   
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee>list=null; 
		try(//get Pooled jdbc con object
			Connection con=ds.getConnection();
			//create JDBC statment object
			PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS)
				)
		{
			//set values to query params
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			//execute the SQL Query
			try(ResultSet rs=ps.executeQuery())
			{
				//copy the records of resultSet to list of employee objs
				list=new ArrayList();
				while(rs.next()) {
					//copy each record Employee class obj
					Employee emp=new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					//add employee class obj list collection
					list.add(emp);
				}//end while
			} //try 2 end
			
		}//try 1 end
		catch(SQLException se)
		{
			se.printStackTrace();
			throw se;
		}
		return list;
	}//end method

}//end class
