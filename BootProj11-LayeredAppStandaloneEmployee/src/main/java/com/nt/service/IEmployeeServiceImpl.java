package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("service")
public class IEmployeeServiceImpl implements IEmployeeService {

	
	// dao interface reference variable
	@Autowired
	private IEmployeeDAO dao ;
	@Override
	public List<Employee> fetchAllEmployeeDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("IEmployeeServiceImpl.fetchAllEmployeeDesg()");
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		List<Employee> list = dao.getEmployeeByDesgs(desg1, desg2, desg3);
				
			//	Employee emp = new Employee();
		list.forEach(emp ->{
		emp.setGrossSalary(emp.getSalary()+ emp.getSalary()*0.2);
		emp.setNetSalary(emp.getGrossSalary() - emp.getGrossSalary()*0.1);
		});
		
		return list;
	}

}
