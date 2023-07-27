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
import utlis.GetParam;

/**
 *
 * @author admin
 */
public class UpdateAddress extends HttpServlet {
   
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
        String phone = GetParam.getStringParam(request, "phone","phone","(0)+([0-9]{9})","wrong number",0,10, null);
        if(phone==null){
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
         if(processRequest(request, response)){
        AccountDAO dao = new AccountDAO();
        String id = request.getParameter("ID");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city"+id);
        String district = request.getParameter("district"+id);
        String ward = request.getParameter("ward"+id);
        String diachi = request.getParameter("diachi");
        dao.updateAddress(phone,city,district,ward,diachi ,id);
        request.setAttribute("mess", "update sucseccful!");
        request.getRequestDispatcher("../view/updateProfile").forward(request, response);
        }
        else{
            request.setAttribute("mess", "wrong number phone!");
            request.getRequestDispatcher("../view/updateProfile").forward(request, response);
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
