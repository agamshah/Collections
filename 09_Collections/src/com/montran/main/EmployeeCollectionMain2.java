package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMain2 extends Employee{
	
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	EmployeeCollectionUtil employeeCollectionUtil = new EmployeeCollectionUtil();
	Employee employee;
	int employeeId;
	String name;
	double salary;
	Employee[] arrayofemp;
	boolean result;
	List<Employee> employeelist = new ArrayList<Employee>();
	int numberOfEmployee;
	int employeeChoice;
	String continueChoice;

	do {
		employeelist = employeeCollectionUtil.getAllEmployees() ;
		for (Employee emp : employeelist) {
			if (emp != null)
				System.out.println(emp);
			System.out.print("\n");
		}
		System.out.println("1. Add Single Employee.");
		System.out.println("2. Add Multiple Employee.");
		System.out.println("3. Update Existing Employee.");
		System.out.println("4. Delete Existing Employee.");
		System.out.println("5. Print Single Employee Detail.");
		System.out.println("6. Exit.");
		employeeChoice = scanner.nextInt();
		switch (employeeChoice) {
		case 1:
			System.out.println("Enter Employee Id");
			employeeId=scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Employee name: ");
			name = scanner.nextLine();
			System.out.print("Enter Employee Salary: ");
			salary = scanner.nextDouble();
			employee = new Employee(employeeId, name, salary);
			result = employeeCollectionUtil.addNewEmployee(employee);
			System.out.println(result);
			if (result)
				System.out.println("Employee Added!");
			else {
				System.out.println("Failed");
			}
			break;
		case 2:
			System.out.print("How Many Employee do you want to Enter: ");
			int nof_emp = scanner.nextInt();
			arrayofemp = new Employee[nof_emp];
			for (int i = 0; i < nof_emp; i++) {
				System.out.println("Enter Employee Id");
				employeeId=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Employee name: ");
				name = scanner.nextLine();
				System.out.print("Enter Employee Salary: ");
				salary = scanner.nextDouble();
				employee = new Employee(0, name, salary);
				arrayofemp[i] = employee;
			}
			result = employeeCollectionUtil.addAllEmployee(arrayofemp);
			if (result)
				System.out.println("Employee Added Successfully!.");
			else {
				System.out.println("Failed!");
			}
			break;
		case 3:
			System.out.print("Enter the Employee id: ");
			employeeId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter new Employee name");
			name = scanner.nextLine();
			System.out.print("Enter new Salary: ");
			salary = scanner.nextDouble();
			result = employeeCollectionUtil.updateEmployeeSalary(employeeId, salary);
			if (result)
				System.out.println("Employee Updated Successfully");
			else {
				System.out.println("Book ID not found.");
			}
			break;

		case 4:
			System.out.print("Enter Employee id: ");
			employeeId = scanner.nextInt();
			result = employeeCollectionUtil.deleteEmployee(employeeId);
			if (result)
				System.out.println("Employee Deleted Successfully");
			else {
				System.out.println("Employee ID not found");
			}
			break;
		case 5:
			System.out.print("Enter Employee id: ");
			employeeId = scanner.nextInt();
			employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
			if (employee == null)
				System.out.print("Employee Not Found!!!");
			else
				System.out.println(employee);
			break;
		case 6:
			System.out.print("Thank You!!!");
			System.exit(0);
			break;
		default:
			break;
		}
		System.out.print("\n");
		System.out.print("Do you want to continue(Yes/no)?: ");
		continueChoice = scanner.next();
	} while (continueChoice.toLowerCase().equals("yes"));

	scanner.close();
}

}
