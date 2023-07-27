/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.marketing;

import dal.MktDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.Categories;
import models.Product;
import utlis.GetParam;

/**
 *
 * @author dinhd513
 */
public class AddProductServlet extends HttpServlet {

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

        String proName = GetParam.getStringParam(request, "proName", "Product Name",
                "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", "This is not name", 0, 200, null);
        Float proPrice = GetParam.getFloatParams(request, "proPrice", "Price", 0, Float.MAX_VALUE, null);
//        String proDetail = GetParam.getStringParam(request, "proDetail", "Detail",
//                "^[\\p{L}\\p{M}\\s\\S]{0,1000}$", 
//                "This can have from 1 to 1000 characters", 0, 1000, null);
        String proDetail = request.getParameter("proDetail");
        if (!proDetail.matches("^[\\p{L}\\p{M}\\s\\S]{0,1000}$"))
        {
            proDetail = null;
            request.setAttribute("error", "This can have from 1 to 1000 characters");
        }
        String img1 = request.getParameter("proImg1");       
        if (proName == null || proPrice == null || proDetail == null || img1 == null || img1.equals("")) {
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
        List<Categories> list = dao.getAllCategories();
        request.setAttribute("listCa", list);
        request.getRequestDispatcher("../view/AddProduct.jsp").forward(request, response);
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
        if (processRequest(request, response)) {
            MktDAO dao = new MktDAO();
            String proName = request.getParameter("proName");
            String proCa = request.getParameter("proCa");
            String proDetail = request.getParameter("proDetail");
            String proPrice = request.getParameter("proPrice");
            String proImg1 = request.getParameter("proImg1");
            String proImg2 = request.getParameter("proImg2");
            String proImg3 = request.getParameter("proImg3");
            String proImg4 = request.getParameter("proImg4");
            String newCa = request.getParameter("newCa");
            float price = 0;
            int ca = 0;
            try {
                price = Float.parseFloat(proPrice);
                ca = Integer.parseInt(proCa);
                Product p = dao.getProduct(proName, ca, price);

                if (p == null) {
                    if (newCa.equals("")) {
                        dao.AddProduct(proName, proDetail, price, ca, true);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg1);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg2);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg3);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg4);
                    }else{
                        dao.addCategory(newCa);
                        dao.AddProduct(proName, proDetail, price, dao.getCategory().getCaID(), true);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg1);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg2);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg3);
                        dao.addProductImg(dao.getNewProduct().getProID(), proImg4);
                    }

                    request.setAttribute("mess", "Add Product Successful");

                    this.doGet(request, response);
                } else {
                    request.setAttribute("mess", "Product already exists");
                    this.doGet(request, response);
                }
            } catch (Exception e) {
            }

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
