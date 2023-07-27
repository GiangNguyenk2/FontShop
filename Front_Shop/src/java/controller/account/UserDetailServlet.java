/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.account;

import dal.AccountDAO;
import dal.OrderDAO;
import helper.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Account;

/**
 *
 * @author admin
 */
public class UserDetailServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDetailServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserDetailServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String gmail = request.getParameter("gmail");
        AccountDAO dao = new AccountDAO();
        OrderDAO or = new OrderDAO();
        Account acc = new Account();
        acc = dao.getAccountByGmail(gmail);
        String status = String.valueOf(acc.isAccStatus());
        int done=or.getOrderDoneByGmail(gmail);
        int cancel = or.getOrderCancelByGmail(gmail);
        int money = or.getTotalMoneyDone(gmail);
        request.setAttribute("done", done);
        request.setAttribute("cancel", cancel);
        request.setAttribute("money", money);
        request.setAttribute("acc", acc);
        request.setAttribute("status", status);
        request.getRequestDispatcher("../view/UserDetail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AccountDAO acc = new AccountDAO();
        String gmail = request.getParameter("gmail");
        if(request.getParameter("block")!=null){
            String reason = request.getParameter("reason");
            acc.setStatusAccount(gmail, false);
            SendMail send = new SendMail();
            send.SendGmail(gmail, "Block User", "Because of "+reason+" your account has been blocked");
            this.doGet(request, response);
        }
        
        if(request.getParameter("unblock")!=null){
            acc.setStatusAccount(gmail, true);
            SendMail send = new SendMail();
            send.SendGmail(gmail, "Unblock", "We apologize for this inconvenience. Your account has been Unblock");
            this.doGet(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
