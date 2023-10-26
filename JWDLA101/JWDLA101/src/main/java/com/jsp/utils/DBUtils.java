package com.jsp.utils;

import com.jsp.model.Account;
import com.jsp.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtils {
    public static Account findUserByUsername(String userName) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "SELECT a FROM Account a WHERE a.account = :userName";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("userName", userName);
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

    public static Account findUserByUsername(String userName, String passWord) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "SELECT a FROM Account a WHERE a.account = :userName and a.password = :passWord";
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
    public static boolean insertEmployee(Employee employee) throws Exception{
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Serializable result = session.save(employee);
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
}
