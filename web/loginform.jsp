<%-- 
    Document   : loginform
    Created on : Oct 13, 2019, 9:08:15 PM
    Author     : PV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="account_grid">
            <div class=" login-right">
                <h3>ĐĂNG NHẬP</h3>
                <p>Nếu bạn đã có tài khoản, hãy đăng nhập.</p>






                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>


                <form action="LoginServlet" method="post">
                    <div>
                        <span>Tên đăng nhập<label>*</label></span>
                        <input type="text" id="username" name="username"> 
                    </div>
                    <div>
                        <span>Mật khẩu<label>*</label></span>
                        <input type="password" id="password" name="password"> 
                    </div>
                    <input type="submit" value="Đăng nhập"><br><a class="forgot" href="#">Quên mật khẩu?</a>

                </form>



            </div>	
            <div class=" login-left">
                <h3>Khách hàng mới?</h3>
                <p>Nếu bạn chưa có hãy đăng ký tài khoản mới</p>
                <a class="acount-btn" href="register.jsp">Đăng ký</a>
            </div>
            <div class="clearfix"> </div>
        </div>
    </body>
</html>
