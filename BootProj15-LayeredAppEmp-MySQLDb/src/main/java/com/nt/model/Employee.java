package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data

public class Employee {

	private int eid;
	private String ename;
	private String job;
	private double salary;
	private double grossSalary;
	private double netSalary;
	

}
