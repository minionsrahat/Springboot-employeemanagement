package com.example.employeemanagement.Service;

import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            Employee oldEmployee=optionalEmployee.get();
            oldEmployee.setName(employee.getName());
            oldEmployee.setAddress(employee.getAddress());
            oldEmployee.setDept(employee.getDept());
            oldEmployee.setSalary(employee.getSalary());
            return  employeeRepository.save(oldEmployee);
        }
        else
        {
            return new Employee();
        }
    }

    public String deleteById(int id){
        employeeRepository.deleteById(id);
        return  "Success";
    }
}
