/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.combo;

import dal.ComboDAO;
import dal.ProductDAO;
import dal.ProductImageDAO;
import dal.StockDAO;
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
import models.Product;
import models.ProductImage;
import models.Stock;

/**
 *
 * @author Asus
 */
public class ComboListServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ComboListServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComboListServlet at " + request.getContextPath () + "</h1>");
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
        ComboDAO dao = new ComboDAO();
        ProductDAO pdb = new ProductDAO();
         StockDAO sdb = new StockDAO();
        ProductImageDAO daoPI = new ProductImageDAO();
        
        List<ComboList> listCombo = dao.getCombo();
        List<ComboDetails> listComboDetail = dao.getComboDetail();
        List<ProductImage> listImg = new ArrayList<>();
        for (int i = 0; i < listComboDetail.size()-1; i++) {
            
            listImg.add(daoPI.getImageById(listComboDetail.get(i).getProID()));
            
        }
        List<Product> listpage = new ArrayList<>();
        for(int j = 0; j < listComboDetail.size()-1; j++){
            listpage.add(pdb.getProductByID(listComboDetail.get(j).getProID()));
        }
        
        List<Stock> list_stock = sdb.getStockForShopAll(listpage);
        request.setAttribute("list_stock", list_stock);
        request.setAttribute("listimg", listImg);
        request.setAttribute("combolist", listCombo);
        request.setAttribute("combodetail", listComboDetail);
        request.getRequestDispatcher("../view/ComboList.jsp").forward(request, response);
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
