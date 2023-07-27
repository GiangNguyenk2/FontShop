/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import dal.AccountDAO;
import helper.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utlis.GetParam;

/**
 *
 * @author admin
 */
public class AddUserServlet extends HttpServlet {

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
        String gmail = GetParam.getStringParam(request, "gmail", "Gmail",
                "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "This is not gmail", 5, 50, null);
        String name = GetParam.getStringParam(request, "name", "Full Name",
                "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", "This is not name", 5, 50, null);
        if (gmail == null || name == null) {
            return false;
        }
        return true;
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
        request.setAttribute("mess", "");
        String gender = request.getParameter("gender");
        String role = request.getParameter("role");
        request.setAttribute("gender", gender);
        request.setAttribute("role", role);
        request.getRequestDispatcher("../view/AddUser.jsp").forward(request, response);
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
            String gmail = request.getParameter("gmail");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String role = request.getParameter("role");

            AccountDAO acc = new AccountDAO();
            acc.AddAccount(gmail, name, gender, role);
            request.setAttribute("mess", "Add Sucessfull");
            if(role.equals("2")){
                role ="Maketing";
            }
            if(role.equals("3")){
                role ="Sale";
            }
            
            SendMail send = new SendMail();
            send.SendGmail(gmail, "Create Account", "Welcom to Front Shop! We have created an account for you as role is "+role+" with gmail: "+gmail+" and password: 123456789a ");
            request.getRequestDispatcher("../view/AddUser.jsp").forward(request, response);
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
