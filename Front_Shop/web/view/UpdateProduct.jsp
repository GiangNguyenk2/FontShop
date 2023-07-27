<%-- 
    Document   : UpdateProduct
    Created on : Jun 8, 2023, 8:20:49 AM
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

        <title>Update Product</title>
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
                <a href="#" class="nav-link" style="font-weight: 600">Update Product</a>

                <input type="checkbox" id="switch-mode" hidden>


            </nav>
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main>
                <form class="form" method="post" action="../view/updateProduct">
                    <h4>${requestScope.mess}</h4>
                    <div class="flex"style="justify-content: space-between">
                        <input hidden value="${requestScope.proID}" name="proID">
                        <jsp:include page="../components/input_UpdateProduct.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Product Name(*)"/>
                            <jsp:param name="field" value="proName"/>
                            <jsp:param name="value" value="${requestScope.proName}"/>
                        </jsp:include>
                        <div class="container" >
                            <div class="tabs" style="flex-wrap: wrap;">
                                <c:forEach items="${requestScope.listCa}" var="o">
                                    <input type="radio" id="radio-${o}" name="proCa" <c:if test="${o.caID == requestScope.caID}">checked=""</c:if> value="${o.caID}">
                                    <label class="tab" for="radio-${o}">${o.caName}</label>
                                </c:forEach>  
                            </div>
                        </div>
                        <div class="container" >
                            <div class="tabs" style="flex-wrap: wrap;">

                                <input type="radio" id="radio-${1}" name="proStatus" <c:if test="${requestScope.proStatus == true}">checked=""</c:if> value="true">
                                <label class="tab" for="radio-${1}">on sale</label>

                                <input type="radio" id="radio-${2}" name="proStatus" <c:if test="${requestScope.proStatus == false}">checked=""</c:if> value="false">
                                <label class="tab" for="radio-${2}">not sold</label>

                            </div>
                        </div>


                    </div>  



                    <textarea name="proDetail" placeholder="Detail(*)" style="height: 100px;border-radius: 10px; padding: 10px; border-color: #AAAAAA" >${requestScope.proDetail}</textarea>
                   
                    <jsp:include page="../components/input_UpdateProduct.jsp">
                        <jsp:param name="type" value="number"/>
                        <jsp:param name="placeholder" value="Price(*)"/>
                        <jsp:param name="field" value="proPrice"/>
                        <jsp:param name="value" value="${requestScope.proPrice}"/>
                    </jsp:include>

                    <label>
                        <input  placeholder="file" type="file" class="input" name="proImg1">
                        <h6>Image1</h6>
                    </label> 
                    <label>
                        <input placeholder="file"  type="file" class="input" name="proImg2">
                        <h6>Image2</h6>
                    </label> 
                    <label>
                        <input placeholder="file" type="file" class="input" name="proImg3">
                        <h6>Image3</h6>
                    </label> 
                    <label>
                        <input placeholder="file" type="file" class="input" name="proImg4">
                        <h6>Image4</h6>
                    </label> 





                    <button class="fancy" href="#">
                        <span class="top-key"></span>
                        <span class="text">submit</span>
                        <span class="bottom-key-1"></span>
                        <span class="bottom-key-2"></span>
                    </button>
                </form>
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->


        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
