/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bill.ProductBLL;
import entity.Product;
import java.io.IOException;
import java.net.URLDecoder;
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
@WebServlet(urlPatterns = { "/promotion" })
public class PromotionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String decode = request.getParameter("promotion");
        ProductBLL dao = new ProductBLL();
        List<Product> list = dao.getPromotion(decode);
        request.setAttribute("PromotionList", list);
        
        RequestDispatcher view = request.getRequestDispatcher("promotion.jsp");
        view.forward(request, response);
    }

}
