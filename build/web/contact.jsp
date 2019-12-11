<%-- 
    Document   : contact
    Created on : Oct 12, 2019, 10:50:57 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Liên hệ</title>
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
    <body data-gr-c-s-loaded="true">
        <jsp:include page="header.jsp"></jsp:include>



            <div class="container">
                <%@include file="/WEB-INF/jspf/newjsp.jspf" %>
                <!---->
                <div class="main"> 
                    <div class="reservation_top">          
                        <div class=" contact_right">
                            <h3>Biểu mẫu</h3>
                            <div class="contact-form">
                                <form method="post" action="contact-post.jsp">
                                    <input type="text" class="textbox" value="Tên" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Tên';
                                            }">
                                    <input type="text" class="textbox" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Email';
                                            }">
                                    <textarea value="Lời nhắn" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Lời nhắn';
                                            }">Lời nhắn</textarea>
                                    <input type="submit" value="Gửi">
                                    <div class="clearfix"> </div>
                                </form>
                                <address class="address">
                                    <p>9870 St Vincent Place, <br>Glasgow, DC 45 Fr 45.</p>
                                    <dl>
                                        <dt> </dt>
                                        <dd>Freephone:<span> +1 800 254 2478</span></dd>
                                        <dd>Telephone:<span> +1 800 547 5478</span></dd>
                                        <dd>FAX: <span>+1 800 658 5784</span></dd>
                                        <dd>E-mail:&nbsp; <a href="mailto@vintage.com">info(at)bigshop.com</a></dd>
                                    </dl>
                                </address>
                            </div>
                        </div>
                    </div>
                </div>

        </div>








        <jsp:include page="footer.jsp"></jsp:include>





    </body>
</body>
</html>
