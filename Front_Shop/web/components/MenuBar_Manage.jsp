<%-- 
    Document   : MenuBar_Marketing
    Created on : Jun 4, 2023, 12:57:06 PM
    Author     : dinhd513
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="sidebar">
    <a href="" class="brand">

        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">

        <span class="text" style="font-family: 'MuseoModerno', cursive; margin: 30px;font-size: 40px">Front:</span>
    </a>
    <ul class="side-menu top">
        
        <c:if test="${sessionScope.account.roleID == 3}">
            <li class="${param.active1}">
                <a href="../view/saleDashboard">
                    <i class='bx bxs-dashboard' ></i>
                    <span class="text">Dashboard</span>
                </a>
            </li>
        </c:if>
            
        <c:if test="${sessionScope.account.roleID == 2}">
            <li class="${param.active1}">
                <a href="../view/marketingDashboard?table=product">
                    <i class='bx bxs-dashboard' ></i>
                    <span class="text">Dashboard</span>
                </a>
            </li>
        </c:if>

        <c:if test="${sessionScope.account.roleID == 1}">
            <li class="${param.active1}">
                <a href="../view/AdminDashboard?table=product">
                    <i class='bx bxs-dashboard' ></i>
                    <span class="text">Dashboard</span>
                </a>
            </li>
        </c:if>


        <li class="${param.active}">
            <a href="../view/productStockManage?list=product&caID=0&sort=new">
                <i class='bx bxs-shopping-bag-alt' ></i>
                <span class="text">Product</span>
            </a>
        </li>
        <c:if test="${sessionScope.account.roleID == 2|| sessionScope.account.roleID == 1}">
            <li class="${param.active2}">
                <a href="../view/PostManage" >
                    <i class='bx bxl-blogger' ></i>
                    <span class="text">Post</span>
                </a>
            </li>
        </c:if>
        <c:if test="${sessionScope.account.roleID == 3 || sessionScope.account.roleID == 1}">
            <li class="${param.active3}">
                <a href="../view/comboManage">
                    <i class='bx bx-receipt'></i>
                    <span class="text">Combo</span>
                </a>
            </li>
        </c:if>

        <c:if test="${sessionScope.account.roleID == 3 || sessionScope.account.roleID == 1}">
            <li class="${param.activeOrder}">
                <a href="../view/managerorder?table=all&filter=new&page=1">
                    <i class='bx bxs-barcode' ></i>
                    <span class="text">Order</span>
                </a>
            </li>
        </c:if>


        <li class="${param.activeUser}">
            <a href="../view/user">
                <i class='bx bxs-user'></i>
                <span class="text">User</span>
            </a>
        </li>
        <li class="${param.activeFeedback}">
            <a href="../view/feedback">
                <i class='bx bxs-user'></i>
                <span class="text">Feedback</span>
            </a>
        </li>
        <c:if test="${sessionScope.account.roleID == 1}">
            <li class="${param.activeShopInfo}">
                <a href="../view/ShopInfomation">
                    <i class='bx bxs-user'></i>
                    <span class="text">Shop Information</span>
                </a>
            </li>
        </c:if>

    </ul>
    <ul class="side-menu">
        <li>
            <c:if test="${sessionScope.account != null}">
                <a href="${pageContext.request.contextPath}/view/profile">
                    <i class='bx bxs-cog' ></i>
                    <span class="text">Profile</span>
                </a>
            </c:if>

        </li>
        <li>
            <c:if test="${sessionScope.account != null}">
                <a href="${pageContext.request.contextPath}/view/logout" class="logout">
                    <i class='bx bxs-log-out-circle' ></i>
                    <span class="text">Logout</span>
                </a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.account == null}">
                <a href="${pageContext.request.contextPath}/view/Login.jsp" class="logout">
                    <i class='bx bxs-log-out-circle' > </i>
                    <span style="color: black" class="text">Login</span>
                </a>
            </c:if>
        </li>
    </ul>
</section>
