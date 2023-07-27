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
public class UpdateProductServlet extends HttpServlet {

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
        String proDetail = request.getParameter("proDetail");
        if (!proDetail.matches("^[\\p{L}\\p{M}\\s\\S]{0,1000}$"))
        {
            proDetail = null;
            request.setAttribute("error", "This can have from 1 to 1000 characters");
        }
        if (proName == null || proPrice == null || proDetail == null) {
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
        String proID = request.getParameter("proID");
        request.setAttribute("proID", proID);
        int id = 0;
        try {
            id = Integer.parseInt(proID);
            Product p = dao.getProduct(id);
            request.setAttribute("proName", p.getProName());
            request.setAttribute("caID", p.getCaID());
            request.setAttribute("proDetail", p.getProDetail());
            request.setAttribute("proPrice", p.getProPrice());
            request.setAttribute("proStatus", p.isProStatus());
        } catch (Exception e) {
        }

        request.getRequestDispatcher("../view/UpdateProduct.jsp").forward(request, response);
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
        MktDAO dao = new MktDAO();
            String proID = request.getParameter("proID");
            request.setAttribute("proID", proID);
        if (processRequest(request, response)) {
            
            String proName = request.getParameter("proName");
            String proCa = request.getParameter("proCa");
            String proDetail = request.getParameter("proDetail");
            String proPrice = request.getParameter("proPrice");
            String proImg1 = request.getParameter("proImg1");
            String proImg2 = request.getParameter("proImg2");
            String proImg3 = request.getParameter("proImg3");
            String proImg4 = request.getParameter("proImg4");
            String proStatus = request.getParameter("proStatus");
            

            float price = 0;
            int ca = 0;
            int id =0;
            boolean isProStatus;
            isProStatus = proStatus.equals("true");
           
            try {
                id = Integer.parseInt(proID);
                price = Float.parseFloat(proPrice);
                ca = Integer.parseInt(proCa);
                Product proCheck = dao.getProductNotCurrent(proName, ca, price,id);
                if (proCheck == null) {
                    if (proImg1.equals("")&& proImg2.equals("")&& proImg3.equals("")&& proImg4.equals("")) {
                       dao.UpdateProduct(id, proName, proDetail, price, ca, isProStatus);
                    } else {
                        dao.DeleteProductImg(id);
                        Product p = dao.getProduct(id);
                        dao.UpdateProduct(id, proName, proDetail, price, ca, isProStatus);
                        dao.addProductImg(p.getProID(), proImg1);
                        dao.addProductImg(p.getProID(), proImg2);
                        dao.addProductImg(p.getProID(), proImg3);
                        dao.addProductImg(p.getProID(), proImg4);
                    }
                    request.setAttribute("mess", "Update Product Successful");
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
