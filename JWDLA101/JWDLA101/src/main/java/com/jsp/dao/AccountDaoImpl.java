package com.jsp.dao;

import com.jsp.model.Account;
import com.jsp.model.Employee;
import com.jsp.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    @Override
    public boolean save(Account account) throws Exception{
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Serializable result = session.save(account);
            transaction.commit();
            return (result != null);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Account findUserByUsername1(String userName, String passWord) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "SELECT a FROM Account a" +
                    " WHERE a.account = :userName and a.password = :passWord";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("userName", userName);
            query.setParameter("passWord",passWord);
            List<Account> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
