<%-- 
    Document   : single
    Created on : Oct 12, 2019, 10:45:37 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
<title>Sản phẩm</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js/jquery.min.js"></script>

<script src="js/jquery.etalage.min.js"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 354.11,
					thumb_image_height: 306.73,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
//					click_callback: function(image_anchor, instance_id){
//						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
//					}
				});
                                
                                $('.etalage_icon').remove();
			});
		</script>

</head>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        	 <div class="container"> 
	<%@include file="/WEB-INF/jspf/single_top.jspf" %>
          	   
          	   <!---->
<%@include file="/WEB-INF/jspf/newjsp.jspf" %>
<div class="clearfix"> </div>			
		</div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
