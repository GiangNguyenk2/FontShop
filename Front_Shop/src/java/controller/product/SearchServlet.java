/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import dal.CategoriesDAO;
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
import models.Categories;
import models.Product;
import models.ProductImage;
import models.Stock;

/**
 *
 * @author ACER
 */
public class SearchServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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
        StockDAO sdb = new StockDAO();
        CategoriesDAO cdb = new CategoriesDAO();
        ProductDAO pdb = new ProductDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        List<Categories> list = cdb.getAll();
        List<ProductImage> list_img = new ArrayList<>();
        //lay key
        String key = request.getParameter("search");
        request.setAttribute("key", key);
        //lay sort
        String sort = request.getParameter("sort");
        sort = sort == null ? "new" : sort;
        request.setAttribute("sort_list", sort);
        //lay caid
        String caId = request.getParameter("caID");
        request.setAttribute("caID", caId);
        //lay page
        String xpage = request.getParameter("page");
        //sort gia theo tung category
        int ca, page;
        List<Product> listpage = new ArrayList<>();
        try {
            ca = (caId == null) ? 0 : Integer.parseInt(caId);
            if (xpage == null) {
                page = 1;
            } else {
                page = Integer.parseInt(xpage);
            }
            listpage = pdb.search(key, page);
//            if (sort.equals("new")) {
//                listpage = pdb.getListByPageNew(page, ca);
//                request.setAttribute("listpage", listpage);
//            } else if (sort.equals("low")) {
//                listpage = pdb.getListByPageASC(page, ca);
//                request.setAttribute("listpage", listpage);
//            } else if (sort.equals("high")) {
//                listpage = pdb.getListByPageDESC(page, ca);
//                request.setAttribute("listpage", listpage);
//            }
            int size = pdb.getMaxIndexSearch(key);
            int num = (size % 6 == 0 ? (size / 6) : ((size / 6) + 1));
            request.setAttribute("page", page);
            request.setAttribute("list", list);
            request.setAttribute("num", num);
            request.setAttribute("size", size);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        //lay anh
        for (int i = 0; i < listpage.size(); i++) {
            list_img.add(pidb.getImageById(listpage.get(i).getProID()));
        }
        List<Stock> list_stock = sdb.getStockForShopAll(listpage);
        request.setAttribute("list_stock", list_stock);
        request.setAttribute("listpage", listpage);
        request.setAttribute("list_img", list_img);
        request.getRequestDispatcher("../view/search.jsp").forward(request, response);
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
