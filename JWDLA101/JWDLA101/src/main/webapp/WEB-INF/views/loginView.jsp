<%--<jsp:useBean id="account" scope="request" type="com.jsp.model.Account"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/24/2023
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style><%@include file="/WEB-INF/css/login.css"%></style>
</head>
<body>
<div class="container">
    <div class="content">
        <h1>Member Login</h1>
        <p style="color: red;">${errorString}</p>
        <form class="form" id="form" method="POST" action="${pageContext.request.contextPath}/login">
            <div class="input-container">
                <i class="fas fa-user"></i>
                <input id="username" name="account" type="text" placeholder="User Name" value="${user.account}">
            </div>
            <div class="input-container">
                <i class="fas fa-lock"></i>
                <input id="password" name="password" type="password" placeholder="Password" value="${user.password}">
            </div>
            <br />
            <input id="submit" type="submit" value="Submit" name="login" />
            <br>
            <div class="forgot-password">
                <a href="#">Forgot Password?</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
