package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
	
	//public abstract method throwing exception
	
	public List<Employee> fetchAllEmployeeDesg(String desg1 , String desg2 , String desg3)throws Exception;

}
