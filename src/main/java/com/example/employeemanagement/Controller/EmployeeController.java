package com.example.employeemanagement.Controller;


import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @RequestMapping("addemployee")
    public ModelAndView addEmployee() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addEmployee.html");
        return  mv;
    }

    @PostMapping("addemployeedetails")
    public ModelAndView addEmployeeDetails( Employee employee) {
        employeeService.addEmployee(employee);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("SuccessMsg.html");
        mv.addObject("message","Employee Information Added Successfully");
        return mv;
    }



    @GetMapping("manageemployee")
    public ModelAndView manageEmployee() {
        ModelAndView mv = new ModelAndView();
        List<Employee> employeeList=employeeService.getEmployees();
        mv.setViewName("ManageEmployee.html");
        mv.addObject("employees",employeeList);
        return  mv;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        Employee employee=employeeService.getEmployeeById(id);
        mv.setViewName("EditEmployee.html");
        mv.addObject("employee",employee);
        return  mv;
    }

    @PutMapping("editemployeedetails")
    public ModelAndView EditEmployeeDetails( Employee employee) {
        Employee employee1=employeeService.updateEmployee(employee);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("SuccessMsg.html");
        mv.addObject("message","Employee Information Edited Successfully");
        return mv;
    }


    @GetMapping("delete/{id}")
    public ModelAndView EditEmployeeDetails(@PathVariable int id) {
        employeeService.deleteById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("SuccessMsg.html");
        mv.addObject("message","Employee Information Deleted Successfully");
        return mv;
    }




}
