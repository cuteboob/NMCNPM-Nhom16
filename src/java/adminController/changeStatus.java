/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminController;

import bill.ProductBLL;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author PV
 */
@WebServlet(urlPatterns = { "/admin/change-status" })
public class changeStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String UserName = request.getParameter("UserName");
        
        String query = "Update Manager_Member set [Status] = ([Status]-1)where UserName='"+UserName+"'";   
        
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);
            response.sendRedirect("http://localhost:8080/NMCNPM-Nhom16/admin/manager");
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        out.close();
    }
}

