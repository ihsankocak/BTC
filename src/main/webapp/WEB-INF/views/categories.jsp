<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Categories</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Categories</h2>
<table>
    <tr>
        <td>CATEGORY NAME</td><td>category id</td><td>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
         <td><a href="./product/category/${category.id}">  ${category.name}</a></td><td>${category.id}</td>

    </c:forEach>
</table>
<br/>
</body>
</html>