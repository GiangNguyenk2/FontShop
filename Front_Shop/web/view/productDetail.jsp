<%-- 
    Document   : productDetail
    Created on : May 20, 2023, 5:37:55 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../stylesheet/productDetail.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <link rel=”stylesheet” href=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css”> <script
        src=”https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js”></script> <script
        src=”https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js”></script> <script
        src=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js”></script> <!-- Load an icon
        library -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">
        <style>
            .user-product-ratings {
                margin-bottom: 20px;
            }

            .user-avatar img {
                width: 30px;
                height: 30px;
                border-radius: 50%;
            }

            .user-product-ratings-main {
                margin-left: 15px;
            }

            .user_name h4 {
                margin: 0;
                font-size: 18px;
                font-weight: bold;
            }

            .user_ratings_star {
                margin-top: 10px;
            }

            .user_ratings_star .fa-star {
                font-size: 20px;
            }

            .user_comment span {
                display: block;
                margin-top: 10px;
            }
        </style>
    </head> 
    <body>



        <jsp:include page="../components/Menu.jsp"></jsp:include>


            <section class="container sproduct my-2 pt-2">
                <div class="row mt-3 d-flex justify-content-center">
                    <div class="col-lg-4 col-md-12 col-12">

                        <img class="img-fluid w-100 pb-1" id="MainImg"
                             src="../${requestScope.pro_img.proImg}" alt="">

                    <div class="small-img-group ">
                        <c:forEach items="${requestScope.list_img}" var="i">
                            <div class="small-img-col ">
                                <img src="../${i.proImg}" width="75%" class="small-img" alt="">
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12 col-12">
                    <c:set var= "p" value="${requestScope.product}" />
                    <h3 class="py-4">${p.proName}</h3>

                    <c:set var="price" value="${p.proPrice}" />
                    <h4  style="color: red;font-size: 22px"><b>
                            <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                            <fmt:formatNumber type="number" pattern="###,###₫" value="${price}" />
                        </b></h4>
                    <hr/>
                    <h6>(*Select full information!)</h6>
                    &emsp;
                    <div class="row product-color flex align-items-center">
                        <!-- form color -->


                        <h5 class="col-4">Color</h5>
                        <c:forEach items="${requestScope.list_color}" var="o"> 
                            <c:forEach items="${requestScope.size_default}" var="a">
                                <c:if test="${o.proColorID==a.proColorID}">
                                    <a href = "productDetail?proID=${requestScope.product.proID}&colorID=${o.proColorID}&sizeID=${a.proSizeID}&quantity=0" 
                                       class=" col-3 px-0 mx-2 text-center" name="colorID" type="button" style="border-bottom: 1px solid;border-radius: 10px;">
                                        <button style="${o.proColorID==requestScope.coID?"color:white;background-color: black;border-radius: 10px;":"color:black;background-color: white;border-radius: 10px;"}" class="px-0 py-0">${o.proColorName}</button>
                                    </a>   
                                </c:if>                     
                            </c:forEach> 
                        </c:forEach>

                    </div>
                    &nbsp;

                    <div class="row">
                        <h5 class="col-4 ">Size</h5>
                        <c:forEach items="${requestScope.list_stock}" var="o">
                            <a href="productDetail?proID=${requestScope.product.proID}&colorID=${o.proColorID}&sizeID=${o.proSizeID}&quantity=0" type="button" id="size" class="col-1 px-0 py-0 mx-1 text-center"  name="size"" value="${o.proSizeID}"> 
                                <button style="${o.proSizeID==requestScope.siID?"color:white;background-color: black;":"color:black;background-color: white;"}" class="px-0 py-0">${o.sizeName}</button>
                            </a>
                        </c:forEach>
                    </div>
                    &emsp;
                    <form method="post" action="../view/productDetail" id="myForm">

                        <div class="row product-quantity flex align-items-center ">
                            <h5 class="col-4">Quantity</h5> 
                            <input type="hidden" name="proID" value="${requestScope.product.proID}">
                            <input type="hidden" name="colorID" value="${requestScope.coID}">
                            <input type="hidden" name="sizeID" value="${requestScope.siID}">
                            <input type="number" id="quantity" class="col-2 px-0 mx-0 text-center" name="quantity" value="1" min="1" max="${requestScope.stock_quantity.quantity}" oninput="validateQuantity(this)" pattern="[0-9]*">

                            <h6 class="col-6 text-center mt-1" style="display: ${requestScope.stock_quantity.quantity==0?"none":""}"> There are ${requestScope.stock_quantity.quantity} products</h6>

                        </div>
                        &emsp;


                        <button type="submit" id="add-to-cart-button" class="buy-btn px-3"  disabled><span class="fa fa-cart-plus"></span> Add To Cart</button>


                    </form>
                    <span id="quantity-error" style="color: red; display: none;">Invalid quantity!</span>
                    <br> <br> 

                    <pre style="overflow: hidden; white-space: pre-wrap;word-wrap: break-word;">

                      <p>${requestScope.product.proDetail}</p>
                       
                    </pre>

                </div>
            </div>

            <section id="featured" class="my-5 pb-5">
                <div class="container text-center mt-5 py-5">
                    <h3>Related products</h3>
                    <hr class="mx-auto">
                    <p>Products related to your choice</p>
                </div>
                <div class="row mx-auto container-fluid">
                    <c:forEach items="${requestScope.list_4_img}" var="i">

                        <div class="product text-center col-lg-3 col-md-4 col-12">
                            <c:forEach items="${requestScope.list_stock_4}" var="m">
                                <c:if test="${i.proID==m.proID}">
                                    <a href="productDetail?proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0"><img class="img-fluid mb-3 w-75" src="../${i.proImg}" alt=""></a> 
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${requestScope.list_4}" var="o">
                                    <c:forEach items="${requestScope.list_stock_4}" var="m">
                                        <c:if test="${i.proID==m.proID}">
                                        <a href="productDetail?proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0"> <h5>${o.proID==i.proID?o.proName:""}</a>
                                    </c:if>
                                </c:forEach>
                                <h6 style="color: red;"><b>${o.proID==i.proID?o.proPrice:""} ${o.proID==i.proID?"VND":""}</b></h6>
                            </c:forEach>
                        </div>

                    </c:forEach>
                </div>
            </section>
        </section>

        <!-- Đánh giá sản phẩm -->
        <div class="row product-ratings justify-content-center">
            <div class="col-12 product-ratings-header text-center">
                <h4 class="">Feedback</h4>
                <hr class="mx-auto" style="width: 80%">
            </div>
            <div class=" col-7 product-ratings-list d-block" style="opacity: 1;height: 300px;overflow-y: scroll;overflow-x: hidden;">
                <c:forEach items="${requestScope.list_feedback}" var="b">
                    <!-- danh gia cua moi nguoi-->
                    <div class="row user-product-ratings d-flex justify-content-start">
                        <div class="col-1 user-avatar">
                            <img class="w-75"
                                 src="../img/user_avatar.jpg">
                        </div>
                        <div class="col-6 user-product-ratings-main">
                            <div class="user_name">
                                <h4>${b.name}</h4>
                            </div>

                            <div class="user_ratings_star">
                                <c:if test="${b.rateStar==5}">
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                </c:if>
                                <c:if test="${b.rateStar==4}">
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>

                                </c:if>
                                <c:if test="${b.rateStar==3}">
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>

                                </c:if>
                                <c:if test="${b.rateStar==2}">
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>

                                </c:if>
                                <c:if test="${b.rateStar==1}">
                                    <div style="color: rgb(211, 42, 42);" class="fa fa-star"></div>

                                </c:if>
                            </div>

                            <div class="user_comment">
                                <span>${b.feedback}</span>
                            </div>
                        </div>
                    </div>
                            <hr>
                </c:forEach>
            </div>
        </div>




        <script>
            var addToCartButton = document.getElementById("add-to-cart-button");
            addToCartButton.addEventListener('click', function () {
                event.preventDefault();
                // Hiển thị thông báo khi button được nhấn
                if (confirm("Sản phẩm đã được thêm vào giỏ hàng thành công!")) {
                    var form = document.getElementById("myForm");
                    // Submit form
                    form.submit();
                }
            });



        </script>
        <jsp:include page="../components/Footer.jsp"></jsp:include>
            <script>
                var MainImg = document.getElementById('MainImg');
                var smallImg = document.getElementsByClassName('small-img');

                smallImg[0].onclick = function () {
                    MainImg.src = smallImg[0].src;
                }
                smallImg[1].onclick = function () {
                    MainImg.src = smallImg[1].src;
                }
                smallImg[2].onclick = function () {
                    MainImg.src = smallImg[2].src;
                }
                smallImg[3].onclick = function () {
                    MainImg.src = smallImg[3].src;
                }


            </script>

            <script>

                function maxLengthCheck(object)
                {
                    if (object.value.length > object.maxLength)
                        object.value = object.value.slice(0, object.maxLength);
                }
            </script>
            <script>
                var daLoadLai = true;
                document.addEventListener('DOMContentLoaded', function () {
                    if (daLoadLai) {
                        if (${requestScope.loadPage}) {
                            window.location.href = "productDetail?proID=${requestScope.proId}&colorID=${requestScope.coID}&sizeID=${requestScope.siID}&quantity=0"; // Thay thế "newpage.jsp" bằng đường dẫn của trang JSP bạn muốn chuyển đến
                            daLoadLai = false;
                        } else {
                            daLoadLai = false;
                        }
                    }
                });
        </script>
        <script>
            function validateQuantity(input) {
                var min = parseInt(input.min);
                var max = parseInt(input.max);
                var value = parseInt(input.value);

                var errorElement = document.getElementById("quantity-error");
                var addToCartButton = document.getElementById("add-to-cart-button");

                if (value < min || value > max) {
                    errorElement.style.display = "inline";
                    addToCartButton.disabled = true;
                } else {
                    errorElement.style.display = "none";
                    addToCartButton.disabled = false;
                }
            }


            document.addEventListener("DOMContentLoaded", function () {
                var quantityInput = document.getElementById("quantity");
                validateQuantity(quantityInput); // Kiểm tra giá trị quantity ban đầu

                quantityInput.addEventListener("input", function () {
                    validateQuantity(quantityInput);
                });
            });
        </script>

    </body>
