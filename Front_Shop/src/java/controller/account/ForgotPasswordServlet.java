/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import dal.AccountDAO;
import helper.GetRandom;
import helper.SendMail;
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
public class ForgotPasswordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String gmail = GetParam.getStringParam(request, "gmailToForgot", "Gmail",
                "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "This is not gmail", 5, 50, null);

        AccountDAO dao = new AccountDAO();
        Account acc = dao.searchAccByID(gmail);
        if (acc != null && gmail != null) {
            HttpSession session = request.getSession();
            session.setAttribute("gmailToForgot", gmail);
           session.setAttribute("Check", "false");
            GetRandom getRandom = new GetRandom();
            String code = getRandom.generateRandomNumber(5);
            session.setAttribute("codeToVerify", code); 
            session.setMaxInactiveInterval(200);
            String subject = "Verification Email";
            String text = "Hello\n"
                    + "\n"
                    + "You have just requested a password reset for your account on the Front page.\n"
                    + "Below is the verification code that the requester is you\n " + code + "\n"
                    + "\n"
                    + "\n"
                    + "Kind Regards, Front";
            SendMail send = new SendMail();
            send.SendGmail(gmail, subject, text);
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
        request.setAttribute("mess", "Your gmail is not esist");
        request.getRequestDispatcher("../view/ForgotPassword.jsp").forward(request, response);
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
        if (processRequest(request, response) == true) {


            request.setAttribute("mess", "Verification code has been sent to your email");
            request.setAttribute("inputCode", "block");
            request.setAttribute("inputGmail", "none");
            request.setAttribute("inputNewPassword", "none");
            request.getRequestDispatcher("../view/ForgotPassword.jsp").forward(request, response);
        }
        this.doGet(request, response);
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
