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
@WebServlet(urlPatterns = { "/admin/deleteProduct" })
public class deleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ProductID = request.getParameter("ProductID");
       
        String query = "Delete from [Order__Product]\n" +
"where [Order__Product].ProductID = '"+ProductID+"'\n" +
"Delete from [Product]\n" +
"where [Product].ProductID = '"+ProductID+"'";   
        
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);
//            out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
//"    text-align: center ; margin-bottom: 0px;\">\n" +
//"    \n" +
//"    <strong>Success!</strong> Đã xóa sản phẩm.\n" +
//"  </div>");
            request.getRequestDispatcher("product").include(request, response);
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        out.close();
    }
}

