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
 * @author admin
 */
public class ChangePasswordServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("account");

        String oldPass = request.getParameter("oldpass");
        if(acc.getPassword().equals(oldPass)){
            return true;
        }
        else{
            return false;
        }
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
        String oldPass = request.getParameter("oldpass");
        String newPass = request.getParameter("newpass");
        String rePass = request.getParameter("repass");
        //request.setAttribute("oldpass", oldPass);
        //request.setAttribute("newpass", newPass);
        //request.setAttribute("repass", rePass);
        request.getRequestDispatcher("../view/ChangePassword.jsp").forward(request, response);
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
        Account acc = (Account) session.getAttribute("account");
        AccountDAO dao = new AccountDAO();
        if (!processRequest(request, response)) {
            request.setAttribute("mess", "Wrong old Password");
            this.doGet(request, response);
        }
        
        String newPass = GetParam.getStringParam(request, "newpass", "New Password",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", "Minimum eight characters, at least one letter and one number", 8, 50, null);
        if(newPass == null){
            //request.setAttribute("mess", "Wrong New Password");
            this.doGet(request, response);
        }
        
        String rePass = request.getParameter("repass");
        
        if(newPass.equals(rePass)){
            dao.changePassword(acc.getGmail(), newPass);
            request.setAttribute("mess", "Change Password Successful");
            request.getRequestDispatcher("../view/ChangePassword.jsp").forward(request, response);
        }
        else{
            request.setAttribute("mess", "New Password not equal Re Password");
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
