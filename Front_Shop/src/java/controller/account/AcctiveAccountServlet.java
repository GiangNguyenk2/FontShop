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

/**
 *
 * @author dinhd513
 */
public class AcctiveAccountServlet extends HttpServlet {

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
        AccountDAO dao = new AccountDAO();
        HttpSession session = request.getSession();
        String gmail = (String) session.getAttribute("gmail");
        String code = (String) session.getAttribute("code");

        String realCode = request.getParameter("verifyCode");

        if (realCode.equals(code)) {
            return true;

        }
        return false;
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
        if (processRequest(request, response)) {
            AccountDAO dao = new AccountDAO();
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            String gmail = (String) session.getAttribute("gmail");
            String password = (String) session.getAttribute("password");
            String gender = (String) session.getAttribute("gender");
            boolean isgender;
            if (gender.equalsIgnoreCase("1")) {
                isgender = true;

            } else {
                isgender = false;
            }
            dao.AddAccount(gmail, password, name, isgender, 4, true);
            response.sendRedirect("../view/Login.jsp");
        } else {
            request.setAttribute("mess", "Your verification code is wrong");
            request.getRequestDispatcher("../view/VerificationEmail.jsp").forward(request, response);
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
