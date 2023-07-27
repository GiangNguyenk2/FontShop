/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.marketing;

import dal.MktDAO;
import dal.ProductImageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.Color;
import models.Product;
import models.ProductImage;
import models.Size;
import models.Stock;
import utlis.GetParam;

/**
 *
 * @author dinhd513
 */
public class UpdateStockServlet extends HttpServlet {

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
        Integer quantity = GetParam.getIntParams(request, "quantity", "Quantity", 0, Integer.MAX_VALUE, null);
        if (quantity == null) {
            return false;

        } else {
            return true;
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
        MktDAO dao = new MktDAO();
        ProductImageDAO pidb = new ProductImageDAO();

        try {
            int proID = Integer.parseInt(request.getParameter("proID"));
            int sizeID = Integer.parseInt(request.getParameter("sizeID"));
            int colorID = Integer.parseInt(request.getParameter("colorID"));
            Product product = dao.getProduct(proID);
            request.setAttribute("product", product);
            List<Stock> list_Stock = dao.getStock(proID);
            request.setAttribute("list_Stock", list_Stock);
            Stock stock = dao.findStock(proID, sizeID, colorID);
            request.setAttribute("stock", stock);

        } catch (Exception e) {
        }

        List<Color> listColors = dao.getAllColor();
        List<Size> listSizes = dao.getAllSize();
        request.setAttribute("list_Size", listSizes);
        request.setAttribute("list_Color", listColors);
        List<ProductImage> list_img = new ArrayList<>();
        List<Product> listProduct1 = dao.getAllProduct();
        for (int i = 0; i <= listProduct1.size() - 1; i++) {
            list_img.add(pidb.getImageById(listProduct1.get(i).getProID()));
        }
        List<Color> list_Color = dao.getAllColor();
        List<Size> list_Size = dao.getAllSize();

        request.setAttribute("list_img", list_img);
        request.setAttribute("list_Size", list_Size);
        request.setAttribute("list_Color", list_Color);
        request.getRequestDispatcher("../view/UpdateStock.jsp").forward(request, response);
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
        MktDAO dao = new MktDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        if (processRequest(request, response)) {
            try {
                int stockID = Integer.parseInt(request.getParameter("stockID"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                dao.UpdateStock(stockID, quantity);
                if (quantity == 0) {
                    dao.UpdateStockStatus(stockID, false);  
                }else{
                     dao.UpdateStockStatus(stockID, true);  
                        }
            } catch (Exception e) {
            }
            request.setAttribute("mess", "Update Successful");
            this.doGet(request, response);
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
