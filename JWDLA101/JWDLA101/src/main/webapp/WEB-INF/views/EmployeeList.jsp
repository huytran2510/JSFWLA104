<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/24/2023
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/employeeList.css"%></style>
</head>
<body>

<div class="container-boxList">
    <h1>Employee List</h1>
    <hr />
    <div class="form-action">
        <div class="form-search">
            <div class="icon-cell" class="icon-cell">
                <svg
                        class="icon-svg"
                        xmlns="http://www.w3.org/2000/svg"
                        width="16"
                        height="16"
                        fill="currentColor"
                        class="bi bi-search"
                        viewBox="0 0 16 16"
                >
                    <path
                            d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
                    />
                </svg>
            </div>
            <input
                    class="input-cell"
                    type="text"
                    name="search"
                    placeholder="User Search"
            />
        </div>
        <div style="display: flex; margin-left: 20px">
            <input type="submit" class="icon-button" value="Filter By" />
            <input type="submit" class="icon-button" value="Name" />
        </div>
        <div>
            <input class="Search" type="submit" value="Search" />
        </div>
    </div>
    <div class="form-list">
        <table>
            <tr class="header-table">
                <td>ID</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Address</td>
                <td>Phone number</td>
                <td>Department</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>${employee.employee_id}</td>
                    <td>${employee.full_name}</td>
                    <td>${employee.date_of_birth}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.department_name}</td>
                    <td class="icon-view">
                        <a href=""> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M15 12c0 1.654-1.346 3-3 3s-3-1.346-3-3 1.346-3 3-3 3 1.346 3 3zm9-.449s-4.252 8.449-11.985 8.449c-7.18 0-12.015-8.449-12.015-8.449s4.446-7.551 12.015-7.551c7.694 0 11.985 7.551 11.985 7.551zm-7 .449c0-2.757-2.243-5-5-5s-5 2.243-5 5 2.243 5 5 5 5-2.243 5-5z"/></svg> View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="pagination">
            <c:if test="${currentPage > 1}">
                <a class="btn-page" href="?page=${currentPage - 1}">Previous</a>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="page">
                <c:choose>
                    <c:when test="${page eq currentPage}">
                        <div class="current-page">${page}</div>
                    </c:when>
                    <c:otherwise>
                        <a class="btn-page" href="?page=${page}">
                            <div>
                                ${page}
                            </div>
                        </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <a class="btn-page" href="?page=${currentPage + 1}">Next</a>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
