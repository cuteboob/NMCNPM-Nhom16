/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import bill.ProductBLL;
import entity.Product;
import java.io.IOException;
import java.io.PipedWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PV
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet{    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ProductBLL productBLL = new ProductBLL();
        getServletContext().setAttribute("slideProduct", productBLL.getNewProducts(3));
        getServletContext().setAttribute("newCopany", productBLL.getNewCompany());
        getServletContext().setAttribute("newPromotion", productBLL.getNewPromotion());
        getServletContext().setAttribute("homeProduct", productBLL.getNewProducts(6));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
