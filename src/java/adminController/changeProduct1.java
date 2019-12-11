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
import java.util.Collection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 *
 * @author duc
 */
@WebServlet(urlPatterns = { "/admin/ChangeProduct1" })
public class changeProduct1 extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ProductID = request.getParameter("ProductID");
        String ProductID1 = request.getParameter("ProductID1");
        String ProductName = request.getParameter("ProductName");
        String Quantity = request.getParameter("Quantity");
        String Price = request.getParameter("Price");
        String Sale = request.getParameter("Sale");
        String Company = request.getParameter("Company");
        String query = "select * from Promotion where SaleOff='"+Sale+"';";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Sale = rs.getString("PromotionID");
            }
            rs.close();
        }
            catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
//        String ProductID = request.getParameter("ProductID");
//        String ProductID1 = request.getParameter("ProductID1");
//        String ProductName = request.getParameter("ProductName");
//        String Quantity = request.getParameter("Quantity");
//        String Price = request.getParameter("Price");;
//        String Sale = request.getParameter("Sale");
//        String Company = request.getParameter("Company");
        query = "update product set ProductID = N'"+ProductID1+"', ProductName = N'"+ProductName+"', NumberInStorage='"+Quantity+"', Price='"+Price+"', PromotionID='"+Sale+"', Company='"+Company+"' where ProductID = N'"+ProductID+"'";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);
            
                out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center ; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Success!</strong> Đã sửa thông tin sản phẩm.\n" +
"  </div>");
            conn.close();
            int a = 1;
            request.setAttribute("kiemtra", a);
            response.sendRedirect("http://localhost:8080/NMCNPM-Nhom16/admin/detail-product?ProductID="+ProductID);

        } catch (SQLException | NamingException ex) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Warning!</strong> Không thể sửa thông tin sản phẩm.\n" +
"  </div>");
            int b = 2;
            request.setAttribute("kiemtra", b);
            response.sendRedirect("http://localhost:8080/NMCNPM-Nhom16/admin/detail-product?ProductID="+ProductID);
            System.err.println(ex);
        }
        out.close();
    }
    

}

