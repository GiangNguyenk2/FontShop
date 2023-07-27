<%-- 
    Document   : Cart
    Created on : Jun 3, 2023, 11:02:57 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">    
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../stylesheet/cart.css">
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
            .quantity-button {
                width: 100%;
                padding: 5px 10px;
                background-color: #f5f5f5;
                border: 1px solid #ddd;
                font-size: 16px;
                color: #555;
                cursor: pointer;
            }

            .quantity-button:hover {
                background-color: #e0e0e0;
            }
        </style>
    </head> 

    <body>
        <jsp:include page="../components/Menu.jsp"></jsp:include>

            <section class="vh-100 mt-5" style="background-color: white;">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col">
                            <p><span class="h2">Shopping Cart </span><span class="h4">(${requestScope.size_cart} products in shopping cart)</span></p>
                        <div class="product-container mt-5">
                            <ul class="product-list">
                                <c:if test="${requestScope.size_cart==0}">
                                    <p>There are no products in the cart.</p>
                                </c:if>
                                   
                                <c:forEach items="${requestScope.list_item}" var="i">
                                    <li class="product">
                                        <div class="card mb-4">
                                            <div class="card-body p-4">

                                                <div class="row align-items-center">
                                                    <div class="col-md-2">
                                                        <c:forEach items="${requestScope.list_img}" var="o">
                                                            <c:if test="${i.product.proID==o.proID}">
                                                                <img src="../${o.proImg}"
                                                                     class="img-fluid" alt="Generic placeholder image">
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="col-md-2 d-flex justify-content-center">
                                                        <div>
                                                            <p class="small text-muted mb-4 pb-2">Name</p>
                                                            <p class="lead fw-normal mb-0">${i.product.proName}</p>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1 d-flex justify-content-center">
                                                        <div>
                                                            <p class="small text-muted mb-4 pb-2">Color</p>
                                                            <c:forEach items="${requestScope.stock}" var="o">
                                                                <c:if test="${i.product.proID==o.proID}">
                                                                    <c:if test="${i.colorID==o.proColorID}">
                                                                        <c:if test="${i.sizeID==o.proSizeID}">
                                                                            <p class="lead fw-normal mb-0"><i></i>
                                                                                ${o.proColorName}</p>
                                                                            </c:if></c:if></c:if>
                                                                </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1 d-flex justify-content-center">
                                                        <div>
                                                            <p class="small text-muted mb-4 pb-2">Size</p>
                                                            <c:forEach items="${requestScope.stock}" var="o">
                                                                <c:if test="${i.product.proID==o.proID}">
                                                                    <c:if test="${i.colorID==o.proColorID}">
                                                                        <c:if test="${i.sizeID==o.proSizeID}">
                                                                            <p class="lead fw-normal mb-0"><i></i>
                                                                                ${o.sizeName} </p>
                                                                            </c:if></c:if></c:if>
                                                                </c:forEach>
                                                        </div>
                                                    </div>
                                                    <c:forEach items="${requestScope.stock}" var="o">
                                                        <c:if test="${i.product.proID==o.proID}">
                                                            <c:if test="${i.colorID==o.proColorID}">
                                                                <c:if test="${i.sizeID==o.proSizeID}">
                                                                    <c:set var="input_max" value="${o.quantity}"></c:set>

                                                                </c:if></c:if></c:if>
                                                    </c:forEach>

                                                    <div  class="col-md-2 d-flex justify-content-center">
                                                        <div class="justify-content-center">
                                                            <p class="small text-muted mb-4 pb-2">Quantity</p> 
                                                            <div class="row d-flex ">
                                                                <!--tang giam -->
                                                                <a class="col-2 button-change" href="cart?proID=${i.product.proID}&colorID=${i.colorID}&sizeID=${i.sizeID}&num=${i.quantity-1}">
                                                                    <button class="quantity-button">-</button>
                                                                </a>

                                                                <input class="col-5"  type="text" id="volumes" min="1" max="${requestScope.maxValue}" value="${i.quantity}">

                                                                <a class="col-2 button-change" href="cart?proID=${i.product.proID}&colorID=${i.colorID}&sizeID=${i.sizeID}&num=${i.quantity+1 <= input_max ? i.quantity+1 : input_max}">
                                                                    <button class="quantity-button">+</button>
                                                                </a>
                                                                     <!--ket thuc tang giam -->
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1 d-flex justify-content-center">
                                                        <div>
                                                            <p class="small text-muted mb-4 pb-2">Price</p>
                                                            <p class="lead fw-normal mb-0">${i.price} </p>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2 d-flex justify-content-center">
                                                        <div>
                                                            <p class="small text-muted mb-4 pb-2">Total </p>
                                                            <p class="lead fw-normal mb-0">${i.quantity*i.price} </p>
                                                        </div>
                                                    </div>
                                                    <form method="post" action="cart" class="col-md-1" onsubmit="return confirmDelete()">
                                                        <input type="hidden" name="proID" value="${i.product.proID}">
                                                        <input type="hidden" name="colorID" value="${i.colorID}">
                                                        <input type="hidden" name="sizeID" value="${i.sizeID}">

                                                        <button style="background-color: white;border: 0;" class="btn btn-danger" type="submit">
                                                            <span id="boot-icon" class="bi bi-trash" style="font-size: 20px; color: rgb(0, 0, 0);"></span>
                                                        </button>
                                                    </form>
                                                </div>

                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <c:if test="${requestScope.size_cart>0}">
                            <div class="card mb-5">
                                <div class="card-body p-4">

                                    <div class="float-end">
                                        <p class="mb-0 me-5 d-flex align-items-center">
                                            <span class="small text-muted me-2">Total order amount:</span> <span
                                                class="lead fw-normal">${requestScope.total}</span>
                                        </p>
                                    </div>

                                </div>
                            </div>
                        </c:if>
                        <div class="d-flex justify-content-end">
                            <a style="width: 200px;height: 30px;" href="../view/shopAll?caID=0&page=1&sort=new"><button style="font-size: 15px" type="button" class="btn btn-light btn-lg me-3 mr-2">Back</button></a> 
                            <c:if test="${requestScope.size_cart>0}">
                                <c:if test="${sessionScope.account != null}" >
                                    <a style="width: 200px;height: 30px;" href="../view/checkout"><button style="font-size: 15px;" type="button" class="btn btn-primary btn-lg mx-2">Check out</button></a>
                                </c:if>

                            </c:if>
                            <c:if test="${requestScope.size_cart>0}">
                                <c:if test="${sessionScope.account == null}" >
                                    <a style="width: 200px;height: 30px;" href="../view/Login.jsp"><button style="font-size: 15px;" type="button" class="btn btn-primary btn-lg mx-2">Check out</button></a>
                                </c:if>

                            </c:if>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <div style="margin-bottom: 100px">

        </div>                           
        <jsp:include page="../components/Footer.jsp"></jsp:include>
        </body>
        <script>
            function decreaseVolume() {
                var volume = document.getElementById("volumes");
                if (volume.value > 1) {
                    volume.value--;
                }
            }

            function increaseVolume() {
                var volume = document.getElementById("volumes");
                if (volume.value < ${input_max}) {
                    volume.value++;
                }
            }

    </script>
    <script>
        var input = document.getElementById('volumes');

// Gắn sự kiện 'input' để kiểm tra dữ liệu đầu vào khi người dùng nhập
        input.addEventListener('input', function () {
            // Lấy giá trị nhập vào
            var value = parseFloat(input.value);

            // Kiểm tra nếu giá trị không nằm trong khoảng từ 0 đến max
            if (isNaN(value) || value < 0 || value > ${input_max}) {
                // Nếu không hợp lệ, xóa giá trị nhập và đặt lại giá trị mặc định
                input.value = '';
            }
        });
    </script>
    <script>
        function confirmDelete() {
            var confirmation = confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?");
            return confirmation;
        }
    </script>
</html>
