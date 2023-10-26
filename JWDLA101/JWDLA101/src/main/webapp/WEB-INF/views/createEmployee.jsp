<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/6/2023
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style><%@include file="/WEB-INF/css/createEmployee.css"%></style>
</head>
<body>
<div class="container-form">
    <div>
        <h1>Add Employee</h1>
        <hr>
        <h2>First Name <span>(*)</span></h2>
    </div>
    <form action="${pageContext.request.contextPath}/createEmployee" method="POST">
        <input class="input" type="text" name="first_name" placeholder="First Name">

        <h2>Last Name <span>(*)</span></h2>
        <input class="input" type="text" name="last_name" placeholder="Last Name">

        <h2>Phone Number <span>(*)</span></h2>
        <input class="input" type="text" name="phone" placeholder="Phone Number">

        <h2>Date Of Birth <span>(*)</span></h2>
        <div class="input-container">
            <input class="input-date" id="datepicker" type="date" name="date_of_birth" placeholder="mm/dd/yyyy">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
            </svg>
        </div>

        <h2>Gender <span>(*)</span></h2>
        <input type="radio" name="gender" value="male" checked> Male<br>
        <input type="radio" name="gender" value="female"> Female<br>

        <h2>Account <span>(*)</span></h2>
        <input class="input" type="text" name="account" placeholder="Account">

        <h2>Email <span>(*)</span></h2>
        <input class="input" type="email" name="email" placeholder="Email">

        <h2>Password <span>(*)</span></h2>
        <input class="input" type="password" name="password" placeholder="Password">

        <h2>Address</h2>
        <input class="input" type="text" name="address" id="address">

        <h2>Status</h2>
        <input type="checkbox" name="status" id="status" value="Active"> Active

        <h2>Department <span>(*)</span></h2>
        <select class="input" name="department_name" id="department" class="department">
            <option value="IT">IT</option>
            <option value="Marketing">Marketing</option>
            <option value="Bccounting ">Accounting </option>
            <option value="Business">Business</option>
            <option value="Sales">Sales</option>
        </select>

        <h2>Remark</h2>
        <input class="input" type="text" name="remark" id="remark">
        <div class="btn-action">
            <a class="btnBack" href="${pageContext.request.contextPath}/employeeList">
                <div class="centered-content">
                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M459.5 440.6c9.5 7.9 22.8 9.7 34.1 4.4s18.4-16.6 18.4-29V96c0-12.4-7.2-23.7-18.4-29s-24.5-3.6-34.1 4.4L288 214.3V256v41.7L459.5 440.6zM256 352V256 128 96c0-12.4-7.2-23.7-18.4-29s-24.5-3.6-34.1 4.4l-192 160C4.2 237.5 0 246.5 0 256s4.2 18.5 11.5 24.6l192 160c9.5 7.9 22.8 9.7 34.1 4.4s18.4-16.6 18.4-29V352z"/></svg>
                    Back
                </div>
            </a>

            <a class="btnReset" href="${pageContext.request.contextPath}/createEmployee">
                <div class="centered-content">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
                        <path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
                    </svg>
                    Reset
                </div>
            </a>

            <button class="btnAdd" name="btnAdd">
                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg>
                Add
            </button>
        </div>
    </form>
</div>
</body>
</html>
