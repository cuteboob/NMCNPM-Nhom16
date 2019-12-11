/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author duc
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("link.html").include(request, response);
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String name = request.getParameter("name");

        String fullName = request.getParameter("firstName") + " " + request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String birthDay = request.getParameter("birthday");;
        String sex = request.getParameter("sex");
        String phoneNumber = request.getParameter("phoneNumber");

        String query = "INSERT INTO member VALUES (N'" + fullName + "',N'" + userName + "',N'" + password + "',N'" + email + "','" + birthDay + "',N'" + sex + "',N'" + phoneNumber + "')";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);

            if (rs == 1) {
                out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Bạn đã đăng kí thành công.\n" +
"  </div>");
                HttpSession session = request.getSession();
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            query = "Insert into Manager_Member(UserName, Manager_Member.Status) values ('"+userName+"', 1);";
            rs = statement.executeUpdate(query);
            conn.close();
        } catch (SQLException | NamingException ex) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Tên đăng nhập đã sử dụng.\n" +
"  </div>");
            request.getRequestDispatcher("register.jsp").include(request, response);
            System.err.println(ex);
        }
        out.close();
    }
}
