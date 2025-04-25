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
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)ORDER BY JOB";
	private static final String INSERT_EMPS_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO)VALUES(EMP_SEQ.NEXTVAL,????)";
   
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee>list=null; 
		try(//get Pooled jdbc con object
			Connection con=ds.getConnection();
			//create JDBC statement object
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

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int result=0;
		try(//get pooled con obj
				Connection con=ds.getConnection();
				//create prepared statment
				PreparedStatement ps=con.prepareStatement(INSERT_EMPS_QUERY);
				
				){
			//set values to query param
			ps.setString(1,emp.getEname());
			ps.setString(2,emp.getDesg());
			ps.setDouble(3,emp.getSalary());
			ps.setInt(4,emp.getDeptno());
			//execute the sql query
			 result=ps.executeUpdate();
			return result;
		}
		catch (SQLException se) {
			 se.printStackTrace();
		     throw se;	
		}
		catch (Exception e) {
		 e.printStackTrace();
		 throw e;
		}

	}//end method of insert

}//end class
