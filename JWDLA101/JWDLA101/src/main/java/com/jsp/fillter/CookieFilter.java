//package com.jsp.fillter;
//
//import com.jsp.model.Account;
//import com.jsp.utils.DBUtils;
//import com.jsp.utils.MyUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
//public class CookieFilter implements Filter {
//    public CookieFilter() {
//    }
//
//    @Override
//    public void init(FilterConfig fConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//
//        Account userInSession = MyUtils.getLoginedUser(session);
//        //
//        if (userInSession != null) {
//            session.setAttribute("COOKIE_CHECKED", "CHECKED");
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // Connection was created in JDBCFilter.
//        Connection conn = MyUtils.getStoredConnection(request);
//
//        // Flag check cookie
//        String checked = (String) session.getAttribute("COOKIE_CHECKED");
//        if (checked == null && conn != null) {
//            String userName = MyUtils.getUserNameInCookie(req);
//            try {
//                Account user = DBUtils.findUserByUsername( userName);
//                MyUtils.storeLoginedUser(session, user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            // Mark checked Cookies.
//            session.setAttribute("COOKIE_CHECKED", "CHECKED");
//        }
//
//        chain.doFilter(request, response);
//    }
//}
