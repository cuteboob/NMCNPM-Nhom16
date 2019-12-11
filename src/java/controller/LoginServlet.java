/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("link.html").include(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String query = "SELECT member.*, Status FROM member, Manager_Member WHERE member.userName='"+username+"' AND password='"+password+"' and Member.userName = Manager_Member.userName";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            if (rs.next()) {
                if (rs.getBoolean("Status")==false) {
                    out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Tài khoản này đã bị khóa.\n" +
"  </div>");
                request.getRequestDispatcher("login.jsp").include(request,response);
                } else {
                out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Đăng nhập thành công vào hệ thống.\n" +
"  </div>");
                HttpSession session = request.getSession();
                session.setAttribute("userName", username);
                session.setAttribute("fullName", rs.getString("FullName"));
                session.setAttribute("sex", rs.getString("Sex"));
                Date date = new Date();  
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                date = rs.getDate("BirthDay");
                String strDate = formatter.format(date);  
                session.setAttribute("birthDay", strDate);
                session.setAttribute("email", rs.getString("Email"));
                session.setAttribute("phoneNumber", rs.getString("PhoneNumber"));
                request.getRequestDispatcher("index.jsp").include(request,response);
                }
            } else {
                out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Sai tên đăng nhập hoặc mật khẩu.\n" +
"  </div>");
                request.getRequestDispatcher("login.jsp").include(request,response);
            }
            out.close();
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
       // out.println("");
    }
}
