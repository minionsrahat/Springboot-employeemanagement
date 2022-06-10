package com.example.employeemanagement.Repository;

import com.example.employeemanagement.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
