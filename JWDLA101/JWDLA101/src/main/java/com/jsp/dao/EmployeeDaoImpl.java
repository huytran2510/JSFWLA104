package com.jsp.dao;

import com.jsp.model.Employee;
import com.jsp.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public boolean save(Employee employee) throws Exception{
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
    @Override
    public List<Employee> listEmployee() throws Exception {
        Session session = null;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Employee"; // You don't need to select individual columns
            Query<Employee> query = session.createQuery(hql, Employee.class);
            List<Employee> employees = query.getResultList();
            return employees;
        } catch (Exception e) {
            // Handle exceptions or log errors here
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
