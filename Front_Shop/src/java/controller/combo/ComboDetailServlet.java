/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.combo;

import dal.ComboDAO;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Cart;
import models.Color;
import models.ComboDetails;
import models.ComboList;
import models.FeedbackView;
import models.Product;
import models.ProductImage;
import models.StockDetail;

/**
 *
 * @author Asus
 */
public class ComboDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet ComboDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComboDetailServlet at " + request.getContextPath() + "</h1>");
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
        ProductDAO pdb = new ProductDAO();
        StockDAO sdb = new StockDAO();
        ProductImageDAO pidb = new ProductImageDAO();
        ComboDAO dao = new ComboDAO();
        FeedbackDAO fdb = new FeedbackDAO();
        //get proID 
        String proId_raw = request.getParameter("proID");
        String proColorID_raw = request.getParameter("colorID");
        request.setAttribute("coID", proColorID_raw);
        String Sizeid_raw = request.getParameter("sizeID");
        request.setAttribute("siID", Sizeid_raw);
        String quantity = request.getParameter("quantity");
        request.setAttribute("quantity_c", quantity);
        String comboID_raw = request.getParameter("comboID");
       request.setAttribute("CoboID", comboID_raw);
        int proId;
        int colorID;
        int sizeID;

        Product pro = new Product();
        int comboId = 0;
        int proid = 0;

        try {
            comboId = Integer.parseInt(comboID_raw);
            
            proid = Integer.parseInt(request.getParameter("proID"));
            
            colorID = Integer.parseInt(proColorID_raw);
            sizeID = Integer.parseInt(Sizeid_raw);
            StockDetail stock_quantity = new StockDetail();
            List<StockDetail> list_stock = new ArrayList<>();
            List<FeedbackView> list_fb = new ArrayList<>();
            list_fb = fdb.getFeedbackProduct(proid);
            stock_quantity = sdb.getStockQuantity(proid, colorID, sizeID);
            list_stock = sdb.getStockProduct(proid, colorID);
            List<StockDetail> size_default = sdb.getSizeDefault(proid);
            for (int i = 0; i < size_default.size(); i++) {
                for (int j = 1; j < size_default.size(); j++) {
                    if (size_default.get(i).getProColorName().equals(size_default.get(j).getProColorName())) {
                        size_default.remove(j);
                    }
                }
            }
            List<ComboDetails> listComboDetail = new ArrayList<>();

            //Lay san pham voi proID va colorId truyen vao
            //lay stock cua tat ca san pham voi proID truyen vao
            List<StockDetail> list_stock_all = sdb.getStockProductAll(proid);
            listComboDetail = dao.getComboDetailByComboID(comboId);

            List<ProductImage> listImg = new ArrayList<>();
            for (int i = 0; i < listComboDetail.size(); i++) {

                listImg.add(pidb.getImageById(listComboDetail.get(i).getProID()));
            }
            //xu li mau 
            List<Color> list_color = new ArrayList<>();
            for (int i = 0; i < list_stock_all.size(); i++) {
                Color c = new Color();
                c.setProColorID(list_stock_all.get(i).getProColorID());
                c.setProColorName(list_stock_all.get(i).getProColorName());
                list_color.add(c);
            }

            for (int i = 0; i < list_color.size(); i++) {
                for (int j = 1; j < list_color.size(); j++) {
                    if (list_color.get(i).getProColorName().equals(list_color.get(j).getProColorName())) {
                        list_color.remove(j);
                    }
                }
            }

            pro = pdb.getProductByID(proid);
            ProductImage pi = listImg.get(0);

            request.setAttribute("size_default", size_default);
            request.setAttribute("list_color", list_color);
            request.setAttribute("list_fb", list_fb);
            request.setAttribute("stock_quantity", stock_quantity);
            request.setAttribute("list_stock", list_stock);
            request.setAttribute("list_stock_all", list_stock_all);
            request.setAttribute("pro", pro);
            request.setAttribute("fisrtImg", pi);
            request.setAttribute("listimg", listImg);
            request.setAttribute("combodetail", listComboDetail);

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("../view/ComboDetails.jsp").forward(request, response);
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
         String comboID_raw = request.getParameter("comboID");
        request.setAttribute("CoboID", comboID_raw);
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
