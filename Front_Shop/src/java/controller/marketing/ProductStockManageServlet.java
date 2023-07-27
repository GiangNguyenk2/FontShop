/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.marketing;

import dal.CategoriesDAO;
import dal.MktDAO;
import dal.ProductDAO;
import dal.ProductImageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.Categories;
import models.Color;
import models.Product;
import models.ProductImage;
import models.Size;
import models.Stock;

/**
 *
 * @author dinhd513
 */
public class ProductStockManageServlet extends HttpServlet {

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
        String choose = request.getParameter("list");
        request.setAttribute("list", choose);
        if (choose.equals("product")) {
            ProductDAO pdb = new ProductDAO();
            // tao list
            List<Product> listProduct = dao.getAllProduct();
            List<ProductImage> list_img = new ArrayList<>();
            ProductImageDAO pidb = new ProductImageDAO();
            CategoriesDAO cdb = new CategoriesDAO();

            List<Categories> list_Ca = cdb.getAll();
            request.setAttribute("listCa", list_Ca);

            // get img
            for (int i = 0; i <= listProduct.size()-1; i++) {
                list_img.add(pidb.getImageById(listProduct.get(i).getProID()));
            }

            //get caID
            String caId = request.getParameter("caID");
            request.setAttribute("caID", caId);
            // get sort
            String sort = request.getParameter("sort");
            request.setAttribute("sort_list", sort);

            int ca;

            List<Product> listpage = new ArrayList<>();
            try {
                ca = (caId == null || "".equals(caId)) ? 0 : Integer.parseInt(caId);
                String indexPage = request.getParameter("index");
                if (indexPage == null) {
                    indexPage = "1";
                }

                int index = Integer.parseInt(indexPage);
                if (index == 0) {
                    index = 1;
                }

                if (sort.equals("new")) {
                    listpage = pdb.getListByPageNew(index, ca);
                    request.setAttribute("listpage", listpage);
                } else if (sort.equals("low")) {
                    listpage = pdb.getListByPageASC(index, ca);
                    request.setAttribute("listpage", listpage);
                } else if (sort.equals("high")) {
                    listpage = pdb.getListByPageDESC(index, ca);
                    request.setAttribute("listpage", listpage);
                }
                int total = pdb.getMaxIndex(ca);
                int endPage = (total % 6 == 0 ? (total / 6) : ((total / 6) + 1));

                if (index >= endPage) {
                    index = endPage;
                }
                request.setAttribute("endPage", endPage);
                request.setAttribute("indexNow", index);

                request.setAttribute("listProduct", listpage);

            } catch (NumberFormatException e) {
                System.out.println(e);
            }

            request.setAttribute("list_img", list_img);
            request.setAttribute("list_Category", list_Ca);

            request.setAttribute("listS", "none");
            request.setAttribute("paging2", "none");
            request.setAttribute("none3", "none");
            request.setAttribute("none4", "none");
            request.getRequestDispatcher("../view/StockManage.jsp").forward(request, response);
        } else {//-------------------------------------------------------------------------------------
            
            
            List<Color> listColors = dao.getAllColor();
            List<Size> listSizes = dao.getAllSize();
            List<Product> listProduct = dao.getAllProduct();
            List<ProductImage> list_img = new ArrayList<>();

            
            //lay anh

            ProductImageDAO pidb = new ProductImageDAO();
            for (int i = 0; i <= listProduct.size()-1; i++) {
                list_img.add(pidb.getImageById(listProduct.get(i).getProID()));

            }

            //get sizeID
            String sizeID = request.getParameter("sizeID");
            request.setAttribute("sizeID", sizeID);
            
            // get sort
            String sort = request.getParameter("sort");
            request.setAttribute("sort_list", sort);

            int size;

            List<Stock> listpage = new ArrayList<>();
            try {
                size = (sizeID == null || "".equals(sizeID)) ? 0 : Integer.parseInt(sizeID);
                String indexPage = request.getParameter("index");
                if (indexPage == null) {
                    indexPage = "1";
                }

                int index = Integer.parseInt(indexPage);
                if (index == 0) {
                    index = 1;
                }

                switch (sort) {
                    case "new":
                        listpage = dao.getStockBySizePageNomal(index, size);
                        
                        break;
                    case "low":
                        listpage = dao.getStockBySizePageASC(index, size);
                       
                        break;
                    case "high":
                        listpage = dao.getStockBySizePageDESC(index, size);
                        
                        break;
                    default:
                        break;
                }
                int total = dao.getMaxIndexSize(size);
                int endPage = (total % 10 == 0 ? (total / 10) : ((total / 10) + 1));

                if (index >= endPage) {
                    index = endPage;
                }
                request.setAttribute("endPage", endPage);
                request.setAttribute("indexNow", index);
                request.setAttribute("listStock", listpage);
                

            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            String txt =null;
            request.setAttribute("txt", txt);
            request.setAttribute("list_img", list_img);
            request.setAttribute("list_Pro", listProduct);
            request.setAttribute("list_Size", listSizes);
            request.setAttribute("list_Color", listColors);
            request.setAttribute("sizeID", sizeID);
            request.setAttribute("listP", "none");
            request.setAttribute("none1", "none");
            request.setAttribute("none3", "none");
            request.setAttribute("none4", "none");
            request.getRequestDispatcher("../view/StockManage.jsp").forward(request, response);
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
