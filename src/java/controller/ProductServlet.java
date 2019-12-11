/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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
@WebServlet(urlPatterns = { "/product" })
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 9;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ProductBLL dao = new ProductBLL();
        List<Product> list = dao.viewAllProducts((page-1)*recordsPerPage+1, recordsPerPage);
    
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        request.setAttribute("productList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        
        RequestDispatcher view = request.getRequestDispatcher("product.jsp");
        view.forward(request, response);
    }

}

