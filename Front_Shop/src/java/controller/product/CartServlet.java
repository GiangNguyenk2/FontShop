/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import dal.ProductImageDAO;
import dal.StockDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Cart;
import models.Item;
import models.ProductImage;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class CartServlet extends HttpServlet {

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
        ProductImageDAO pidb = new ProductImageDAO();
        Cookie[] arr = request.getCookies();
        System.out.println(Arrays.toString(arr));
        String txt = "";

        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt = txt + o.getValue();

                }
            }
        }
        //su li so luong
        String proid_raw = request.getParameter("proID");
        String num_raw = request.getParameter("num");
        String c_raw = request.getParameter("colorID");
        String s_raw = request.getParameter("sizeID");
        int proID;
        int num;
        int colorID;
        int sizeID;
        StockDetail st;
        try {
            proID = Integer.parseInt(proid_raw);
            num = Integer.parseInt(num_raw);
            colorID = Integer.parseInt(c_raw);
            sizeID = Integer.parseInt(s_raw);
            st = sdb.getStockForCart(proID, colorID, sizeID);
             int maxValue = st.getQuantity();
             request.setAttribute("maxValue", maxValue);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }

        String out = "";

        if (txt != null) {
            String[] ids = txt.split("#");
            
            for (int i = 0; i < ids.length; i++) {
                String[] s = ids[i].split(":");

                if (s[0].equals(proid_raw) && s[1].equals(c_raw) && s[2].equals(s_raw)) {
                    if(num_raw.equals("0")){
                        
                    }else{
                        if (out.isEmpty()) {
                        out += proid_raw + ":" + c_raw + ":" + s_raw + ":" + num_raw;
                    } else {
                        out += "#"+ proid_raw + ":" + c_raw + ":" + s_raw + ":" + num_raw;
                    }
                    
                    }
                    
                } else {
                    if (out.isEmpty()) {
                        out += ids[i];
                    } else {
                        out += "#" + ids[i];
                    }
                }

            }
            if (!out.isEmpty()) {
                Cookie c = new Cookie("cart", out);
                c.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(c);
            }
        }

        Cart cart = new Cart(out);
        List<Item> list_item = cart.getItems();

        //su li hang
        List<StockDetail> stock = new ArrayList<>();
        for (int i = 0; i < cart.getItems().size(); i++) {
            StockDetail s = sdb.getStockForCart(cart.getItems().get(i).getProduct().getProID(), cart.getItems().get(i).getColorID(), cart.getItems().get(i).getSizeID());
            stock.add(s);
        }

        //su li anh
        List<ProductImage> list_img = new ArrayList<>();
        for (int i = 0; i < list_item.size(); i++) {
            ProductImage p = pidb.getImageById(list_item.get(i).getProduct().getProID());
            list_img.add(p);
        }

        for (int i = 0; i < list_img.size(); i++) {
            for (int j = list_img.size() - 1; j > i; j--) {
                if (list_img.get(i).getProID() == list_img.get(j).getProID()) {
                    list_img.remove(j);
                }
            }
        }

        //lay tong tien
        double total = cart.getTotalMoney();
        // lay size cart
        int size_cart = list_item.size();
        //-------------------------
       
        request.setAttribute("list_item", list_item);
        
        request.setAttribute("list_img", list_img);
        request.setAttribute("stock", stock);
        request.setAttribute("total", total);
        request.setAttribute("size_cart", size_cart);
        request.getRequestDispatcher("../view/Cart.jsp").forward(request, response);

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
        StockDAO sdb = new StockDAO();
        ProductImageDAO pidb = new ProductImageDAO();
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
        String proid_raw = request.getParameter("proID");

        String c_raw = request.getParameter("colorID");
        String s_raw = request.getParameter("sizeID");
        String[] ids = txt.split("#");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (s[0].equals(proid_raw) && s[1].equals(c_raw) && s[2].equals(s_raw)) {

            } else {
                if (out.isEmpty()) {
                    out = ids[i];
                } else {
                    out += "#" + ids[i];
                }
            }
        }
        if (!out.isEmpty()) {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(c);
        }

        Cart cart = new Cart(out);
        List<Item> list_item = cart.getItems();
        //su li hang
        List<StockDetail> stock = new ArrayList<>();
        for (int i = 0; i < cart.getItems().size(); i++) {
            StockDetail s = sdb.getStockForCart(cart.getItems().get(i).getProduct().getProID(), cart.getItems().get(i).getColorID(), cart.getItems().get(i).getSizeID());
            stock.add(s);
        }

        //su li anh
        List<ProductImage> list_img = new ArrayList<>();
        for (int i = 0; i < cart.getItems().size(); i++) {
            ProductImage p = pidb.getImageById(cart.getItems().get(i).getProduct().getProID());
            list_img.add(p);
        }

        for (int i = 0; i < list_img.size(); i++) {
            for (int j = 1; j < list_img.size(); j++) {
                if (list_img.get(i).getProID() == list_img.get(j).getProID()) {
                    list_img.remove(j);
                }
            }

        }

        //lay tong tien
        double total = cart.getTotalMoney();
        // lay size cart
        int size_cart = list_item.size();
        size = cart.getSize();
        String size_raw = String.valueOf(size);
        Cookie size_c2 = new Cookie("size", size_raw);
        size_c2.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(size_c2);
        //-------------------------
        request.setAttribute("list_item", list_item);
        request.setAttribute("list_img", list_img);
        request.setAttribute("stock", stock);
        request.setAttribute("total", total);
        request.setAttribute("size_cart", size_cart);
        request.getRequestDispatcher("../view/Cart.jsp").forward(request, response);
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
