package com.jsp.dao;

import com.jsp.model.Account;

public interface AccountDao {
    public boolean save(Account account) throws Exception;

    public Account findUserByUsername1(String userName, String passWord);

}
