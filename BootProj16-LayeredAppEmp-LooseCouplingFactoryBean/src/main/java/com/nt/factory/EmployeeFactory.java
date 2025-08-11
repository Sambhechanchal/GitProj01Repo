package com.nt.factory;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.EmployeeDAOMySql;
import com.nt.dao.IEmployeeDAO;

@Component("factory")
public class EmployeeFactory implements FactoryBean<IEmployeeDAO> {
	
	//get value from application.properties files
	@Value("${dao.db}")
	private String db;
	
	// datasource object
	@Autowired
	private DataSource ds;
	
	@Override
	public IEmployeeDAO getObject() throws Exception {
		switch(db){
			case "oracle":
				return new EmployeeDAOImpl(ds);
			case "mysql":
				return new EmployeeDAOMySql(ds);
			default:
				throw new IllegalArgumentException("Invalid DataBase Name");
		}
		
	}
	
	@Override
	public Class<?> getObjectType() {
		
		return IEmployeeDAO.class;
	}
	
	@Override
	public boolean isSingleton() {
		
		return true;
	}

}
