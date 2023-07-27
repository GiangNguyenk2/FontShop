<%-- 
    Document   : MenuBar_Marketing
    Created on : Jun 4, 2023, 12:57:06 PM
    Author     : dinhd513
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="sidebar">
    <a href="../view/../view/marketingDashboard?table=product" class="brand">
        <i class='bx bxs-smile'></i>
        <span class="text">Front:</span>
    </a>
    <ul class="side-menu top">
        <li class="${param.active1}">
            <a href="../view/saleDashboard">
                <i class='bx bxs-dashboard' ></i>
                <span class="text">Dashboard</span>
            </a>
        </li>
        <li class="${param.active}">
            <a href="../view/productStockManage?list=product&caID=0&sort=new">
                <i class='bx bxs-shopping-bag-alt' ></i>
                <span class="text">Product</span>
            </a>
        </li>
        <li class="${param.active3}">
            <a href="../view/comboManage">
                <i class='bx bx-receipt'></i>
                <span class="text">Combo</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bxs-barcode' ></i>
                <span class="text">Order</span>
            </a>
        </li>

        <li>
            <a href="#">
                <i class='bx bxs-user' ></i>
                <span class="text">Customer</span>
            </a>
        </li>
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
    </ul>
</section>
