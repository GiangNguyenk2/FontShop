<%-- 
    Document   : Menu.jsp
    Created on : May 20, 2023, 3:29:59 PM
    Author     : dinhd513
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wel">
    <h6 href=""><strong>Welcome</strong> to our shop</h6>

</div>
<!-- Top navigation -->
<div class="topnav">

    <!-- Centered link -->
    <div class="topnav-centered">
        <a href="${pageContext.request.contextPath}/view/Home" class="active"
           style="color: black; font-size: 40px; font-family: 'MuseoModerno', cursive;"><strong>Front:</strong></a>
    </div>

    <!-- Left-aligned links (default) -->
    <a style="font-family: 'MuseoModerno', cursive;" href="${pageContext.request.contextPath}/view/shopAll?caID=0&page=1&sort=new">Shop All</a>
    <a style="font-family: 'MuseoModerno', cursive;" href="${pageContext.request.contextPath}/view/bloglist">Blog</a>
    <a style="font-family: 'MuseoModerno', cursive;" href="${pageContext.request.contextPath}/view/ComboList">Combo</a>
    <!-- Right-aligned links -->
    
    <%
    int size = 0;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("size")) {
            size = Integer.parseInt(cookie.getValue());
            break;
        }
    }
}
    %>

    <div class="topnav-right" style="justify-content: right; float: right; margin-right: 20px;">
        <a style="font-size: 10px;margin-left: 5px;" href="${pageContext.request.contextPath}/view/cart">
            <i class="fa fa-shopping-cart" style="font-size:25px; height: fit-content;"></i> <%= size %>

        </a>

        <c:if test="${sessionScope.account != null}">
            <a style="padding-left: 20px; font-family: 'MuseoModerno', cursive;" href="${pageContext.request.contextPath}/view/profile">Profile</a>
            <a style="padding-left: 20px; font-family: 'MuseoModerno', cursive;"href="${pageContext.request.contextPath}/view/logout">Log out</a>   
        </c:if>

        <c:if test="${sessionScope.account == null}">

            <a  style="padding-left: 20px; margin-right: 20px ;font-family: 'MuseoModerno', cursive;" href="${pageContext.request.contextPath}/view/Login.jsp">Log in</a>   
        </c:if>



    </div>

</div>
