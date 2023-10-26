package com.jsp.dao;

import com.jsp.model.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoTest {
    static AccountDao accountDao;

    @BeforeAll
    static void setUpBeforeClass () throws Exception {
        accountDao = new AccountDaoImpl();
    }

    @Test
    void testFindUserByUsername1_UserExists() {
        String username = "username";
        String password = "password123";

        Account result = accountDao.findUserByUsername1(username, password);
        System.out.println(result);
        assertNotNull(result);
    }
}