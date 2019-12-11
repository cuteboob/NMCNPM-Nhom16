<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>View Products</title>
    </head>
    <body>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>ProductName</th>
                <th>Price</th>
                <th>Company</th>
            </tr>

            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.getProductName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getCompany()}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${currentPage != 1}">
        <td><a href="product?page=${currentPage - 1}">Previous</a></td>
        </c:if>
        
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="product?page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>
        
        <c:if test="${currentPage lt noOfPages}">
            <td><a href="product?page=${currentPage + 1}">Next</a></td>
        </c:if>
        
</body>
</html>