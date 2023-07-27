<%-- 
    Document   : AddProduct
    Created on : Jun 6, 2023, 8:01:23 PM
    Author     : dinhd513
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/addProduct.css">

        <title>Add New Stock</title>

        <style>
            .card {
                --font-color: #323232;
                --font-color-sub: #666;
                --bg-color: #fff;
                --main-color: #323232;
                --main-focus: #2d8cf0;
                width: 230px;
                height: fit-content;
                background: var(--bg-color);
                border: 2px solid var(--main-color);
                box-shadow: 4px 4px var(--main-color);
                border-radius: 5px;
                display: flex;
                flex-direction: column;
                justify-content: flex-start;
                padding: 20px;
                margin-bottom: 30px;
                gap: 10px;
                font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            }

            .card:last-child {
                justify-content: flex-end;
            }

            .card-img {
                /* clear and add new css */
                transition: all 0.5s;
                display: flex;
                justify-content: center;
            }

            .card-img .img {
                /* delete */
                transform: scale(1);
                position: relative;
                box-sizing: border-box;
                width: 100px;
                height: 100px;
                border-top-left-radius: 80px 50px;
                border-top-right-radius: 80px 50px;
                border: 2px solid black;
                background-color: #228b22;
                background-image: linear-gradient(to top,transparent 10px,rgba(0,0,0,0.3) 10px,rgba(0,0,0,0.3) 13px,transparent 13px);
            }

            .card-img .img::before {
                /* delete */
                content: '';
                position: absolute;
                width: 65px;
                height: 110px;
                margin-left: -32.5px;
                left: 50%;
                bottom: -4px;
                background-repeat: no-repeat;
                background-image: radial-gradient(ellipse at center,rgba(0,0,0,0.7) 30%,transparent 30%),linear-gradient(to top,transparent 17px,rgba(0,0,0,0.3) 17px,rgba(0,0,0,0.3) 20px,transparent 20px),linear-gradient(to right,black 2px,transparent 2px),linear-gradient(to left,black 2px,transparent 2px),linear-gradient(to top,black 2px,#228b22 2px);
                background-size: 60% 10%,100% 100%,100% 65%,100% 65%,100% 50%;
                background-position: center 3px,center bottom,center bottom,center bottom,center bottom;
                border-radius: 0 0 4px 4px;
                z-index: 2;
            }

            .card-img .img::after {
                /* delete */
                content: '';
                position: absolute;
                box-sizing: border-box;
                width: 28px;
                height: 28px;
                margin-left: -14px;
                left: 50%;
                top: -13px;
                background-repeat: no-repeat;
                background-image: linear-gradient(80deg,#ffc0cb 45%,transparent 45%),linear-gradient(-175deg,#ffc0cb 45%,transparent 45%),linear-gradient(80deg,rgba(0,0,0,0.2) 51%,rgba(0,0,0,0) 51%),linear-gradient(-175deg,rgba(0,0,0,0.2) 51%,rgba(0,0,0,0) 51%),radial-gradient(circle at center,#ffa6b6 45%,rgba(0,0,0,0.2) 45%,rgba(0,0,0,0.2) 52%,rgba(0,0,0,0) 52%),linear-gradient(45deg,rgba(0,0,0,0) 48%,rgba(0,0,0,0.2) 48%,rgba(0,0,0,0.2) 52%,rgba(0,0,0,0) 52%),linear-gradient(65deg,rgba(0,0,0,0) 48%,rgba(0,0,0,0.2) 48%,rgba(0,0,0,0.2) 52%,rgba(0,0,0,0) 52%),linear-gradient(22deg,rgba(0,0,0,0) 48%,rgba(0,0,0,0.2) 48%,rgba(0,0,0,0.2) 54%,rgba(0,0,0,0) 54%);
                background-size: 100% 100%,100% 100%,100% 100%,100% 100%,100% 100%,100% 75%,100% 95%,100% 60%;
                background-position: center center;
                border-top-left-radius: 120px;
                border-top-right-radius: 10px;
                border-bottom-left-radius: 10px;
                border-bottom-right-radius: 70px;
                border-top: 2px solid black;
                border-left: 2px solid black;
                transform: rotate(45deg);
                z-index: 1;
            }

            .card-title {
                font-size: 20px;
                font-weight: 500;
                text-align: center;
                color: var(--font-color);
            }

            .card-subtitle {
                font-size: 14px;
                font-weight: 400;
                color: var(--font-color-sub);
            }

            .card-divider {
                width: 100%;
                border: 1px solid var(--main-color);
                border-radius: 50px;
            }

            .card-footer {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;
            }

            .card-price {
                font-size: 20px;
                font-weight: 500;
                color: var(--font-color);
            }

            .card-price span {
                font-size: 20px;
                font-weight: 500;
                color: var(--font-color-sub);
            }

            .card-btn {
                height: 35px;
                background: var(--bg-color);
                border: 2px solid var(--main-color);
                border-radius: 5px;
                padding: 0 15px;
                transition: all 0.3s;
            }

            .card-btn svg {
                width: 100%;
                height: 100%;
                fill: var(--main-color);
                transition: all 0.3s;
            }

            .card-img:hover {
                transform: translateY(-3px);
            }

            .card-btn:hover {
                border: 2px solid var(--main-focus);
            }

            .card-btn:hover svg {
                fill: var(--main-focus);
            }

            .card-btn:active {
                transform: translateY(3px);
            }
        </style>


    </head>
    <body>
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param value="active" name="active"/> 
            <jsp:param name="hrefMarketing" value="../view/marketingDashboard?table=product"/>
        </jsp:include>

        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link" style="font-weight: 600">Add New Stock</a>

                <input type="checkbox" id="switch-mode" hidden>


            </nav>
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main style="display: flex;justify-content: center">

                <div class="card" style="width: 25%; margin-top: 60px; ">
                    <div class="card-img">
                        <div style="width: 100px">
                            <c:forEach items="${requestScope.list_img}" var="k">
                                <c:if test="${k.proID==product.proID}">  
                                    <img style="width: 100%" src="../${k.proImg}">
                                </c:if>  
                            </c:forEach> 
                        </div>
                    </div>
                    <div class="card-title">${product.proName}</div>

                    <hr class="card-divider">
                    <div class="card-footer">
                        <div class="card-price"> ${product.proPrice}<span>VND</span></div>
                    </div>
                    <div>
                        <style>
                            th, td {
                                text-align: center;
                                padding: 3px;
                            }
                        </style>
                        <h5>Current Stock</h5>
                        <table style="border-collapse: collapse;
                               width: 100%;
                               border: 1px dotted black;">
                            <thead>
                                <tr>
                                    <th>Color</th>
                                    <th>Size</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <c:forEach items="${requestScope.list_Stock}" var="o">
                                        <td>
                                           
                                            <c:forEach items="${requestScope.list_Color}" var="j">
                                                <c:if test="${o.proColorID == j.proColorID}">  
                                                    ${j.proColorName}
                                                </c:if>  
                                            </c:forEach> 
                                        </td>
                                        <td>
                                            <c:forEach items="${requestScope.list_Size}" var="k">
                                                <c:if test="${o.proSizeID == k.sizeID}">  
                                                    ${k.sizeName}
                                                </c:if>  
                                            </c:forEach>        
                                        </td>
                                        <td>${o.quantity}</td>

                                    </tr></c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>


                    <div style="width: 65%">
                        <form class="form" method="post" action="../view/addStock">
                            <h4>${requestScope.mess}</h4>
                            <input name="proID" value="${product.proID}" hidden>



                        <div class="flex"style="justify-content: space-between">
                            <div class="container" style="display: flex">
                                <div class="tabs" style="flex-wrap: wrap;">
                                    <c:forEach items="${requestScope.list_Color}" var="o">
                                        <input type="radio" id="radio-${o}" name="colorID" checked="" value="${o.proColorID}">
                                        <label class="tab" for="radio-${o}" style="font-weight: 550;width: fit-content; padding:  0     5px;margin: 3px; border-bottom: 2px solid black">${o.proColorName}</label>
                                    </c:forEach>  
                                </div>


                            </div> <div style="margin-left: 10px; "> 
                                <jsp:include page="../components/input_AddProduct.jsp">
                                    <jsp:param name="type" value="text"/>
                                    <jsp:param name="placeholder" value="New Color"/>
                                    <jsp:param name="field" value="colorName"/>
                                </jsp:include>
                            </div>
                        </div>

                        <div class="container" >
                            <div class="tabs" style="flex-wrap: wrap;">
                                <c:forEach items="${requestScope.list_Size}" var="o">
                                    <input type="radio" id="radio-${o}" name="sizeID" checked="" value="${o.sizeID}">
                                    <label class="tab" for="radio-${o}" style="font-weight: 550;width: fit-content; padding:  0 10px;margin: 3px; border-bottom: 2px solid black">${o.sizeName}</label>
                                </c:forEach>  
                            </div>
                        </div> 





                        <jsp:include page="../components/input_AddProduct.jsp">
                            <jsp:param name="type" value="number"/>
                            <jsp:param name="placeholder" value="Quantity(*)"/>
                            <jsp:param name="field" value="quantity"/>
                        </jsp:include>








                        <button class="fancy" href="#">
                            <span class="top-key"></span>
                            <span class="text">submit</span>
                            <span class="bottom-key-1"></span>
                            <span class="bottom-key-2"></span>
                        </button>
                    </form>
                </div>

            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->


        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
