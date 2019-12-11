<%-- 
    Document   : registerform
    Created on : Oct 13, 2019, 9:18:40 PM
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
        <div class="register">
            <form method="post" action="RegisterServlet">  
                <div class="  register-top-grid">
                    <h3>Thông tin cá nhân</h3>
                    <div class="mation">
                        <span>Họ</span>
                        <input type="text" id="firstName" name="firstName">

                        <span>Tên</span>
                        <input type="text" id="lastName" name="lastName"> 
                        <span>Giới tính</span><input type="text" id="sex" name="sex"><span>Ngày sinh</span><input type="date" id="birthday" name="birthday"></div>
                        <span>Địa chỉ Email</span>
                        <input type="text" id="email" name="email"> 
                        <span>Số điện thoại</span>
                        <input type="text" id="phoneNumber" name="phoneNumber"> 
                   
                    
                    <div class="clearfix"> </div>    
                </div>
                <div class="  register-bottom-grid">
                    <h3>Thông tin tài khoản</h3>
                    <div class="mation">
                        <span>Tên đăng nhập<label>*</label></span>
                        <input type="text" id="userName" name="userName">
                        <span>Mật khẩu<label>*</label></span>
                        <input type="password" id="password" name="password">
                        <span>Xác nhận mật khẩu<label>*</label></span><input type="password" id="cfpassword"></div>
                        
                        
                </div>
                <div class="register-but">
                    <input type="submit" value="Đăng kí">
                </div></form>
        </div>
    </body>
</html>
