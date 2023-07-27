<%-- 
    Document   : input_AddProduct
    Created on : Jun 7, 2023, 3:44:51 PM
    Author     : dinhd513
--%>


<%@page import="utlis.GetParam" %>
<%  String value = (String) GetParam.getClientParams(request, request.getParameter("field"), "");
    if (request.getParameter("field").equals("password")) {
        value = "";
    }
    if (request.getParameter("defaultValue") != null && value.equals("")) {
        value = request.getParameter("defaultValue");
    }
    String error = (String) GetParam.getClientAttribute(request, request.getParameter("field") + "Error", "");
    
    
%>

<label>
    <input name="${param.field}" placeholder=" " id="${param.field}" type="${param.type}" value="<%= value%>" class="input">
    <span>${param.placeholder}</span>
    <h6> <%= error %></h6>
</label>