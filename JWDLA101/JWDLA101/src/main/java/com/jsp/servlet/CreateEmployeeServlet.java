package com.jsp.servlet;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
import com.jsp.model.Account;
import com.jsp.model.Employee;
import com.jsp.utils.DBUtils;
import com.jsp.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = { "/createEmployee" })
public class CreateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CreateEmployeeServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getSession().getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createEmployeeView.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        String btnAdd = request.getParameter("btnAdd");
        if (btnAdd != null) {
            String first_name = (String) request.getParameter("first_name");
            String last_name = (String) request.getParameter("last_name");
            String gender = (String) request.getParameter("gender");
            String dobStr = (String) request.getParameter("date_of_birth");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date_of_birth = LocalDate.parse(dobStr, dateFormatter);
            String phone = (String) request.getParameter("phone");
            String address = (String) request.getParameter("address");
            String department_name = (String) request.getParameter("department_name");
            String remark = (String) request.getParameter("remark");

            String account = (String) request.getParameter("account");
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            String status = (String) request.getParameter("status");
            int statusValue = 0;
            if(status != null) {
                statusValue = 1;
            }
            Employee employee = new Employee(first_name, last_name, gender, date_of_birth, phone, address, department_name, remark);
            Account accounts = new Account(account,email,password,statusValue);
            employee.setAccount(accounts);
            accounts.setEmployee(employee);
            String errorString = null;

            // Product ID is the string literal [a-zA-Z_0-9]
            // with at least 1 character
            String regex = "\\w+";
            if (errorString == null) {
                try {
                    employeeDao.save(employee);
                } catch (SQLException e) {
                    e.printStackTrace();
                    errorString = e.getMessage();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            // Store infomation to request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            request.setAttribute("employee", employee);

            // If error, forward to Edit page.
            if (errorString != null) {
                RequestDispatcher dispatcher = request.getSession().getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/createEmployeeView.jsp");
                dispatcher.forward(request, response);
            }
            // If everything nice.
            // Redirect to the product listing page.
            else {
                response.sendRedirect(request.getContextPath() + "/employeeList");
            }
        }
    }

}
