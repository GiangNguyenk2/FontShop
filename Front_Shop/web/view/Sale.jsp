<%-- 
    Document   : Sale
    Created on : May 20, 2023, 3:44:49 PM
    Author     : dinhd513
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->

        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/maketing.css">


        <!-- Boxicons -->
        <title>Marketing</title>
        <style>
            .row .ComboName{
                text-align: center;
                width: fit-content;
                margin: auto;
                margin-top: 30px;
                border-bottom: 2px solid black;
                border-radius: 10px;
                border-right:  1px solid black;
            }
            .hotblog{
                width: 100%;
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
            }
            .blog{
                width: 30%;
                padding: 20px;
            }

            .blog img {
                width: 100%;
                border-radius: 10px;

            }
            .blog h3 {
                width: 100%;
                font-size: larger;
                padding-top:10px ;
            }

            .combolist{
                width: 100%;
                display: flex;
                justify-content: center;
                margin: 20px;
            }
            .card{
                border: 0;
                margin: 15px;
                width: 20%;
                max-width: 25%;

                text-align: center;
                padding:0;

            }
        </style>
    </head>
    <body>
        <!-- SIDEBAR -->    
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="active1" value="active"/>
            <jsp:param name="hrefOrder" value="../view/managerorder?table=all&filter=new&page=1"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link">Categories</a>
                <input type="checkbox" id="switch-mode" hidden>
            </nav>
            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Sale Dashboard</h1>
                    </div>
                </div>
                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="text">
                            <h3>${requestScope.totalProduct}</h3>
                            <p>Product</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="text">
                            <h3>${requestScope.totalOrder}</h3>
                            <p>Purchases</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="text">
                            <h3>${combo}</h3>
                            <p>Combo</p>
                        </span>
                    </li>
                </ul>

                <div class="table-data" style="margin-top: 20px">
                    <div class="todo">
                        <div class="head">
                            <h3>Best Selling Product</h3> 
                        </div>
                        <div class="combolist">
                            <img src="../${imgTop1.proImg}" alt="John" style="width:50%">
                            <p class="title">${productTop1.proName}</p>
                            <p class="price-N">${productTop1.proPrice} VND</p>
                        </div>  
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>New Combo</h3>
                        </div>
                        <div>
                            <c:forEach items="${requestScope.combolist}" var="o" >
                                <div class="row">
                                    <div class="ComboName">
                                        <h2 style="">${o.comboName}</h2>
                                    </div>
                                    <div class="combolist">
                                        <c:forEach items="${requestScope.combodetail}" var="i">
                                            <c:if test="${i.comboID == o.comboID}">

                                                <div class="card" >
                                                    <c:forEach items="${requestScope.listimg}" var="z">
                                                        <c:if test="${i.proID == z.proID}">
                                                            <img src="../${z.proImg}" alt="John" style="width:100%">
                                                        </c:if>
                                                    </c:forEach>
                                                    <p class="title">${i.proName}</p>
                                                    <p class="price-N">${i.proPrice} VND</p>
                                                    </a>    
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>       
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
