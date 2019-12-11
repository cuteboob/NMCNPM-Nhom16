/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminController;

import bill.ProductBLL;
import entity.Member;
import entity.Order;
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
@WebServlet(urlPatterns = { "/admin/manager" })
public class manager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ProductBLL dao = new ProductBLL();
        
        List<Member> list = dao.getMember();
        
        request.setAttribute("List", list);
       
        request.getRequestDispatcher("manager.jsp").include(request,response);
    }

}

