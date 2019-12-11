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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            String query = "SELECT name FROM [User] WHERE username='" + username + "'";

            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/BookStoreOnl");
                Connection conn = ds.getConnection();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(query);

                if (rs.next()) {
                    RequestDispatcher view = request.getRequestDispatcher("ViewProfile.jsp");
                    request.setAttribute("name", rs.getString("name"));
                    request.setAttribute("username", username);
                    view.forward(request, response);
                }
                conn.close();
            } catch (SQLException | NamingException ex) {
                System.err.println(ex);
            }
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("link.html").include(request, response);
            out.print("<font color=red>Please login first</font>");
            request.getRequestDispatcher("login.html").include(request, response);
            out.close();
        }
    }
}
