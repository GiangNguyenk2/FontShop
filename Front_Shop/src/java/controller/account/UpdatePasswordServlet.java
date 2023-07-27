/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import dal.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utlis.GetParam;

/**
 *
 * @author dinhd513
 */
public class UpdatePasswordServlet extends HttpServlet {

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

        String password = GetParam.getStringParam(request, "newPassword", "New Password",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", "Minimum eight characters, at least one letter and one number", 8, 50, null);
        String rePassword = GetParam.getStringParam(request, "reNewPassword", "Re-enter Password",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", "Minimum eight characters, at least one letter and one number", 8, 50, null);

        return !(password == null | rePassword == null);

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
        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("Check");
        if (check.equals("false")) {
            response.sendRedirect("../view/error404.jsp");
        } else {
            request.setAttribute("inputCode", "none");
            request.setAttribute("inputGmail", "none");
            request.setAttribute("inputNewPassword", "block");

            request.getRequestDispatcher("../view/ForgotPassword.jsp").forward(request, response);
        }
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
        HttpSession session = request.getSession();

        if (processRequest(request, response)) {
            String gmail = (String) session.getAttribute("gmailToForgot");

            String pass = request.getParameter("newPassword");
            String repass = request.getParameter("reNewPassword");
            if (!repass.equals(pass)) {
                request.setAttribute("inputCode", "none");
                request.setAttribute("inputGmail", "none");
                request.setAttribute("inputNewPassword", "block");
                request.setAttribute("mess", "New password and re-enter the new password does not match");
                request.getRequestDispatcher("../view/ForgotPassword.jsp").forward(request, response);
            }
            AccountDAO dao = new AccountDAO();
            dao.setPasswordAccount(gmail, pass);
            request.setAttribute("mess", "New password has been updated");

            request.setAttribute("CheckVerify", "false");
            request.getRequestDispatcher("../view/Login.jsp").forward(request, response);
        } else {

            this.doGet(request, response);

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
