package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

//@Repository("dao")
public class EmployeeDAOImpl implements IEmployeeDAO {

	//DataSource object
	//@Autowired
	private DataSource ds;
	
	// PREPARED STATEMENT (ALWASY PRIVATE CONSTANT)
	private static final String GET_EMP_BY_DESG ="SELECT EMPNO , ENAME ,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB ";
	private static final String INSERT_EMP_DATA = "INSERT INTO EMP(EMPNO , ENAME , JOB , SAL) VALUES(emp_seq.nextval ,?,?,?)";
	
	public EmployeeDAOImpl(DataSource ds) {
	System.out.println("EmployeeDAOImpl() :: 0-param constructor");
	this.ds=ds;
	}
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
			System.out.println("EmployeeDAOImpl.getEmployeeByDesgs()");
			List<Employee> list = new ArrayList<Employee>();
			try(
					
					// get connection object
					Connection con = ds.getConnection();
					
					// get prepared stmt object
					PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESG);
					){
				
				ps.setString(1, desg1);
				ps.setString(2, desg2);
				ps.setString(3, desg3);
				try(ResultSet rs = ps.executeQuery()){
					
					while(rs.next()) {
						Employee emp = new Employee();
						emp.setEid(rs.getInt(1));
						emp.setEname(rs.getString(2));
						emp.setJob(rs.getString(3));
						emp.setSalary(rs.getDouble(4));
						list.add(emp);
					}
				}
				
			}catch(Exception e) {
				throw e;
			}
		return list;
	}
	
	
	// insert details methods
	@Override
	public int insertEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeDAOImpl.insertEmployee()");
		int count =0;
		try(
				// get conection object from the datasource
				 Connection con = ds.getConnection();
				
				PreparedStatement ps = con.prepareStatement(INSERT_EMP_DATA);
				){
			// set value into prepared statement
			ps.setString(1,emp.getEname());
			ps.setString(2,emp.getJob());
			ps.setDouble(3,emp.getSalary());
			
			count = ps.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}
		return count;
	}

}
