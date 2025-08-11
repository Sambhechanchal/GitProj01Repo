package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
	
	// abstract methods
	public List<Employee> getEmployeeByDesgs(String desg1 , String desg2 , String desg3) throws Exception;
	
	public int insertEmployee(Employee emp)throws Exception;

}
