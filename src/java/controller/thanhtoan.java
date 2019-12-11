/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bill.ProductBLL;
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
@WebServlet(urlPatterns = { "/thanhtoan" })
public class thanhtoan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        
        List<Product> listItems = (List<Product>) session.getAttribute("Cart");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        
        String OrderID = session.getAttribute("userName") + now.toString();
        String query = "INSERT INTO [Order] (OrderID, UserName, Time, Status) VALUES ('"+OrderID+"', '"+session.getAttribute("userName")+"', '"+now.toString()+"', "+"1); ";        
        for (Product p: listItems) {
            query += "INSERT INTO Order__Product (OrderID, ProductID, Quantity) VALUES ";
            query+="('"+OrderID+"', '"+p.getProductID()+"', "+p.getQuantity()+"); ";
//(19, ‘Anderson’, ‘Sarah’),
//(11, ‘Johnson’, ‘Dale’);
            query += "update Product set NumberInStorage = NumberInStorage-"+p.getQuantity()+" where ProductID = '"+p.getProductID()+"'; ";
        }
//        query = query.substring(0,query.length()-2);
//        query += ";";
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
"    <strong>Success!</strong> Thanh toán thành công.\n" +
"  </div>");
                request.getRequestDispatcher("index.jsp").include(request, response);
                session.setAttribute("Cart", null);
            }
            conn.close();
        } catch (SQLException | NamingException ex) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Thanh toán thất bại."+query+"\n" +
"  </div>");
            request.getRequestDispatcher("index.jsp").include(request, response);
            System.err.println(ex);
        }
        out.close();
    }
}

