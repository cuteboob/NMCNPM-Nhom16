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
@WebServlet(urlPatterns = { "/admin/deleteOrder" })
public class deleteOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String OrderID = request.getParameter("OrderID");
       
        String query = "Delete from Order__Product\n" +
"where Order__Product.OrderID = '"+OrderID+"'\n" +
"Delete from [Order]\n" +
"where [Order].OrderID = '"+OrderID+"'";   
        
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);
            response.sendRedirect("http://localhost:8080/NMCNPM-Nhom16/admin/charts");
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        out.close();
    }
}

