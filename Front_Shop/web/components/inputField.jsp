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
<div>

    <input style="border-bottom: 3px solid  black;
  border-radius: 10px; border-right:  1px solid  black; width: 80%" type="${param.type}" value="<%= value%>"   id="${param.field}"  name="${param.field}" placeholder="${param.placeholder}"/>
    <p style="color: black;">
        <%= error %>
    </p>
</div>



