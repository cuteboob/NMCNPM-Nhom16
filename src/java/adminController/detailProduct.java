/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminController;

import bill.ProductBLL;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PV
 */
@WebServlet(urlPatterns = { "/admin/detail-product" })
public class detailProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();

        String a = request.getParameter("ProductID");
        ProductBLL dao = new ProductBLL();
        Product p = dao.getInfoProduct(a);
        int kt;
        try {
        kt = (int) request.getAttribute("kiemtra");
        } catch (Exception e) {
          kt = 3;
        }
        request.setAttribute("Product", p);
        if (kt==1) {
            out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center ; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Success!</strong> Đã sửa thông tin sản phẩm.\n" +
"  </div>");
        } else if (kt==2) {
            out.print("<div class=\"alert alert alert-warning alert-dismissible\" style=\"\n" +
"    text-align: center; margin-bottom: 0px;\">\n" +
"    \n" +
"    <strong>Warning!</strong> Không thể sửa thông tin sản phẩm.\n" +
"  </div>");
        }
        request.getRequestDispatcher("detaul-product.jsp").include(request,response);
    }

}

