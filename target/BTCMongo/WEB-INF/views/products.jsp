<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Products of Category </title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Products</h2>
<table>
    <tr>
        <td>Product NAME</td><td>Price</td><td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td> ${product.name}</td><td>${product.price}</td>  <td><a href="../${product.id}">Add to Basket</a></td>

    </c:forEach>
</table>
<br/>
</body>
</html>