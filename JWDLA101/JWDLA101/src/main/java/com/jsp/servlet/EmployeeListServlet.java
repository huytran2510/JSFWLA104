package com.jsp.servlet;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
import com.jsp.model.Employee;
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
import java.util.List;

@WebServlet(urlPatterns = { "/employeeList" })
public class EmployeeListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Employee> allEmployees = null;
        List<Employee> pagedEmployees = null;
        int currentPage = 1;
        int pageSize = 3;
        int totalPages = 0;
        try {
            // Retrieve the database connection
            conn = MyUtils.getStoredConnection(request);

            // Retrieve the list of all employees from your DAO class
            allEmployees = employeeDao.listEmployee();

            // Get the requested page number from the request parameter, if available
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                currentPage = Integer.parseInt(pageStr);
            }

            // Calculate pagination parameters
            int totalEmployees = allEmployees.size();
            totalPages = (int) Math.ceil((double) totalEmployees / pageSize);
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, totalEmployees);

            // Create a sublist of employees for the current page
            pagedEmployees = allEmployees.subList(startIndex, endIndex);

        } catch (SQLException e) {
            e.printStackTrace();
            errorString = "SQL Error: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = "Error: " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("employeeList", pagedEmployees);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);

        // Forward to the JSP page for displaying the employee list with pagination
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/views/EmployeeListView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        request.setCharacterEncoding("UTF-8");
    }

}
