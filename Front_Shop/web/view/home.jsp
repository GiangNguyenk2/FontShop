<%-- 
    Document   : home
    Created on : May 23, 2023, 9:18:14 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/stylesheet/home.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    </head>

    <body>
        <jsp:include page="../components/Menu.jsp"/>
        <fmt:setLocale value="vi_VN" />
        <fmt:setBundle basename="java.text.resources" />


        <div class="row">
            <img src="${pageContext.request.contextPath}/img/banner_home.jpg"
                 alt="" style="width: 100%; height: auto;">
        </div>

        <div class="container">
            <h2 class="text-center mt-5">Blog news</h2>
            <hr class="mx-auto w-75">
            <div class="row d-flex">
                <div class="col-1 " style="margin: auto;text-align: right;"><i id="backButton1" class="fa fa-chevron-left" style="font-size: 40px;cursor: pointer;"></i></div>
                <div class="swiper-container1 col-10" style=" margin: 50px 30px 20px; margin: auto; /* Độ rộng của khung */overflow: hidden; /* Ẩn phần nội dung tràn ra khỏi khung */">
                    <div class="swiper-wrapper mx-2">
                        <div class="swiper-slide row d-flex" style="margin-left: 20px">
                            <c:forEach items="${requestScope.list_blog}" var="i" begin="0" end="1" >
                                <div class="col-md-4 col-6">
                                    <a href="${pageContext.request.contextPath}/view/blogdeatil?ptittle=${i.tittle}">
                                        <img class="img-fluid" style="width: 100%" src="${pageContext.request.contextPath}/${i.img}" alt="">
                                        <h4 class="text-center">${i.tittle}</h4>
                                    </a>
                                </div>  
                            </c:forEach>
                        </div>
                        <div class="swiper-slide row d-flex">
                            <c:forEach items="${requestScope.list_blog}" var="i" begin="2" end="3">
                                <div class="col-md-4 col-6">
                                    <a href="${pageContext.request.contextPath}/view/blogdeatil?ptittle=${i.tittle}">
                                        <img class="img-fluid" style="width: 100%" src="${pageContext.request.contextPath}/${i.img}" alt="">
                                        <h4 class="text-center">${i.tittle}</h4>
                                    </a>
                                </div>  
                            </c:forEach>
                        </div>
                        <!-- Thêm slide khác vào đây -->
                    </div>
                </div>
                <div class="col-1" style="margin: auto;text-align: left;"><i id="nextButton1" class="fa fa-chevron-right" style="font-size: 40px;cursor: pointer;"></i></div>
            </div>


        </div>
        <br><!-- comment -->
        <hr class="mx-auto w-75">

        <h2 class="text-center mt-5">New Product</h2>

        <div class="row d-flex">
            <div class="col-1 " style="margin: auto;text-align: right;"><i id="backButton" class="fa fa-chevron-left" style="font-size: 40px;cursor: pointer;"></i></div>
            <div class="swiper-container2 col-10" style=" margin: 50px 30px 20px; margin: auto; /* Độ rộng của khung */overflow: hidden; /* Ẩn phần nội dung tràn ra khỏi khung */">
                <div class="swiper-wrapper">
                    <div class="swiper-slide row d-flex" style="margin-left: 20px">
                        <c:forEach items="${requestScope.list_product}" var="i" begin="0" end="7">
                            <c:forEach items="${requestScope.list_stock}" var="m">
                                <c:if test="${i.proID==m.proID}">
                                    <a class="col-3" href="${pageContext.request.contextPath}/view/productDetail?proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0">
                                        <c:forEach items="${requestScope.list_img}" var="a">
                                            <c:if test="${i.proID==a.proID}">  
                                                <img src="${pageContext.request.contextPath}/${a.proImg}" class="product-image img-fluid" alt="">
                                            </c:if>  
                                        </c:forEach>
                                        <p class="title text-center">${i.proName}</p>
                                        <c:set var="price" value="${i.proPrice}" />
                                        <p class="text-center" style="color: red;font-size: 16px"><b>
                                                <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                                                <fmt:formatNumber type="number" pattern="###,###₫" value="${price}" />
                                            </b></p>
                                    </a>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </div>
                    <div class="swiper-slide row d-flex">
                        <c:forEach items="${requestScope.list_product}" var="i" begin="8" end="15">
                            <c:forEach items="${requestScope.list_stock}" var="m">
                                <c:if test="${i.proID==m.proID}">
                                    <a class="col-3" href="${pageContext.request.contextPath}/view/productDetail?proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0">
                                        <c:forEach items="${requestScope.list_img}" var="a">
                                            <c:if test="${i.proID==a.proID}">  
                                                <img src="${pageContext.request.contextPath}/${a.proImg}" class="product-image img-fluid" alt="">
                                            </c:if>  
                                        </c:forEach>
                                        <p class="title text-center">${i.proName}</p>
                                        <c:set var="price" value="${i.proPrice}" />
                                        <p class="text-center" style="color: red;font-size: 16px"><b>
                                                <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                                                <fmt:formatNumber type="number" pattern="###,###₫" value="${price}" />
                                            </b></p>
                                    </a>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </div>
                    <!-- Thêm slide khác vào đây -->
                </div>
            </div>
            <div class="col-1" style="margin: auto;text-align: left;"><i id="nextButton" class="fa fa-chevron-right" style="font-size: 40px;cursor: pointer;"></i></div>
        </div>
        <!--The end product -->
        <!--Lable -->
        <div class="row d-flex my-5 ">
            <img class="col-9" style="margin: auto" src="${pageContext.request.contextPath}/img/lable.png">
        </div>

        <jsp:include page="../components/Footer.jsp"></jsp:include>

        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        <script>
            var swiper1 = new Swiper('.swiper-container2', {
                loop: true,
                autoplay: {
                    delay: 3000, // Thời gian trễ giữa các slide (tính bằng millisecond)
                },
                // Các tùy chọn khác (nếu cần)
            });
        </script>

        <script>
            var swiper2 = new Swiper('.swiper-container1', {
                loop: true,
                // Các tùy chọn khác (nếu cần)
            });
        </script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var swiper1 = new Swiper('.swiper-container1', {
                    // Cấu hình Swiper cho phần 1
                });

                var nextButton1 = document.getElementById('nextButton1');
                var backButton1 = document.getElementById('backButton1');

                nextButton1.addEventListener('click', function () {
                    swiper1.slideNext(); // Chuyển đến slide kế tiếp trong phần 1
                });

                backButton1.addEventListener('click', function () {
                    swiper1.slidePrev(); // Chuyển đến slide trước trong phần 1
                });

                var swiper2 = new Swiper('.swiper-container2', {
                    // Cấu hình Swiper cho phần 2
                });

                var nextButton = document.getElementById('nextButton');
                var backButton = document.getElementById('backButton');

                nextButton.addEventListener('click', function () {
                    swiper2.slideNext(); // Chuyển đến slide kế tiếp trong phần 2
                });

                backButton.addEventListener('click', function () {
                    swiper2.slidePrev(); // Chuyển đến slide trước trong phần 2
                });
            });
        </script>
    </body>

</html>