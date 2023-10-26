//package com.jsp.fillter;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.context.internal.ManagedSessionContext;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter(filterName = "hibernateFilter", urlPatterns = { "/*" })
//public class HibernateFilter implements Filter {
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void init(FilterConfig fConfig) throws ServletException {
//
//    }
//
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//    private boolean needHibernate(HttpServletRequest request) {
//
//        System.out.println("Hibernate Filter");
//        String servletPath = request.getServletPath();
//        // => /abc/mnp
//        String pathInfo = request.getPathInfo();
//        String urlPattern = servletPath;
//        if (pathInfo != null) {
//            urlPattern = servletPath + "/*";
//        }
//        return true;
//    }
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        if (this.needHibernate(req)) {
//            System.out.println("Open Hibernate Session for: " + req.getServletPath());
//            Session session = null;
//            Transaction transaction = null;
//            try {
//                session = sessionFactory.openSession();
//                ManagedSessionContext.bind(session);
//                transaction = session.beginTransaction();
//                chain.doFilter(request, response);
//
//                transaction.commit();
//            } catch (Exception e) {
//                if (transaction != null) {
//                    transaction.rollback();
//                }
//                e.printStackTrace();
//                throw new ServletException(e);
//            } finally {
//                ManagedSessionContext.unbind(sessionFactory);
//                if (session != null) {
//                    session.close();
//                }
//            }
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//}
