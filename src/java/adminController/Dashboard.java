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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.sql.DataSource;

/**
 *
 * @author PV
 */
@WebServlet(urlPatterns = { "/admin/dashboard" })
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String query = "select count(OrderID) from [Order]";   
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();   
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("sumOrder", str);
            }
            rs.close();
            query = "select sum(Quantity) from Order__Product";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("sumLaptop", str);
            }
            rs.close();
            query = "select count(DISTINCT [Order].OrderID) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(GETDATE())\n" +
"and Day(Time) = Day(Getdate())\n" +
"and month(time) = month(getdate())";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("sumOrderInDay", str);
            }
            rs.close();
            query = "select sum(Quantity) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(GETDATE())\n" +
"and Day(Time) = Day(Getdate())\n" +
"and month(time) = month(getdate())";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String str = rs.getString(1);
                if (str==null) {
                    str="0";
                }
                request.setAttribute("sumLaptopInDay", str);
            }
            rs.close();
            query = "select top 3 company, sum(Quantity) from Product, Order__Product\n" +
"where Product.ProductID = Order__Product.ProductID\n" +
"group by company\n" +
"order by sum(Quantity) desc";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("top1Company", str);
                int b = rs.getInt(2);
                request.setAttribute("top1Quantity", b);
            }
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("top2Company", str);
                int b = rs.getInt(2);
                request.setAttribute("top2Quantity", b);
            }
            if (rs.next()) {
                String str = rs.getString(1);
                request.setAttribute("top3Company", str);
                int b = rs.getInt(2);
                request.setAttribute("top3Quantity", b);
            }
            rs.close();
            
            //_________________________
            //Hôm nay
            query = "select sum(Quantity), Day(Getdate()), month(getdate()) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(GETDATE())\n" +
"and Day(Time) = Day(Getdate())\n" +
"and month(time) = month(getdate())";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("today", str);
                request.setAttribute("day0", a);
            }
            rs.close();
            // Hôm qua
            query = "select sum(Quantity), Day(dateadd(day,-1, getdate())), month(dateadd(day,-1, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-1, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-1, getdate()))\n" +
"and month(time) = month(dateadd(day,-1, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
       //         System.out.println("Str: "+str);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day1", a);
                request.setAttribute("dayago1", str);
            }
            rs.close();
            // 2 ngày trước
            query = "select sum(Quantity), Day(dateadd(day,-2, getdate())), month(dateadd(day,-2, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-2, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-2, getdate()))\n" +
"and month(time) = month(dateadd(day,-2, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day2", a);
                request.setAttribute("dayago2", str);
            }
            rs.close();
            // 3 ngày trước
            query = "select sum(Quantity), Day(dateadd(day,-3, getdate())), month(dateadd(day,-3, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-3, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-3, getdate()))\n" +
"and month(time) = month(dateadd(day,-3, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day3", a);
                request.setAttribute("dayago3", str);
            }
            rs.close();
            // 4 ngày trước
            query = "select sum(Quantity), Day(dateadd(day,-4, getdate())), month(dateadd(day,-4, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-4, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-4, getdate()))\n" +
"and month(time) = month(dateadd(day,-4, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day4", a);
                request.setAttribute("dayago4", str);
            }
            rs.close();
            // 5 ngày trước
            query = "select sum(Quantity), Day(dateadd(day,-5, getdate())), month(dateadd(day,-5, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-5, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-5, getdate()))\n" +
"and month(time) = month(dateadd(day,-5, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day5", a);
                request.setAttribute("dayago5", str);
            }
            rs.close();
            // 6 ngày trước
            query = "select sum(Quantity), Day(dateadd(day,-6, getdate())), month(dateadd(day,-6, getdate())) from [Order], Order__Product\n" +
"where [Order].OrderID = Order__Product.OrderID\n" +
"and YEAR(Time) = YEAR(dateadd(day,-6, getdate()))\n" +
"and Day(Time) = Day(dateadd(day,-6, getdate()))\n" +
"and month(time) = month(dateadd(day,-6, getdate()))";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int str = rs.getInt(1);
                String a = rs.getString(2)+"/"+rs.getString(3);
                request.setAttribute("day6", a);
                request.setAttribute("dayago6", str);
            }
            rs.close();
            //_________________________
            
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        
        request.getRequestDispatcher("dashboard.jsp").include(request, response);
        out.close();
    }

}

