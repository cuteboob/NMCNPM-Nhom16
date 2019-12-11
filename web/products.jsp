<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<sql:query var="listProducts" dataSource="jdbc/SalesWebsite">
select ProductName, Price from Product;
</sql:query>
 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
 <div align="center">
 <table border="1" cellpadding="5">
 <caption><h2>List of products</h2></caption>
 <tr>
 <th>Product Name</th>
 <th>Price</th>
 </tr>
 <c:forEach var="p" items="${listProducts.rows}">
 <tr>
 <td><c:out value="${p.ProductName}" /></td>
 <td><c:out value="${p.Price}" /></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</body>
</html>