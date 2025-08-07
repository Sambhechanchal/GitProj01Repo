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
			System.out.print("Enter Designation 1:");
			String desg1 = sc.next();
			System.out.print("\nEnter Designation 2:");
			String desg2 = sc.next();
			System.out.print("\nEnter Designation 3:");
			String desg3 = sc.next();
			
			// getting the controller class object ref
			PayrollOperationController control = ctx.getBean("controller", PayrollOperationController.class);
			List<Employee> list = control.showEmployeeByDesg(desg1, desg2, desg3);
			list.forEach(emp ->{System.out.println(emp);});
		}catch(Exception e) {
			System.out.println("Invalid Details SQLException" + e.getMessage());
		}
	}

}
