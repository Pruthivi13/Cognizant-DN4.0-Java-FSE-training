package com.cognizant.dao;

import com.cognizant.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", List.class);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}