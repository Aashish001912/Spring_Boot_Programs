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

import com.aashish.Model.Employee;
@Repository("empDAO")
public class IEmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPtNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	
	@Override
	public List<Employee> getsEmployeeDesg(String desg1, String desg2, String desg3) throws Exception {
	List<Employee>list=null;
		try(//get pooled jdbc con objet
				Connection con=ds.getConnection();
				//cerate jdbc statement objet
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESG);)
				{
				//set value to query params
					ps.setString(1, desg1);
					ps.setString(2, desg2);
					ps.setString(3, desg3);
				//execute the sql query
					try(ResultSet rs=ps.executeQuery()){
						
						//copy the record of ResultSet to list of Employee objs
						list=new ArrayList();
						while(rs.next()) {
							Employee emp=new Employee();
							emp.setEmpno(rs.getInt(1));
							emp.setEname(rs.getString(2));
							emp.setDesg(rs.getString(3));
							emp.setSalary(rs.getDouble(4));
							emp.setDeptno(rs.getInt(5));
							
							//add Employee class obj List Collection
							list.add(emp);
						}//end of while
					}//try 2
					
				}//try 1
				catch (SQLException se) {
				 	se.printStackTrace();
				 	throw se;
				}
		catch (Exception e) {
			e.printStackTrace();
		}
	return list;
	}//method
	

}
