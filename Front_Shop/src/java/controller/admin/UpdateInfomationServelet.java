/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ShopInfo;
import org.apache.coyote.http11.Constants;
import utlis.GetParam;

/**
 *
 * @author Asus
 */
public class UpdateInfomationServelet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String address = GetParam.getStringParam(request, "address", "Address",
                "^[\\p{L}\\p{M}\\s\\S]{0,150}$", "Address needs to be greater than 10 and less than 150 characters in length", 10, 150, null);
        String gmail = GetParam.getStringParam(request, "gmail", "Gmail",
                "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "This is not gmail", 5, 50, null);
        String phone = GetParam.getStringParam(request, "phone", "phone", "(0)+([0-9]{9})", "This is not a phone number", 0, 10, null);
        
        String facebook = GetParam.getStringParam(request, "facebook", "Facebook",
                "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", "Link facebook required", 10, 150, null);
        if (gmail == null || phone == null || address == null || facebook == null) {
            return false;
        }
        return true;
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
       AdminDAO dao = new AdminDAO();

        ShopInfo info = dao.getAllInfo();
        request.setAttribute("info", info);
        request.getRequestDispatcher("../view/ShopInfo.jsp").forward(request, response);
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
        AdminDAO dao = new AdminDAO();
        if (processRequest(request, response)) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String facebook = request.getParameter("facebook");
            String gmail = request.getParameter("gmail");
            String phone = request.getParameter("phone");
            dao.UpdateInfo(address, facebook, gmail, phone, name);
            request.setAttribute("mess", "Update sucseccful!");
            this.doGet(request, response);
        } else {
            request.setAttribute("messFail", "Update failed!");
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
