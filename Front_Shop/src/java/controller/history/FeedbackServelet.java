/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.history;

import dal.HistoryDAO;
import dal.MktDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import models.Account;
import models.Color;
import models.CustomerFeedback;
import models.Size;

/**
 *
 * @author Asus
 */
public class FeedbackServelet extends HttpServlet {
   
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
            out.println("<title>Servlet FeedbackServelet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeedbackServelet at " + request.getContextPath () + "</h1>");
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
          MktDAO dao2 = new MktDAO();
        request.setAttribute("proID",request.getParameter("proID"));
        request.setAttribute("proName",request.getParameter("proName"));
        request.setAttribute("proSize",request.getParameter("proSize"));
        request.setAttribute("proColor",request.getParameter("proColor")); 
        List<Color> listColors = dao2.getAllColor();
        List<Size> listSizes = dao2.getAllSize();
        request.setAttribute("list_Size", listSizes);
        request.setAttribute("list_Color", listColors);
        request.getRequestDispatcher("Feedback.jsp").forward(request, response);
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
        
        try {
            int proID = Integer.parseInt(request.getParameter("proID"));
            String feedback = request.getParameter("info") +" "+ request.getParameter("message");
            int rate = Integer.parseInt(request.getParameter("star-radio"));
            
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("account");
            HistoryDAO dao = new HistoryDAO();
            CustomerFeedback find = dao.findFeedback(request.getParameter("info"), acc.getGmail());
            CustomerFeedback feedbackNew = new CustomerFeedback(proID, rate, feedback, acc.getGmail());
            if (find == null) {
                dao.addFeedback(proID, rate, feedback, acc.getGmail());
            }else{
                dao.updateFeedback(feedbackNew, request.getParameter("info"));
            }
            
        } catch (Exception e) {
        }
        request.getRequestDispatcher("customerOrder").forward(request, response);
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
