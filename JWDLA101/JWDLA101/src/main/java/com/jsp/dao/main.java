package com.jsp.dao;

import com.jsp.model.Employee;

import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> employeeList = employeeDao.listEmployee();
        for(Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
