package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("controller")
public class PayrollOperationController{

	@Autowired
	private IEmployeeService empService;
	
	
	public List<Employee> showEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("PayrollOperationController.showEmployeeByDesg()");
		List<Employee> list = empService.fetchAllEmployeeDesg(desg1, desg2, desg3);
		return list;
	}
	
	public String showInsertStatus(Employee emp)throws Exception{
		
		String msg = empService.fetchStatus(emp);
		
		return msg;
	}

}
