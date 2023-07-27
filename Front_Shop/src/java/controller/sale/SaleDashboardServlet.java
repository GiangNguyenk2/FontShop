/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.sale;

import dal.ComboDAO;
import dal.MktDAO;
import dal.ProductImageDAO;
import dal.SaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.ComboDetails;
import models.ComboList;
import models.ProductImage;

/**
 *
 * @author admin
 */
public class SaleDashboardServlet extends HttpServlet {
   
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
            out.println("<title>Servlet SaleDashboardServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaleDashboardServlet at " + request.getContextPath () + "</h1>");
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
        SaleDAO dao = new SaleDAO();
        int proID = dao.getIDTop1Product();
        ComboDAO combodao = new ComboDAO();
        ProductImageDAO daoPI = new ProductImageDAO();
        
        List<ComboList> listCombo = dao.getNewCombo();
        List<ComboDetails> listComboDetail = combodao.getComboDetail();
        List<ProductImage> listImg = new ArrayList<>();
        for (int i = 0; i < listComboDetail.size()-1; i++) {
            
            listImg.add(daoPI.getImageById(listComboDetail.get(i).getProID()));
            
        }
        request.setAttribute("listimg", listImg);
        request.setAttribute("combolist", listCombo);
        request.setAttribute("combodetail", listComboDetail);
        
        request.setAttribute("totalProduct", dao.getTotalOfProduct());
        request.setAttribute("totalOrder", dao.getTotalOfOrder());
        request.setAttribute("productTop1", dao.getProductByID(proID));
        request.setAttribute("imgTop1", dao.getImageById(proID));
        request.setAttribute("combo", dao.getTotalOfCombo());
        request.getRequestDispatcher("../view/Sale.jsp").forward(request, response);
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
        processRequest(request, response);
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
