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
        <title>Order</title>
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


            span.custom-button {
                display: inline-block;
                background-color: coral;
                border-radius: 10px;
                color: black;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                font-size: 14px;
                border-radius: 5px;
                width: 100px;
                height: 25px;
                transition: background-color 0.3s ease;
            }

            span.custom-button:hover {
                background-color: orange;
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
                <h2>Order</h2>

                <br>

                <div class="table-data" style="display: ${requestScope.listP}">

                    <div class="order">
                        <div class="head" style="justify-content: space-between">
                            <ul class="nav nav-tabs">
                                <li class="nav-item">
                                    <a  class="nav-link ${requestScope.table=="all"?"active":""}" aria-current="page" href="managerorder?table=all&filter=new&page=1" >All Order</a>
                                </li>
                                <c:forEach items="${requestScope.list_status}" var="s">
                                    <li class="nav-item">
                                        <a  class="nav-link ${requestScope.table==s.orStatusName?"active":""}" aria-current="page" href="managerorder?table=${s.orStatusName}&filter=${requestScope.filter==null?"new":requestScope.filter}&page=1">${s.orStatusName}</a>
                                    </li>
                                </c:forEach>
                            </ul>



                        </div>


                        <h6 class="mt-1">There are ${requestScope.size} orders</h6>
                        <p style="color: red">${requestScope.error1}</p>
                        <p style="color: red"> ${requestScope.error2}</p>
                        <br>
                        <div class="row justify-content-center">
                            <div class="col-8">
                                <form action="../view/searchOrder" method="get" onsubmit="event.preventDefault(); submitForm();" style="display: ">

                                    <div class="container justify-content-center">
                                        <input type="hidden" name="table" value="${requestScope.table}">
                                        <input placeholder="Search for order ID."  class="input" name="txt" type="text" value="" >
                                        <div class="icon">
                                            <svg viewBox="0 0 512 512" class="ionicon" xmlns="http://www.w3.org/2000/type="submit"svg">
                                            <title>Search</title>
                                            <path stroke-width="32" stroke-miterlimit="10" stroke="currentColor" fill="none" d="M221.09 64a157.09 157.09 0 10157.09 157.09A157.1 157.1 0 00221.09 64z"></path>
                                            <path d="M338.29 338.29L448 448" stroke-width="32" stroke-miterlimit="10" stroke-linecap="round" stroke="currentColor" fill="none"></path>
                                            </svg>
                                        </div>
                                    </div>
                                    <input type="submit" hidden="">
                                </form>
                            </div>
                            <div class="col-2 text-center" style="margin: auto">
                                <div class="dropdown ">
                                    <button  class=" dropdown-toggle px-3" data-bs-toggle="dropdown" aria-expanded="false" style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);">
                                        <span class="p-3" >Filter</span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <c:if test="${requestScope.list_order != null}">
                                            <li><a class="dropdown-item" href="managerorder?table=${requestScope.table}&filter=new&page=1">New</a></li>
                                            <li><a class="dropdown-item" href="managerorder?table=${requestScope.table}&filter=high&page=1">High to low</a></li>
                                            <li><a class="dropdown-item" href="managerorder?table=${requestScope.table}&filter=low&page=1">Low to High</a></li>
                                            </c:if> 
                                            <c:if test="${requestScope.list_search != null}">
                                            <li><a class="dropdown-item" href="searchOrder?table=${requestScope.table}&txt=${requestScope.key}&filter=new&page=1">New</a></li>
                                            <li><a class="dropdown-item" href="searchOrder?table=${requestScope.table}&txt=${requestScope.key}&filter=high&page=1">High to low</a></li>
                                            <li><a class="dropdown-item" href="searchOrder?table=${requestScope.table}&txt=${requestScope.key}&filter=low&page=1">Low to High</a></li>
                                            </c:if>
                                    </ul>
                                </div>

                            </div>

                            <div class="col-2 text-center" style="margin: auto">
                                <div class="dropdown">
                                    <button  class=" dropdown-toggle px-3" data-bs-toggle="dropdown" aria-expanded="false" style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);">
                                        <span  >Filter By Date</span>
                                    </button>
                                    <ul class="dropdown-menu p-3">
                                        <form action="../view/managerorder" method="post">
                                            <input type="hidden" name="table" value="${requestScope.table}">
                                            <input type="hidden" name="page" value="${requestScope.page}">
                                            <label class="my-2" for="startDate">Start Date:</label>
                                            <input style=" border-radius: 4px;padding: 0px 5px 0px 5px;" type="date" id="startDate" name="startDate" required="">
                                            <br>
                                            <label class="my-2" for="endDate">End Date:</label>
                                            <input style=" border-radius: 4px;padding: 0px 5px 0px 5px;" style=" border-radius: 4px;" type="date" id="endDate" name="endDate" required="">
                                            <br>
                                            <input style=" border-radius: 4px;padding: 0px 5px 0px 5px;" class="my-2 " type="submit" value="Search" >
                                        </form>
                                    </ul>
                                </div>
                            </div>           
                        </div>
                        <br>
                        <table>
                            <thead>
                                <tr>
                                    <th>Order ID</th>
                                    <th>Customer</th>
                                    <th style="text-align: center">Order date</th>
                                    <th style="text-align: center">Total price</th>
                                    <th style="text-align: center">Payment</th>
                                    <th style="text-align: center">Status</th>
                                    <th style="text-align: center">View Detail</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${requestScope.list_order!=null}">
                                    <c:forEach items="${requestScope.list_order}" var="o">
                                        <tr class="content-table">
                                            <td>${o.orID}</td>
                                            <td>${o.gmail}</td>
                                            <td style="text-align: center">${o.orDate}</td>
                                            <td style="text-align: center">
                                                <b style="font-size: 12px;color: red ">

                                                    <fmt:formatNumber type="number" pattern="###,###₫" value="${o.totalMoney}" />
                                                </b></td>
                                            <td style="text-align: center">Cash</td>
                                            <c:forEach items="${requestScope.list_status}" var="s">
                                                <c:if test="${o.orStatusID==s.orStatusID}">
                                                    <c:if test="${s.orStatusID==1}">
                                                        <td style="text-align: center"><span class="custom-button" style="background-color: coral;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==2}">
                                                        <td style="text-align: center"><span class="custom-button" style="background-color: yellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==3}">
                                                        <td style="text-align: center"><span class="custom-button" style="background-color: #008bff;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==4}">
                                                        <td style="text-align: center"><span class="custom-button" style="background-color: greenyellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==5}">
                                                        <td style="text-align: center"><span class="custom-button" style="background-color: red;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            <td style="text-align: center"><i class=""></i>
                                                <a href="orderDetail?orID=${o.orID}">  <button class="p-1" style="border-radius: 4px;box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);">View</button></a></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>


                                <c:if test="${requestScope.list_search!=null}">
                                    <c:forEach items="${requestScope.list_search}" var="o">
                                        <tr class="content-table">
                                            <td>${o.orID}</td>
                                            <td>${o.gmail}</td>
                                            <td style="text-align: center">${o.orDate}</td>
                                            <td style="text-align: center">
                                                <b style="font-size: 12px;color: red ">
                                                    <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                                                    <fmt:formatNumber type="number" pattern="###,###₫" value="${o.totalMoney}" />
                                                </b>
                                            </td>

                                            <td style="text-align: center">Cash</td>
                                            <c:forEach items="${requestScope.list_status}" var="s">
                                                <c:if test="${o.orStatusID==s.orStatusID}">
                                                    <c:if test="${s.orStatusID==1}">
                                                        <td style="text-align: center"><span style="background-color: coral;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==2}">
                                                        <td style="text-align: center"><span style="background-color: yellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==3}">
                                                        <td style="text-align: center"><span style="background-color: #008bff;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==4}">
                                                        <td style="text-align: center"><span style="background-color: greenyellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==5}">
                                                        <td style="text-align: center"><span style="background-color: red;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            <td style="text-align: center"><i class=""></i>
                                                <a href="orderDetail?orID=${o.orID}">  <button class="p-1">View</button></a></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${requestScope.list_order_date!=null}">
                                    <c:forEach items="${requestScope.list_order_date}" var="o">
                                        <tr class="content-table">
                                            <td>${o.orID}</td>
                                            <td>${o.gmail}</td>
                                            <td style="text-align: center">${o.orDate}</td>
                                            <td style="text-align: center">${o.totalMoney}</td>
                                            <td style="text-align: center">Cash</td>
                                            <c:forEach items="${requestScope.list_status}" var="s">
                                                <c:if test="${o.orStatusID==s.orStatusID}">
                                                    <c:if test="${s.orStatusID==1}">
                                                        <td style="text-align: center"><span style="background-color: coral;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==2}">
                                                        <td style="text-align: center"><span style="background-color: yellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==3}">
                                                        <td style="text-align: center"><span style="background-color: #008bff;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==4}">
                                                        <td style="text-align: center"><span style="background-color: greenyellow;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                        <c:if test="${s.orStatusID==5}">
                                                        <td style="text-align: center"><span style="background-color: red;border-radius: 10px;padding: 2px;">${s.orStatusName}</span></td>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            <td style="text-align: center"><i class=""></i>
                                                <a href="orderDetail?orID=${o.orID}">  <button class="p-1">View</button></a></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>      
                            </tbody>




                        </table>

                    </div>

                </div>


                <br>
                <div  style="float:  right; text-align: center">
                    <div class="pagination" style="margin: auto">
                        <c:if test="${requestScope.page>1}">
                            <a href="../view/managerorder?table=all&filter=new&page=${requestScope.page-1}">&laquo;</a>
                        </c:if>
                        <c:forEach begin="1" end="${requestScope.index}" var="o">
                            <a class="${requestScope.page == o? "active" : ""}" href="../view/managerorder?table=all&filter=new&page=${o}">${o}</a>
                        </c:forEach>
                        <c:if test="${requestScope.page<requestScope.index}">
                            <a href="../view/managerorder?table=all&filter=new&page=${requestScope.page+1}">&raquo;</a>
                        </c:if>
                    </div>
                </div> 







                <h4 style="text-align: center; margin-top: 20px; font-weight: 200">${requestScope.Message}</h4>
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
    <script src="../js/MaketingPage.js"></script>
</html>
