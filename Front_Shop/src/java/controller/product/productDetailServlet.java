/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import dal.ColorDAO;
import dal.FeedbackDAO;
import dal.ProductDAO;
import dal.ProductImageDAO;
import dal.StockDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Cart;
import models.Color;
import models.FeedbackView;
import models.Item;
import models.Product;
import models.ProductImage;
import models.Stock;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class productDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet productDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productDetailServlet at " + request.getContextPath() + "</h1>");
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
        //Khai bao 
        ProductDAO pdb = new ProductDAO();
        StockDAO sdb = new StockDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        FeedbackDAO fdb = new FeedbackDAO();
        //get proID 
        String proId_raw = request.getParameter("proID");   
        String proColorID_raw = request.getParameter("colorID");
        request.setAttribute("coID", proColorID_raw);
        String Sizeid_raw = request.getParameter("sizeID");
        request.setAttribute("siID", Sizeid_raw);
        String quantity = request.getParameter("quantity");
        request.setAttribute("quantity_c", quantity);
        //}
        //Tao list
        int proId;
        int colorID;
        int sizeID;

        try {
            //parse
            proId = Integer.parseInt(proId_raw);
            colorID = Integer.parseInt(proColorID_raw);
            sizeID = Integer.parseInt(Sizeid_raw);
            //lay feedback
             List<FeedbackView> list_fb = fdb.getFeedbackProduct(proId);
            //lay anh
            List<ProductImage> list_img = pidb.getImageByProductId(proId);
            //lay product
            Product product = pdb.getProductByID(proId);
            //lay 4 product lien quan
            List<Product> list_4 = pdb.get4ProductByCategory(product.getCaID(), proId);
            //Sau do lay anh dau tien cua 4 san pham
            List<ProductImage> list_4_img = pidb.getListImageByProductId(list_4);
            //lay stock for shop all cũng như là cho product detail 
            List<Stock> list_stock_4 = sdb.getStockForShopAll(list_4);
            //lay 1 doi tuong anh
            ProductImage proImg = pidb.getImageById(proId);
            //lay size khi khong co cai mau
            List<StockDetail> size_default =  sdb.getSizeDefault(proId);
            for (int i = 0; i < size_default.size(); i++) {
                for (int j = 1; j < size_default.size(); j++) {
                    if (size_default.get(i).getProColorName().equals(size_default.get(j).getProColorName())) {
                        size_default.remove(j);
                    }
                }
            }
            //Lay quantity khi da co mau va size cua proId colorId sizeId
            StockDetail stock_quantity = sdb.getStockQuantity(proId, colorID, sizeID);
              
            //Lay san pham voi proID va colorId truyen vao
            List<StockDetail> list_stock = sdb.getStockProduct(proId, colorID);
            //lay stock cua tat ca san pham voi proID truyen vao
            List<StockDetail> list_stock_all = sdb.getStockProductAll(proId);

            //xu li mau 
            List<Color> list_color = new ArrayList<>();
            for (int i = 0; i < list_stock_all.size(); i++) {
                Color co = new Color();
                co.setProColorID(list_stock_all.get(i).getProColorID());
                co.setProColorName(list_stock_all.get(i).getProColorName());
                list_color.add(co);
            }

            for (int i = 0; i < list_color.size(); i++) {
                for (int j = 1; j < list_color.size(); j++) {
                    if (list_color.get(i).getProColorName().equals(list_color.get(j).getProColorName())) {
                        list_color.remove(j);
                    }
                }
            }
           
            request.setAttribute("stock_quantity", stock_quantity);
            request.setAttribute("list_feedback", list_fb);
            request.setAttribute("size_default", size_default);
            request.setAttribute("list_img", list_img);
            request.setAttribute("list_stock", list_stock);
            request.setAttribute("list_stock_all", list_stock_all);
            request.setAttribute("list_color", list_color);
            request.setAttribute("product", product);
            request.setAttribute("list_4_img", list_4_img);
            request.setAttribute("list_stock_4", list_stock_4);
            request.setAttribute("list_4", list_4);
            request.setAttribute("pro_img", proImg);

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("productDetail.jsp").forward(request, response);
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
        ProductDAO pdb = new ProductDAO();
        StockDAO sdb = new StockDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        //get proID 
        String proId_raw = request.getParameter("proID");
        request.setAttribute("proId", proId_raw);
        String proColorID_raw = request.getParameter("colorID");
        request.setAttribute("coID", proColorID_raw);
        String Sizeid_raw = request.getParameter("sizeID");
        request.setAttribute("siID", Sizeid_raw);
        String quantity = request.getParameter("quantity");
        request.setAttribute("quantity_c", quantity);
        int quantity_cart;
        try {
            quantity_cart = Integer.parseInt(quantity);
            if (quantity != null && quantity_cart != 0) {
                Cookie[] arr = request.getCookies();
                System.out.println(Arrays.toString(arr));
                String txt = "";
                int size = 0;
                if (arr != null) {
                    for (Cookie o : arr) {
                        if (o.getName().equals("cart")) {
                            txt = txt + o.getValue();
                            o.setMaxAge(0);
                            response.addCookie(o);
                        }
                        if (o.getName().equals("size")) {
                            size = size + Integer.parseInt(o.getValue());
                            o.setMaxAge(0);
                            response.addCookie(o);
                        }
                    }
                }

                if (txt.isEmpty()) {
                    txt = proId_raw + ":" + proColorID_raw + ":" + Sizeid_raw + ":" + quantity;
                } else {
                    txt = txt + "#" + proId_raw + ":" + proColorID_raw + ":" + Sizeid_raw + ":" + quantity;
                }
                Cookie c = new Cookie("cart", txt);
                c.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(c);
                //su li size

                Cart cart = new Cart(txt);
                size = cart.getSize();
                String size_raw = String.valueOf(size);
                Cookie size_cart = new Cookie("size", size_raw);
                size_cart.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(size_cart);

            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        request.setAttribute("loadPage", true);
        this.doGet(request, response);

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
