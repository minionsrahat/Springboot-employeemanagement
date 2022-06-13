package com.example.employeemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EmployeeManagementApplicationTests {

	Calculator underTest=new Calculator();


	@Test
	void isAddTwoNumbers() {
//		given
		int num1=40;
		int num2=34;

//		when

		int result=underTest.addNumbers(40,34);

//		then
		assertThat(result).isEqualTo(74);
	}

	class Calculator{
		public  int addNumbers(int a, int b){
			return a+b;
		}
	}
}
