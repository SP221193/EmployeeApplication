package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select emp from Employee emp")
	List<Employee> getEmployees();

	@Query(value = "select emp from Employee emp where emp.id = :empId")
	Employee getEmployeesById(@Param("empId") Integer empId);
}
