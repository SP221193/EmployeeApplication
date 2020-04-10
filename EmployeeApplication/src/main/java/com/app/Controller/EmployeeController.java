package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Employee;
import com.app.Service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/save-employee", consumes = "application/json", produces = "application/json")
	public Employee saveEmployee(@RequestBody Employee employee) {
		System.out.println("Inside save");
		return employeeService.saveEmployee(employee);

	}

	@RequestMapping("/test")
	public void message() {
		System.out.print("Its working");
	}

	@GetMapping("/employees-list")
	public List<Employee> allEmployees() {
		return employeeService.getEmployees();
	}

	@DeleteMapping("/delete-employee/{emp_id}")
	public void deleteEmployee(@PathVariable("emp_id") int empid, Employee employee) {
		employee.setEmpid(empid);
		employeeService.deleteEmployee(employee);
	}

	@GetMapping("/employee/{emp_id}")
	public Employee allEmployeeByID(@PathVariable("emp_id") int empid, Employee employee) {
		employee.setEmpid(empid);
		return employeeService.getEmployeeByID(employee);

	}

	@PostMapping("/update-employee/{emp_id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("emp_id") int empid) {
		employee.setEmpid(empid);
		return employeeService.updateEmployee(employee);
	}

}