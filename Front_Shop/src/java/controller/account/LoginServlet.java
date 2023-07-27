/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Account;
import utlis.GetParam;

/**
 *
 * @author dinhd513
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String gmail = GetParam.getStringParam(request, "gmail", "Gmail",
                "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "This is not gmail", 5, 50, null);
         
        if (gmail == null) {
            return false;
        }

        return true;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/Login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!processRequest(request, response)) {
            this.doGet(request, response);
        }
        String id = request.getParameter("gmail");
        String pass = request.getParameter("password");

        AccountDAO dao = new AccountDAO();
        Account acc = dao.login(id, pass);
        if (acc == null) {
            request.setAttribute("mess", "Wrong gmail or password");
            this.doGet(request, response);
        } else {
            HttpSession session = request.getSession();
            if (acc.isAccStatus()) {
                session.setAttribute("account", acc);
                if (acc.getRoleID() == 1) {
                    response.sendRedirect("../view/AdminDashboard?table=product");
                }
                if (acc.getRoleID() == 2) {
                    response.sendRedirect("../view/marketingDashboard?table=product");
                }
                if (acc.getRoleID() == 3) {
                    response.sendRedirect("../view/saleDashboard");
                }
                if (acc.getRoleID() == 4) {
                    response.sendRedirect("../view/Home");
                }
            }else{
                 request.setAttribute("mess", "Gmail is not active");
            this.doGet(request, response);
            } 
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
