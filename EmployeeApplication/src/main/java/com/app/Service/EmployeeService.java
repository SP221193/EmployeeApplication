package com.app.Service;

import java.util.List;

import com.app.Model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public void deleteEmployee(Employee employee);

	public Employee getEmployeeByID(Employee employee);

	public Employee updateEmployee(Employee employee);

}
