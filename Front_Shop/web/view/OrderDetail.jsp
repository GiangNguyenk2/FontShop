<%-- 
    Document   : Order
    Created on : Jun 17, 2023, 12:47:29 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Boxicons -->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel=”stylesheet” href=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css”> <script
        src=”https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js”></script> <script
        src=”https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js”></script> <script
        src=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js”></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/stockManage.css">
        <title>Order Detail</title>
        <style>
            .pagination a {
                color: black;
                float: left;
                padding: 4px 9px;
                text-decoration: none;
                transition: background-color .3s;
                border-radius: 10px;
            }
            .pagination a.active {
                background-color: black;
                color: white;
                border-radius: 10px;
                font-weight: bold;
            }
            .pagination a:hover:not(.active) {
                background-color: #b0b0b0;
                border-radius: 10px;
                font-weight: bolder;
            }

            .container {
                position: relative;
                --size-button: 30px;
            }

            .input {
                padding-left: var(--size-button);
                height: var(--size-button);
                font-size: 13px;
                border: none;
                color: black;
                outline: none;
                width: var(--size-button);
                transition: all ease 0.3s;
                background-color: #EFEFEF;

                border-radius: 50px;
                cursor: pointer;
            }

            .input:focus,
            .input:not(:invalid) {
                width: 100%;
                height: 40px;
                cursor: text;

            }

            .input:focus + .icon,
            .input:not(:invalid) + .icon {
                pointer-events: all;
                cursor: pointer;
            }

            .container .icon {
                color: black;
                position: absolute;
                width: var(--size-button);
                height: var(--size-button);
                top: 0;
                left: 0;
                padding: 7px;
                pointer-events: none;
            }

            .container .icon svg {
                width: 100%;
                height: 100%;
            }

            .ca a{
                font-size: 13px;
                color: black;
                border-bottom: 2px solid black;
                border-radius:10px;
                padding:0 5px;
                font-weight: 600;
                margin: 0 5px
            }
            .caName:hover{
                font-weight: 600;
                font-size:large;
            }

            .popup-overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;

                display: none;
                justify-content: center;
                align-items: center;

            }

            .popup-content {
                background-color: #FFF;
                padding: 20px;
                max-width: 400px;
                border-radius: 5px;
                border: 2px dotted black;
            }

            .close-button {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
            }

            #sidebar .side-menu {
                width: 100%;
                margin-top: 48px;
                padding: 0px;
            }


            .content input{
                border-radius: 4px;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
                padding: 5px 5px;
            }
            .content area{
                border-radius: 4px;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
                padding: 5px 5px;
            }


        </style>
    </head>
    <body>
        <!-- SIDEBAR -->
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param value="active" name="activeOrder"/> 
            <jsp:param name="hrefOrder" value="../view/managerorder?table=all&filter=new&page=1"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <input type="checkbox" id="switch-mode" hidden>
            </nav>
            <!-- NAVBAR -->
            <!-- MAIN -->
            <main style="padding-top: 40px">
                <h2>Order Detail</h2>
                <br>
                <a href="managerorder?table=all&filter=new&page=1"><button style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);padding: 5px">Back Order</button></a>
                <br><br>
                <div class="row">
                    <!--Bang thong tin -->
                    <div class="col-10">
                        <div class="table-data">

                            <div class="order">
                                <h3>Order ${requestScope.order.orID} Detail</h3><br>
                                <div class="row" style="justify-content: start">

                                    <div class="col-4 content">
                                        <p><b>General Details</b></p>
                                        <ul class="px-0">
                                            <li>Order date</li>
                                            <input type="text" readonly="" value="${requestScope.order.orDate}">
                                            <li>Order status</li>
                                            <input type="text" readonly="" value="${requestScope.status.orStatusName}">
                                            <li>Customer Name</li>
                                            <input type="text" readonly="" value="${requestScope.acc.name}">
                                        </ul>
                                    </div>

                                    <div class="col-4 content">
                                        <p><b>Billing Details</b></p>
                                        <ul class="px-0">
                                            <li>Order ID</li>
                                            <input type="text" readonly="" class="w-100" value="${requestScope.order.orID}">
                                            <li>Gmail</li>
                                            <input type="text" readonly="" class="w-100" value="${requestScope.order.gmail}">
                                            <li>Phone </li>
                                            <input type="text" readonly="" class="w-100" value="${requestScope.add.phone}">
                                            <li>Total Price</li>

                                            <input type="text" readonly="" class="w-100" value="<fmt:formatNumber type="number" pattern="###,###₫" value="${requestScope.order.totalMoney}" />">
                                            <li>Payment </li>
                                            <input type="text" readonly="" class="w-100" value="Cash">
                                            <li>Address</li>
                                            <textarea style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);" class="w-100" style="height: 100px" readonly="">${requestScope.address}</textarea>
                                        </ul>
                                    </div>
                                    <!--  <div class="col-4 content">
                                          <p><b>Shipping Address</b></p>
                                          <ul class="px-0">
                                              <li>Address </li>
                                              <textarea style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);" class="w-100" style="height: 100px" readonly="">${requestScope.address}</textarea>
                                          </ul>
                                      </div>--> 
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Bang update status -->
                    <div class="col-2">
                        <div class="order">
                            <div class="table-data">
                                <div class="order text-center" >
                                    <h5>Update Order Status</h5>
                                    <c:if test="${requestScope.order.orStatusID!=4 && requestScope.order.orStatusID!=5}">
                                        <form method="post" action="orderDetail" id="myForm"> 
                                            <input type="hidden" name="orID" value="${requestScope.order.orID==null?requestScope.orID_post:requestScope.order.orID}">
                                            <select name="status_order" id="mySelect">
                                                <c:forEach items="${requestScope.list_status}" var="d">
                                                    <option style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);" value="${d.orStatusID}" ${d.orStatusID==requestScope.order.orStatusID?"selected":""}>${d.orStatusName}</option>
                                                </c:forEach>
                                            </select>
                                            <br><br>
                                            <input style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);" type="submit" value="Save">
                                        </form> 
                                    </c:if> 
                                    <c:if test="${requestScope.order.orStatusID==4}">
                                        <span><b style="color: green">Order Success!</b></span>
                                    </c:if>
                                    <c:if test="${requestScope.order.orStatusID==5}">
                                        <span><b style="color: red">Order Canceled!</b></span>
                                    </c:if>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--bang list cac items -->


                <div class="table-data mt-3 ">
                    <div class="order">
                        <div class="row">
                            <span>There are ${requestScope.size} products in the bill</span>
                            <c:forEach items="${requestScope.list_order_detail}" var="m">
                                <c:forEach items="${requestScope.list_stock}" var="s">
                                    <c:if test="${m.stockID==s.stockID}">
                                        <div class= "col-10" >
                                            <li class="product">
                                                <div class="card mb-4">
                                                    <div class="card-body p-4">

                                                        <div class="row align-items-center">
                                                            <div class="col-md-2">
                                                                <c:forEach items="${requestScope.list_img}" var="o">
                                                                    <c:if test="${s.proID==o.proID}">
                                                                        <img src="../${o.proImg}"
                                                                             class="img-fluid" alt="Generic placeholder image">
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                            <div class="col-md-2 d-flex justify-content-center">
                                                                <div>
                                                                    <p class="small text-muted mb-4 pb-2">Name</p>
                                                                    <c:forEach items="${requestScope.list_product}" var="p">

                                                                        <c:if test="${s.proID==p.proID}">
                                                                            <p class="lead fw-normal mb-0">${p.proName}</p>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1 d-flex justify-content-center">
                                                                <div>
                                                                    <p class="small text-muted mb-4 pb-2">Color</p>

                                                                    <p class="lead fw-normal mb-0"><i></i>
                                                                        ${s.proColorName}</p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1 d-flex justify-content-center">
                                                                <div>
                                                                    <p class="small text-muted mb-4 pb-2">Size</p>

                                                                    <p class="lead fw-normal mb-0"><i></i>
                                                                        ${s.sizeName} </p>

                                                                </div>
                                                            </div>
                                                            <div  class="col-md-2 d-flex justify-content-center">
                                                                <div class="justify-content-center">
                                                                    <p class="small text-muted mb-4 pb-2">Quantity</p> 
                                                                    <p class="lead fw-normal mb-0"><i></i>
                                                                        ${m.quantity} </p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1 d-flex justify-content-center">
                                                                <div>
                                                                    <p class="small text-muted mb-4 pb-2">Price</p>
                                                                    <p class="lead fw-normal mb-0"><b style="font-size: 15px;color: red ">

                                                                            <fmt:formatNumber type="number" pattern="###,###₫" value="${m.price}" />
                                                                        </b> </p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2 d-flex justify-content-center">
                                                                <div>
                                                                    <p class="small text-muted mb-4 pb-2">Total</p>
                                                                    <p class="lead fw-normal mb-0"><b style="font-size: 15px;color: red ">

                                                                            <fmt:formatNumber type="number" pattern="###,###₫" value="${m.quantity*m.price}" />
                                                                        </b>
                                                                    </p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                        </div>
                                        <div class="col-2 text-center">
                                            <span style="margin-top: 50px">The number of products in stock is <br> <b style="font-size: 20px ">${s.quantity} </b></span>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </main>

            <!-- MAIN -->
        </section>
    </body>
    <script>
        function submitForm() {
            // Xử lý logic của việc submit form ở đây
            // Ví dụ: Gửi dữ liệu form đến server bằng Ajax hoặc refresh trang
            document.forms[0].submit(); // Submit form
        }
    </script>
    <script>
        // Lắng nghe sự kiện click khi thay đổi lựa chọn
        document.getElementById("myForm").addEventListener("submit", function () {
            if (confirm("Are you sure you want to change the selection?")) {
                // Xử lý khi xác nhận
                console.log("Selection has been changed");
            } else {
                // Xử lý khi không xác nhận
                console.log("Choices are not changed");
                // Đặt lại lựa chọn về giá trị ban đầu
                this.selectedIndex = 0;
            }
        });
    </script>

</html>
