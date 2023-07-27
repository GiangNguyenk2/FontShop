<%-- 
    Document   : input_UpdateProduct
    Created on : Jun 8, 2023, 9:43:57 AM
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
    <input name="${param.field}" placeholder=" " id="${param.field}" type="${param.type}" value="${param.value}" class="input">
    <span>${param.placeholder}</span>
    <h6> <%= error %></h6>
</label>