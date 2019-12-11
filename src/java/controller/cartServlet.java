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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet(urlPatterns = { "/cart" })
public class cartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String Cart = request.getParameter("Cart");
        HttpSession session = request.getSession();
        if (session.getAttribute("fullName")==null) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong>Vui lòng đăng nhập để đặt mua sản phẩm.\n" +
"  </div>");
            request.getRequestDispatcher("login.jsp").include(request,response);
        } else {
        String query = "SELECT * FROM Product, Promotion WHERE Product.PromotionID = Promotion.PromotionID and ProductID='"+Cart+"'";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            if (rs.next()) {
            if (session.getAttribute("Cart")==null) {
                if (rs.getInt("NumberInStorage")==0) {
                    out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Hiện trong kho không còn sản phẩm này, mời bạn lựa chọn sản phẩm khác.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                } else {
                    List<Product> list  = new ArrayList<Product>();
                    Product p = new Product();
                    p.setProductID(rs.getString("ProductID"));
                    p.setProductName(rs.getString("ProductName"));
                    p.setPrice(rs.getInt("Price"));
                    p.setSaleOff(rs.getFloat("SaleOff"));
                    p.setQuantity(1);
                    list.add(p);
                    session.setAttribute("Cart", list);
                    out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Thêm sản phẩm vào giỏ hàng thành công.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                }
            } else {
                List<Product> listItems = (List<Product>) session.getAttribute("Cart");
                boolean check = true;
                boolean check1  =true;
                for (Product p: listItems) {
                    if (p.getProductID().equals(rs.getString("ProductID"))) {
                        if (p.getQuantity()<rs.getInt("NumberInStorage")) {
                            p.setQuantity(p.getQuantity()+1);
                        } else {
                            check1=false;
                        }
                        check=false;
                    }
                }
                if (check == false) {
                    if (check1==false) {
                    out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Hiện trong kho không còn sản phẩm này, mời bạn lựa chọn sản phẩm khác.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                    } else {
                    session.setAttribute("Cart", listItems);
                    out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Thêm sản phẩm vào giỏ hàng thành công.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                }
                } else {
                    if (rs.getInt("NumberInStorage")==0) {
                        out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Warning!</strong> Hiện trong kho không còn sản phẩm này, mời bạn lựa chọn sản phẩm khác.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                    } else {
                    Product p = new Product();
                    p.setProductID(rs.getString("ProductID"));
                    p.setProductName(rs.getString("ProductName"));
                    p.setPrice(rs.getInt("Price"));
                    p.setSaleOff(rs.getFloat("SaleOff"));
                    p.setQuantity(1);
                    listItems.add(p);
                    session.setAttribute("Cart", listItems);
                    out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Thêm sản phẩm vào giỏ hàng thành công.\n" +
"  </div>");
                    request.getRequestDispatcher("index.jsp").include(request,response);
                    }
                }
            }
            }
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
    }
}
}
