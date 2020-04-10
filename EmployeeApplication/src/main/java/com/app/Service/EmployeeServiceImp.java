package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Model.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return repository.getEmployees();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}

	@Override
	public Employee getEmployeeByID(Employee employee) {
		return repository.getEmployeesById(employee.getEmpid());
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
}