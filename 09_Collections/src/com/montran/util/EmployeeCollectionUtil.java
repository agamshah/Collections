package com.montran.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {

	private List<Employee> employeelist = new ArrayList<Employee>();
	
	public boolean addNewEmployee(Employee employee)
	{
		employeelist.add(employee);
		return true;
	}
	public boolean addAllEmployee(Employee employees[])
	{
		for (Employee employee : employees) {
			addNewEmployee(employee);
		}
		return true;
	}
	public boolean updateEmployeeSalary(int employeeID, double salary) {
		
		for (Employee employee : employeelist) {
			if(employeeID==employeeID) {
				employee.setSalary(salary);
				return true;
			}
		}
		return false;
	}
	public boolean deleteEmployee(int employeeId)
	{
		for (Employee employee : employeelist) {
			if(employeeId==employeeId)
			{
				employeelist.remove(employeeId);
				return true;
			}
		}
		return false;
	}
	public Employee getEmployeeByEmployeeId(int employeeID)
	{
		for (Employee employee : employeelist) {
			if(employee != null)
			{
				if(employee.getEmployeeId() == employeeID);
				return employee;
			}
		}
		return null;
	}
	public List<Employee> getAllEmployees()
	{
		return employeelist;
	}
}
