/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import dal.AccountDAO;
import dal.OrderDAO;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Account;
import models.Address;
import models.Cart;
import models.Item;
import models.ProductImage;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class CheckoutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckoutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
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

        Cart cart = new Cart(txt);
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
        String tien = convertToWords(total);

        // lay size cart
        int size_cart = list_item.size();

        //lay tai khoan nguoi dung
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        AccountDAO adb = new AccountDAO();
        List<Address> list_address = adb.getAllAddress(a.getGmail());
        List address = new ArrayList();

        for (int i = 0; i < list_address.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list_address.get(i).getAddress() + " - ");
            stringBuilder.append(list_address.get(i).getWard() + " - ");
            stringBuilder.append(list_address.get(i).getDistrict() + " - ");
            stringBuilder.append(list_address.get(i).getCity() + " ");

            String ad = stringBuilder.toString();
            address.add(ad);
        }
        //-------------------------
        request.setAttribute("list_item", list_item);
        request.setAttribute("list_address", address);
        request.setAttribute("list_img", list_img);
        request.setAttribute("stock", stock);
        request.setAttribute("total", total);
        request.setAttribute("size_cart", size_cart);
        request.setAttribute("tien", tien);

        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
    }

    
    
    
    
    
    
    private static final String[] units = {
        "", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín",
        "mười", "mười một", "mười hai", "mười ba", "mười bốn", "mười năm",
        "mười sáu", "mười bảy", "mười tám", "mười chín"
    };

    private static final String[] scales = {
        "", "nghìn", "triệu", "tỷ"
    };

    private static String convertToWords(double number) {
        if (number == 0) {
            return "không đồng";
        }

        String result = "";
        int scaleIndex = 0;

        while (number > 0) {
            int digits = (int) (number % 1000);
            if (digits != 0) {
                String scale = scales[scaleIndex];
                String group = convertGroupToWords(digits);
                result = group + " " + scale + " " + result;
            }
            scaleIndex++;
            number /= 1000;
        }

        return result.trim();
    }

    private static String convertGroupToWords(double number) {
        String result = "";

        int hundreds = (int) number / 100;
        int tensUnits = (int) number % 100;

        if (hundreds > 0) {
            result += units[hundreds] + " trăm ";
        }

        if (tensUnits > 0) {
            if (tensUnits < 20) {
                result += units[tensUnits] + " ";
            } else {
                int tens = tensUnits / 10;
                int units1 = tensUnits % 10;
                result += units[tens] + " mươi ";
                if (units1 > 0) {
                    result += units[units1] + " ";
                }
            }
        }

        return result.trim();
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
        String address = request.getParameter("address");
        String tinh = request.getParameter("tinh");
        String huyen = request.getParameter("huyen");
        String xa = request.getParameter("xa");
        String nha = request.getParameter("nha");
        String tt = request.getParameter("tt");
        String phone = request.getParameter("phone");
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt = txt + o.getValue();
                }
            }
        }

        Cart cart = new Cart(txt);
        HttpSession session = request.getSession();
        OrderDAO odb = new OrderDAO();

        List<Item> list_item = cart.getItems();
        //su li hang
        List<StockDetail> stock = new ArrayList<>();
        for (int i = 0; i < cart.getItems().size(); i++) {
            StockDetail s = sdb.getStockForCart(cart.getItems().get(i).getProduct().getProID(), cart.getItems().get(i).getColorID(), cart.getItems().get(i).getSizeID());
            stock.add(s);
        }
        //su li dia chi cu
         

        //lay account
        Account a = (Account) session.getAttribute("account");
        AccountDAO adb = new AccountDAO();
        Address ad = new Address();
        if (!address.equals("new")) {
             String[] add = address.split(" - ");
             ad = adb.getOldAddress(a.getGmail(), add[0], add[3], add[2], add[1]);
        }
        
        if (a == null) {
            response.sendRedirect("login");
        } else {

            if (address.equals("new")) {
                odb.addOrderNewAddress(a, cart, stock, tinh, huyen, xa, nha, phone);
                
            } else {
                odb.addOrder(a, cart, stock,ad.getID());
            }
            Cookie c = new Cookie("cart", "");
            Cookie size = new Cookie("size", "");
            c.setMaxAge(0);
            size.setMaxAge(0);
            response.addCookie(c);
            response.addCookie(size);

        }
        response.sendRedirect("Complete.jsp");
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
