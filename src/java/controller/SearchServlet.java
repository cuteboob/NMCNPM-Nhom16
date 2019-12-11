/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
public class SearchServlet extends HttpServlet {

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

        String search = request.getParameter("search");

        String query = "use SalesWebsite; select ProductID, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID and ProductName Like '%"+ search +"%';";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            List<Product> l = new ArrayList<Product>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                l.add(p);
            }
            conn.close();
            request.setAttribute("SearchList", l);
            request.getRequestDispatcher("search.jsp").include(request,response);
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        out.close();
    }
}
