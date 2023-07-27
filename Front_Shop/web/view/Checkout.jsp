<%-- 
    Document   : Checkout
    Created on : Jun 3, 2023, 6:50:40 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Checkout</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
    </head>
    <body>
        <jsp:include page="../components/Menu.jsp"></jsp:include>
            <section class="h-100 h-custom" style="background-color: white;">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8 bg-grey">
                                        <div class="p-5">
                                            <p class="lead">*Please check Customer information, Order information before placing an Order.</p>
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Customer information</h3>
                                            <p>Full Name</p>
                                            <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                                   value="${sessionScope.account.name}" readonly="">

                                        <p class="mt-2">Gender</p>
                                        <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                               value="${sessionScope.account.gender==true?"Nam":"Nữ"}" readonly="">
                                        <p class="mt-2">Gmail</p>
                                        <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                               value="${sessionScope.account.gmail}" readonly="" >
                                        <hr class="my-4">


                                        <form action="checkout" method="post" id="myForm" onsubmit="return false;">
                                            <h5 class="text-uppercase mb-3">Address</h5>
                                            <c:forEach items="${requestScope.list_address}" var="a">
                                                <input type="radio" name="address" value="${a}">${a}<br/>
                                            </c:forEach>


                                            <br/><br/><br/>
                                            <input type="radio" name="address" value="new" onclick="showInfo()">Add new address
                                            <br/><br/>
                                            <div id="info" style="display: none;">
                                                <!-- Nội dung thông tin -->
                                                <span>(*)</span>
                                                <select name="tinh" id="city" >
                                                    <option value="" selected >Select province</option>           
                                                </select>
                                                <span>(*)</span>
                                                <select name="huyen" id="district" >
                                                    <option value="" selected>Select district</option>
                                                </select>
                                                <span>(*)</span>
                                                <select name="xa" id="ward" >
                                                    <option value="" selected>Select ward</option>
                                                </select>
                                                <li>(*) Home Address:</li>
                                                <li> <input style="width: 100%" type="text" name="nha" ></li>
                                            </div>             

                                    </div>

                                    <div>


                                        <p>Enter your phone number:</p>
                                        <input  type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="phone" pattern="^(\\+?84|0)(3[2-9]|5[2689]|7[06789]|8[1-689]|9[0-9])([0-9]{7})$" 
                                                placeholder="Phone" >


                                        <hr class="my-4">
                                        <h6 class="text-uppercase">Payment methods:</h6>
                                        <input type="radio" name="tt" value="off" checked > Payment on delivery.<br/>
                                        

                                        <hr class="my-4">
                                        <div class=" justify-content-center mb-5">
                                            <h6 class="text-uppercase">Total order price:</h6> <p>${requestScope.tien}</p> <br/>
                                           
                                            <div class="d-flex justify-content-between">

                                                <b style="font-size: 30px;color: red ">
                                                    <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                                                    <fmt:formatNumber type="number" pattern="###,###₫" value="${requestScope.total}" />
                                                </b>
                                                
                                            </div>
                                        </div>


                                        <button onclick="submitForm()" type="submit" class=" btn btn-block" style="background-color: red">Order</button>
                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="p-2">
                                        <div class="d-flex justify-content-between align-items-center mb-5">
                                            <h3 class="fw-bold mb-0 text-black">Order</h3>
                                            <h6 class="mb-0 text-muted"> ${requestScope.size_cart} products</h6>
                                        </div>
                                        <hr class="my-4">

                                        <div class="product-container mt-5" style="overflow-x: hidden;">
                                            <ul class="product-list">
                                                <c:forEach items="${requestScope.list_item}" var="i">
                                                    <li class="product">
                                                        <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                                <c:forEach items="${requestScope.list_img}" var="o">
                                                                    <c:if test="${i.product.proID==o.proID}">
                                                                        <img src="../${o.proImg}"
                                                                             class="img-fluid" alt="Generic placeholder image">
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                            <div class="col-md-3 col-lg-3 col-xl-3">

                                                                <h6 class="text-black mb-0">${i.product.proName}</h6>
                                                            </div>
                                                            <div class="col-md-1 d-flex">
                                                                <p>${i.quantity} </p>
                                                            </div>
                                                            <div class="col-md-4 col-lg-2 col-xl-2 offset-lg-1">
                                                                <h6 class="mb-0">${i.quantity*i.price}</h6>
                                                            </div>

                                                        </div>
                                                        <hr class="my-4">
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                        <hr class="my-4">

                                        <div class="pt-5">
                                            <h6 class="mb-0"><a href="cart" class="text-body"><i
                                                        class="fas fa-long-arrow-alt-left me-2"></i>Back</a></h6>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="../components/Footer.jsp"></jsp:include>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
    <script>
                                            var citis = document.getElementById("city");
                                            var districts = document.getElementById("district");
                                            var wards = document.getElementById("ward");
                                            var Parameter = {
                                                url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
                                                method: "GET",
                                                responseType: "application/json",
                                            };
                                            var promise = axios(Parameter);
                                            promise.then(function (result) {
                                                renderCity(result.data);
                                            });

                                            function renderCity(data) {
                                                for (const x of data) {
                                                    var opt = document.createElement('option');
                                                    opt.value = x.Name;
                                                    opt.text = x.Name;
                                                    opt.setAttribute('data-id', x.Id);
                                                    citis.options.add(opt);
                                                }
                                                citis.onchange = function () {
                                                    district.length = 1;
                                                    ward.length = 1;
                                                    if (this.options[this.selectedIndex].dataset.id != "") {
                                                        const result = data.filter(n => n.Id === this.options[this.selectedIndex].dataset.id);

                                                        for (const k of result[0].Districts) {
                                                            var opt = document.createElement('option');
                                                            opt.value = k.Name;
                                                            opt.text = k.Name;
                                                            opt.setAttribute('data-id', k.Id);
                                                            district.options.add(opt);
                                                        }
                                                    }
                                                };
                                                district.onchange = function () {
                                                    ward.length = 1;
                                                    const dataCity = data.filter(n => n.Id === citis.options[citis.selectedIndex].dataset.id);
                                                    if (this.options[this.selectedIndex].dataset.id != "") {
                                                        const dataWards = dataCity[0].Districts.filter(n => n.Id === this.options[this.selectedIndex].dataset.id)[0].Wards;

                                                        for (const w of dataWards) {
                                                            var opt = document.createElement('option');
                                                            opt.value = w.Name;
                                                            opt.text = w.Name;
                                                            opt.setAttribute('data-id', w.Id);
                                                            wards.options.add(opt);
                                                        }
                                                    }
                                                };
                                            }
    </script>
    <script type="text/javascript">
        function showInfo() {
            var infoDiv = document.getElementById("info");
            infoDiv.style.display = "block";
        }


    </script>

    <script>
        function submitForm() {
            hasError = false;

            // Kiểm tra địa chỉ
            var selectedAddress = document.querySelector('input[name="address"]:checked').value;
            if (selectedAddress === 'new') {
                var city = document.getElementById('city').value;
                var district = document.getElementById('district').value;
                var ward = document.getElementById('ward').value;
                var homeAddress = document.querySelector('input[name="nha"]').value;

                if (!city || !district || !ward || !homeAddress) {
                    alert('Please enter the new address information');
                    hasError = true;
                    return;
                }
            }

            if (!selectedAddress) {
                alert('Please choose address!');
                hasError = true;
                return;
            }

            // Kiểm tra số điện thoại
            var phoneNumber = document.querySelector('input[name="phone"]').value;
            if (!phoneNumber) {
                alert('Please enter the phone number');
                hasError = true;
                return;
            } else {
                // Kiểm tra pattern số điện thoại
                var phonePattern = /^(\\+?84|0)(3[2-9]|5[2689]|7[06789]|8[1-689]|9[0-9])([0-9]{7})$/;
                if (!phonePattern.test(phoneNumber)) {
                    alert('invalid phone number');
                    hasError = true;
                    return;
                }
            }

            // Kiểm tra phương thức thanh toán
            var paymentMethod = document.querySelector('input[name="tt"]:checked');
            if (!paymentMethod) {
                alert('Please choose a payment method');
                hasError = true;
                return;
            }

            // Nếu không có lỗi, gửi biểu mẫu
            if (!hasError) {
                document.getElementById('myForm').submit();
            }
        }
    </script>

</html>
