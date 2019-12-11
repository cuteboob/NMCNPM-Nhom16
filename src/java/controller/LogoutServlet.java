/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duc
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        out.print("<div class=\"alert alert-success alert-dismissible\" style=\"\n" +
"    text-align: center\">\n" +
"    \n" +
"    <strong>Success!</strong> Đăng xuất thành công.\n" +
"  </div>");
        request.getRequestDispatcher("index.jsp").include(request,response);
    }
}
