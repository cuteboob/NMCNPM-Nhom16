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
@WebServlet(urlPatterns = { "/admin/ChangeProduct" })
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)
public class changeProduct extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ProductID = request.getParameter("ProductID");
        String ProductName = request.getParameter("ProductName");
//        String ImageProduct = request.getParameter("ImageProdct");
        String fileName = "";
        
        String newStr = "";
    for(Part part : request.getParts()){
        if (part.getName().equals("ImageProduct")) {
       Collection<String> headers = part.getHeaders("content-disposition");
       if (headers == null)
           continue;
       for(String header : headers){
            newStr=header;                  
        } 
    }
        
        
    }
    int dem = 0;
    for (int i=0;i<newStr.length();i++) {
            if (dem==3) fileName+= newStr.charAt(i);
            if (newStr.charAt(i)=='\"') dem++;
        }
    fileName = fileName.substring(0, fileName.length()-1);
        String Quantity = request.getParameter("Quantity");
        String Price = request.getParameter("Price");;
        String Sale = request.getParameter("Sale");
        String Detail = request.getParameter("Detail");
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
        query = "INSERT INTO Product VALUES (N'" + ProductID + "',N'" + fileName + "',N'" + Price + "',N'" + Quantity + "',N'" + Detail + "',N'" + Sale + "',N'" + ProductName + "', N'" + Company + "')";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(query);
            if (rs==1) {
                out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center ; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Success!</strong> Đã thêm một sản phẩm mới.\n" +
"  </div>");
                request.getRequestDispatcher("new-product.jsp").include(request, response);
            } else {
                out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Warning!</strong> Đã tồn tại sản phẩm có cùng mã.\n" +
"  </div>");
            request.getRequestDispatcher("new-product.jsp").include(request, response);
            }
            conn.close();
        } catch (SQLException | NamingException ex) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Warning!</strong> Đã tồn tại sản phẩm có cùng mã.\n" +
"  </div>");
            request.getRequestDispatcher("new-product.jsp").include(request, response);
            System.err.println(ex);
        }
        out.close();
    }
    

}

