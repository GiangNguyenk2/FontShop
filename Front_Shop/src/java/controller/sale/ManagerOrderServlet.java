/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.sale;

import dal.OrderDAO;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Order;
import models.Status;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ACER
 */
public class ManagerOrderServlet extends HttpServlet {

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
            out.println("<title>Servlet ManagerOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerOrderServlet at " + request.getContextPath() + "</h1>");
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

        //get parameter
        String page_raw = request.getParameter("page");
        String table = request.getParameter("table");
        String filter = request.getParameter("filter");
        //tao list 
        List<Order> list_order = new ArrayList<>();
        List<Status> list_status = new ArrayList<>();
        int page;
        try {
            page = Integer.parseInt(page_raw);
            list_order = odb.getOrder(page, table, filter);
            list_status = odb.getNameStatus();
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        int num = (list_order.size() % 12 == 0 ? (list_order.size() / 6) : ((list_order.size() / 6) + 1));
        
        request.setAttribute("table", table);
        request.setAttribute("index", num);
        request.setAttribute("size", list_order.size());
        request.setAttribute("filter", filter);
        request.setAttribute("page", page_raw);
        request.setAttribute("list_order", list_order);
        request.setAttribute("list_status", list_status);
        request.getRequestDispatcher("/view/Order.jsp").forward(request, response);
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
        String page_raw = request.getParameter("page");
        String table = request.getParameter("table");
        String filter = request.getParameter("filter");
        String sdate = request.getParameter("startDate");
        String edate = request.getParameter("endDate");
        String excel = request.getParameter("excel");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int page;
        List<Order> list_order_date = new ArrayList<>();

            try {

                java.util.Date startDateUtil = dateFormat.parse(sdate);
                java.util.Date endDateUtil = dateFormat.parse(edate);
                // Chuyển đổi java.util.Date sang java.sql.Date
                Date startDate = new Date(startDateUtil.getTime());
                Date endDate = new Date(endDateUtil.getTime());
                page = page_raw == null ? 1 : Integer.parseInt(page_raw);
                if (sdate.compareTo(edate) > 0) {
                    request.setAttribute("error1", "The start date must be less than the end date.");

                }  
                list_order_date = odb.getOrderByDate(table, startDate, endDate, page);

                List<Status> list_status = new ArrayList<>();
                try {

                    list_status = odb.getNameStatus();
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                request.setAttribute("table", table);
                request.setAttribute("size", list_order_date.size());
                request.setAttribute("filter", filter);
                request.setAttribute("page", page_raw);
                request.setAttribute("list_order_date", list_order_date);
                request.setAttribute("list_status", list_status);
            } catch (NumberFormatException | ParseException e) {
                System.out.println(e);
            }
            request.getRequestDispatcher("/view/Order.jsp").forward(request, response);
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
