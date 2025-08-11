package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj11LayeredAppStandaloneEmployeeApplication {

    private final PayrollOperationController controller;


    BootProj11LayeredAppStandaloneEmployeeApplication(PayrollOperationController controller) {
        this.controller = controller;
    }
	

	public static void main(String[] args) {
		try(
				ConfigurableApplicationContext ctx =SpringApplication.run(BootProj11LayeredAppStandaloneEmployeeApplication.class, args);
				Scanner sc = new Scanner(System.in);
				){
			
			// getting the controller class object ref
			PayrollOperationController control = ctx.getBean("controller", PayrollOperationController.class);
			
			
			// taking input details from the end user
			
			System.out.print("Enter employee name :");
			String name = sc.next();
			System.out.println("Enter job : ");
			String job = sc.next();
			System.out.println("Enter salary : ");
			double  salary = sc.nextDouble();
			
			Employee emp1 = new Employee();
			 emp1.setEname(name);
			 emp1.setJob(job);
			 emp1.setSalary(salary);
			
			try{
				String msg = control.showInsertStatus(emp1);
				System.out.println(" Data inserted successfully!!! ");
			}catch(Exception e ) {
				System.out.println("Invalid Details: " + e.getMessage());
			}
			
			
			System.out.print("Enter Designation 1:");
			String desg1 = sc.next();
			System.out.print("\nEnter Designation 2:");
			String desg2 = sc.next();
			System.out.print("\nEnter Designation 3:");
			String desg3 = sc.next();

			List<Employee> list = control.showEmployeeByDesg(desg1, desg2, desg3);
			list.forEach(emp ->{System.out.println(emp);});
		}catch(Exception e) {
			System.out.println("Invalid Details SQLException" + e.getMessage());
		}
	}

}
