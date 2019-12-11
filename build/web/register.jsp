<%-- 
    Document   : register
    Created on : Oct 12, 2019, 10:41:22 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng ký</title>
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
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container"> 
			         
        <jsp:include page="registerform.jsp"></jsp:include>
		   <%@include file="/WEB-INF/jspf/newjsp.jspf" %>
	</div>
         <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
