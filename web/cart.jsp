<%-- 
    Document   : product
    Created on : Oct 12, 2019, 10:37:07 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Giỏ hàng</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js/jquery.min.js"></script>


<!--script-->
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        	<div class="container">
		
	<div class="women-product">
            <%
        List<Product> CartList = (List<Product>) session.getAttribute("Cart");
        %>
		<%@include file="/WEB-INF/jspf/viewCart.jspf" %>
	</div>

        
	<%@include file="/WEB-INF/jspf/newjsp.jspf" %>
	<div class="clearfix"> </div>
</div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
