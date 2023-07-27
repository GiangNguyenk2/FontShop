/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.history;

import dal.HistoryDAO;
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
import models.Address;
import models.Color;
import models.CustomerOrder;

import models.OrderInfo;
import models.Product;
import models.ProductImage;
import models.Size;

/**
 *
 * @author Asus
 */
public class OrderInformationServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderInformationServelet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderInformationServelet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HistoryDAO dao = new HistoryDAO();
        MktDAO dao2 = new MktDAO();
        List<Color> listColors = dao2.getAllColor();
        List<Size> listSizes = dao2.getAllSize();
        List<Product> listProduct = dao2.getAllProduct();
        List<ProductImage> list_img = new ArrayList<>();

        //lay anh
        ProductImageDAO pidb = new ProductImageDAO();
        for (int i = 0; i <= listProduct.size() - 1; i++) {
            list_img.add(pidb.getImageById(listProduct.get(i).getProID()));

        }

        try {
            int id = Integer.parseInt(request.getParameter("orID"));
            List<OrderInfo> listOrderDetail = dao.getOrderInfoByOrID(id);
            CustomerOrder cus = dao.getOrder(id);
            Address address = dao.getAddress(cus.getAddID());
            request.setAttribute("address", address);
            request.setAttribute("cusOrder", cus);
            request.setAttribute("orderDetail", listOrderDetail);

        } catch (Exception e) {
        }
        request.setAttribute("list_img", list_img);
        request.setAttribute("list_Size", listSizes);
        request.setAttribute("list_Color", listColors);
        request.getRequestDispatcher("../view/OrderInformation.jsp").forward(request, response);
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
        processRequest(request, response);
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
