/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import dal.AccountDAO;
import helper.GetRandom;
import helper.SendMail;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import utlis.GetParam;

/**
 *
 * @author dinhd513
 */
public class SignupServlet extends HttpServlet {

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
        String password = GetParam.getStringParam(request, "password", "Password",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", "Minimum eight characters, at least one letter and one number", 8, 50, null);
//        String address = GetParam.getStringParam(request, "address", "Address",
//                "[A-Za-z0-9'\\.\\-\\s\\,ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", "This is not address", 1, 200, null);
        if (gmail == null || name == null || password == null) {
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
        request.getRequestDispatcher("../view/Signup.jsp").forward(request, response);
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
            AccountDAO accDao = new AccountDAO();
            String gmail = request.getParameter("gmail");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");

            if (accDao.searchAccByID(gmail) == null) {
                GetRandom getRandom = new GetRandom();
                String code = getRandom.generateRandomNumber(5);

                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("gmail", gmail);
                session.setAttribute("code", code);
                session.setAttribute("password", password);
                session.setAttribute("gender", gender);
                session.setMaxInactiveInterval(300);
                String subject = "Verification Email";
                String text = "Hello\n"
                        + "\n"
                        + "You have registered an account on the Front website, before you can use your account you need to verify that this is your email. here is your code:\n " + code + "\n"
                        + "\n"
                        + "Kind Regards, Front";
                SendMail send = new SendMail();
                send.SendGmail(gmail, subject, text);
                request.getRequestDispatcher("../view/VerificationEmail.jsp").forward(request, response);
            } else {
                request.setAttribute("mess", "Gmail is exist ");
                request.getRequestDispatcher("../view/Signup.jsp").forward(request, response);
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
