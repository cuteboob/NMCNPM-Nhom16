/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminController;

import bill.ProductBLL;
import entity.Product;
import java.io.IOException;
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
@WebServlet(urlPatterns = { "/admin/product" })
public class addProduct extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductBLL dao = new ProductBLL();
        List<Product> list = dao.getCompany();
        request.setAttribute("List", list);
        RequestDispatcher view = request.getRequestDispatcher("product.jsp");
        view.forward(request, response);
    }

}
