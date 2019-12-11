<%-- 
    Document   : header
    Created on : Oct 12, 2019, 10:18:15 PM
    Author     : PV
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" 
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    </head>
    <body>
        <div class="header">
            <div class="bottom-header">
                <div class="container">
                    <div class="header-bottom-left">
                        <div class="logo">
                            <a href="index.jsp"><img src="images/logo.png" alt=" " style="
                                                     width: 100%;
                                                     "></a>
                        </div>
                        <div class="search">
                            <form method="post" action="SearchServlet" style="
    margin-block-end: 0px;
">
                                <input type="text" value="" name="search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }">
                                <input type="submit" value="Tìm kiếm" style="float: right;">
                            </form>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="header-bottom-right">					
                        <div class="account" style="
                             line-height: 0px;
                             <% 
                                 if (session.getAttribute("fullName")==null) 
                                 out.print("visibility: hidden; width:26%");
                             %>;
                             "><a href="infomation.jsp"><span> </span><% 
                                out.print(session.getAttribute("fullName"));
                                %></a></div>
                        <% 
                                 if (session.getAttribute("fullName")==null) 
                                 out.println("<ul class=\"login\">\n" +
"                            <li><a href=\"login.jsp\"><span> </span>Đăng nhập</a></li> |\n" +
"                            <li><a href=\"register.jsp\">Đăng kí</a></li>\n" +
"                        </ul>");
                                 else
                                 out.println("<ul class=\"login\">\n" +
"                            <li><a href=\"LogoutServlet\"><span> </span>Đăng xuất</a></li>\n" +
"                        </ul>");
                        %>
                        <div class="cart"><a href="cart.jsp"><span> </span>Giỏ hàng</a></div>
                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"> </div>	
                </div>
            </div>
        </div>
    </body>
</html>
