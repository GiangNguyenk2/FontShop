/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.sale;

import dal.AccountDAO;
import dal.OrderDAO;
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
import models.Account;
import models.Address;
import models.Order;
import models.OrderDetail;
import models.Product;
import models.ProductImage;
import models.Status;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class OrderDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet OrderDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderDetailServlet at " + request.getContextPath() + "</h1>");
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
        OrderDAO odb = new OrderDAO();
        StockDAO sdb = new StockDAO();
        AccountDAO adb = new AccountDAO();
        ProductDAO pdb = new ProductDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        //get param
        String orID_raw = request.getParameter("orID");

        //lay du lieu tu database
        int orID;
        try {
            orID = Integer.parseInt(orID_raw);
            Order order = odb.getOrderByID(orID);
            Account acc = adb.searchAccByID(order.getGmail());
            Address add = odb.getAddressByID(order.getAddID());

            List<OrderDetail> list_order_detail = odb.getOrderDetailByID(orID);
            List<StockDetail> list_stock = sdb.getListStockByID(list_order_detail);
            //su li dia chi

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(add.getAddress() + " - ");
            stringBuilder.append(add.getWard() + " - ");
            stringBuilder.append(add.getDistrict() + " - ");
            stringBuilder.append(add.getCity() + " ");
            String address = stringBuilder.toString();

            //lay anh\
            List<ProductImage> list_img = new ArrayList<>();
            for (int i = 0; i < list_stock.size(); i++) {
                ProductImage p = pidb.getImageById(list_stock.get(i).getProID());
                list_img.add(p);
            }

            for (int i = 0; i < list_img.size(); i++) {
                for (int j = list_img.size() - 1; j > i; j--) {
                    if (list_img.get(i).getProID() == list_img.get(j).getProID()) {
                        list_img.remove(j);
                    }
                }
            }
            //lay status name
            Status status = odb.getNameStatusByID(order.getOrStatusID());
            List<Status> list_status = odb.getNameStatus();
            //lay product
            List<Product> list_product = new ArrayList<>();
            for (int i = 0; i < list_stock.size(); i++) {
                Product p = pdb.getProductByID(list_stock.get(i).getProID());
                list_product.add(p);
            }
            for (int i = 0; i < list_product.size(); i++) {
                for (int j = list_product.size() - 1; j > i; j--) {
                    if (list_product.get(i).getProID() == list_product.get(j).getProID()) {
                        list_product.remove(j);
                    }
                }
            }
            //====================
            request.setAttribute("order", order);
            request.setAttribute("address", address);
            request.setAttribute("status", status);
            request.setAttribute("acc", acc);
            request.setAttribute("add", add);
            request.setAttribute("size", list_order_detail.size());
            request.setAttribute("list_order_detail", list_order_detail);
            request.setAttribute("list_stock", list_stock);
            request.setAttribute("list_status", list_status);
            request.setAttribute("list_product", list_product);
            request.setAttribute("list_img", list_img);
            request.getRequestDispatcher("../view/OrderDetail.jsp").forward(request, response);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }

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
        OrderDAO odb = new OrderDAO();
        String statusID_raw = request.getParameter("status_order");
        String orID_raw = request.getParameter("orID");
        request.setAttribute("orID_post", orID_raw);
        int statusID=0;
        StockDAO sdb = new StockDAO();
        AccountDAO adb = new AccountDAO();
        ProductDAO pdb = new ProductDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        //get param
        
        int orID;
        //lay du lieu tu database
     
        try {
            statusID = Integer.parseInt(statusID_raw);
            orID = Integer.parseInt(orID_raw);
            Order order = odb.getOrderByID(orID);
            odb.updateStatusOrder(order,statusID);
            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        try {
            orID = Integer.parseInt(orID_raw);
            statusID = Integer.parseInt(statusID_raw);
            Order order = odb.getOrderByID(orID);
            Account acc = adb.searchAccByID(order.getGmail());
            Address add = odb.getAddressByID(order.getAddID());
            List<OrderDetail> list_order_detail = odb.getOrderDetailByID(orID);
            List<StockDetail> list_stock = sdb.getListStockByID(list_order_detail);
            //su li dia chi

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(add.getAddress() + " - ");
            stringBuilder.append(add.getWard() + " - ");
            stringBuilder.append(add.getDistrict() + " - ");
            stringBuilder.append(add.getCity() + " ");
            String address = stringBuilder.toString();

            //lay anh\
            List<ProductImage> list_img = new ArrayList<>();
            for (int i = 0; i < list_stock.size(); i++) {
                ProductImage p = pidb.getImageById(list_stock.get(i).getProID());
                list_img.add(p);
            }

            for (int i = 0; i < list_img.size(); i++) {
                for (int j = list_img.size() - 1; j > i; j--) {
                    if (list_img.get(i).getProID() == list_img.get(j).getProID()) {
                        list_img.remove(j);
                    }
                }
            }
            //lay status name
            Status status = odb.getNameStatusByID(order.getOrStatusID());
            List<Status> list_status = odb.getNameStatus();
            //lay product
            List<Product> list_product = new ArrayList<>();
            for (int i = 0; i < list_stock.size(); i++) {
                Product p = pdb.getProductByID(list_stock.get(i).getProID());
                list_product.add(p);
            }
            for (int i = 0; i < list_product.size(); i++) {
                for (int j = list_product.size() - 1; j > i; j--) {
                    if (list_product.get(i).getProID() == list_product.get(j).getProID()) {
                        list_product.remove(j);
                    }
                }
            }
            //====================
            //su li so luong
           
            request.setAttribute("order", order);
            request.setAttribute("address", address);
            request.setAttribute("status", status);
            request.setAttribute("acc", acc);
            request.setAttribute("add", add);
            request.setAttribute("size", list_order_detail.size());
            request.setAttribute("list_order_detail", list_order_detail);
            request.setAttribute("list_stock", list_stock);
            request.setAttribute("list_status", list_status);
            request.setAttribute("list_product", list_product);
            request.setAttribute("list_img", list_img);
             if(statusID==4){
                odb.updateStockByOrder(list_order_detail, list_stock);
                this.doGet(request, response);
            }else{
                  request.getRequestDispatcher("../view/OrderDetail.jsp").forward(request, response);
             }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
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
