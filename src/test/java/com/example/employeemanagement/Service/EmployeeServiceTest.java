package com.example.employeemanagement.Service;

import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    AutoCloseable autoCloseable;
    private EmployeeService underTest;

    @BeforeEach
    public void setup(){
        autoCloseable=MockitoAnnotations.openMocks(employeeRepository);
        underTest=new EmployeeService(employeeRepository);

    }

    @AfterEach
    public  void  tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void CheckIsaddEmployeeWorking() {
//        given
        Employee employee=new Employee(1,"Rahat","Dhaka",600, "Software");
        Employee employee1=new Employee(1,"Sojib","Dhaka",600, "Software");
//         when
        underTest.addEmployee(employee);

//        then
        ArgumentCaptor<Employee> employeeArgumentCaptor=ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeArgumentCaptor.capture());

        Employee resultEmployee=employeeArgumentCaptor.getValue();

        assertThat(resultEmployee).isEqualTo(employee);
    }

    @Test

    void getEmployees() {
        underTest.getEmployees();
        verify(employeeRepository).findAll();
    }

    @Test
    @Disabled
    void getEmployeeById() {
    }

    @Test
    @Disabled
    void updateEmployee() {
    }

    @Test
    @Disabled
    void deleteById() {
    }
}