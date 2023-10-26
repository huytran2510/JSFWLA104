package com.jsp.dao;

import com.jsp.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public boolean save(Employee employee) throws Exception;
    public List<Employee> listEmployee() throws Exception;
}

