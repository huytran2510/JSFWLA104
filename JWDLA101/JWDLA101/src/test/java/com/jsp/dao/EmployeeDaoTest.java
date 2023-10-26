package com.jsp.dao;

import com.jsp.model.Account;
import com.jsp.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {
    static AccountDao accountDao;
    static EmployeeDao employeeDao;

    @BeforeAll
    static void setUpBeforeClass () throws Exception {
        accountDao = new AccountDaoImpl();
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    void testSave() throws Exception {
        Account account = new Account("username", "email@example.com", "password123", 1);
        Employee employee = new Employee("John", "Doe", "Male", LocalDate.of(1990, 5, 15),
                "123-456-7890", "123 Main St", "IT Department", "Good employee");
        employee.setAccount(account);
        account.setEmployee(employee);
        assertEquals(true,employeeDao.save(employee));
    }
}