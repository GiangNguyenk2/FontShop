<%-- 
    Document   : CustomerOrder
    Created on : Jun 2, 2023, 5:21:24 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Order Detail</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="../stylesheet/OrderDetail.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
            rel="stylesheet"
            />
        <!-- MDB -->


        <style>
            .hh-grayBox {
                background-color: #432d20;
                margin-bottom: 20px;
                padding: 35px;
                margin-top: 20px;
            }
            .pt45{
                padding-top:45px;
            }
            .order-tracking{
                text-align: center;
                width: 25%;
                position: relative;
                display: block;
            }
            .order-tracking .is-complete{
                display: block;
                position: relative;
                border-radius: 50%;
                height: 30px;
                width: 30px;
                border: 0px solid #000000;
                background-color: #A4A4A4;
                margin: 0 auto;
                transition: background 0.25s linear;
                -webkit-transition: background 0.25s linear;
                z-index: 2;
            }
            .order-tracking .is-complete:after {
                display: block;
                position: absolute;
                content: '';
                height: 14px;
                width: 7px;
                top: -2px;
                bottom: 0;
                left: 5px;
                margin: auto 0;
                border: 0px solid #008bff;
                border-width: 0px 2px 2px 0;
                transform: rotate(45deg);
                opacity: 0;
            }
            .order-tracking.completed .is-complete{
                border-color: #000000;
                border-width: 0px;
                background-color: #000000;
            }
            .order-tracking.completed .is-complete:after {
                border-color: #fff;
                border-width: 0px 3px 3px 0;
                width: 7px;
                left: 11px;
                opacity: 1;
            }
            .order-tracking p {
                color: #A4A4A4;
                font-size: 16px;
                margin-top: 8px;
                margin-bottom: 0;
                line-height: 20px;
            }
            .order-tracking p span{
                font-size: 14px;
            }
            .order-tracking.completed p{
                color: #000;
            }
            .order-tracking::before {
                content: '';
                display: block;
                height: 3px;
                width: calc(100% - 40px);
                background-color: #A4A4A4;
                top: 13px;
                position: absolute;
                left: calc(-50% + 20px);
                z-index: 0;
            }
            .order-tracking:first-child:before{
                display: none;
            }
            .order-tracking.completed:before{
                background-color: #000;
            }

        </style>
    </head>
    <body>
        <jsp:include page="../components/Menu.jsp"></jsp:include>

            <div style="justify-content: center; display: flex">
                <form action="userInfo?" method="get">
                    <input type="hidden" value="${sessionScope.account.gmail}" name="accId">

            </form>
            <form action="customerOrder" method="get">
                <input type="submit" value="History" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px">
            </form>
            <form action="updateProfile" method="post">
                <input type="submit" value="Update Profile" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px;margin-left: 10px">
            </form>

            <form action="changePassword" method="get">
                <input type="submit" value="Change Password"  style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-left: 10px">
            </form>

        </div>
        <h2 style="text-align: center; margin-top: 20px">Order Information</h2>
        <div class="container">
            <div class="row" style="">
                <div class="col-12 col-md-10 pt45 pb20" style="margin: auto; width: 90%">
                    <div class="row justify-content-between">
                        <div class="order-tracking  <c:if test="${requestScope.cusOrder.orStatusID == 1 ||requestScope.cusOrder.orStatusID == 2 
                                                                  ||requestScope.cusOrder.orStatusID == 3 
                                                                  || requestScope.cusOrder.orStatusID == 4}">completed</c:if>">
                                  <span class="is-complete"></span>
                                  <p>Pending</p>
                              </div>
                              <div class="order-tracking <c:if test="${requestScope.cusOrder.orStatusID == 2 ||requestScope.cusOrder.orStatusID == 3 ||requestScope.cusOrder.orStatusID == 4
                              }">completed</c:if>">
                                 <span class="is-complete"></span>
                                 <p>Confirmed</p>
                             </div>
                             <div class="order-tracking <c:if test="${requestScope.cusOrder.orStatusID == 3 ||requestScope.cusOrder.orStatusID == 4 
                              }">completed</c:if>">
                                 <span class="is-complete"></span>
                                 <p>Shipping</p>
                             </div>
                             <div class="order-tracking <c:if test="${requestScope.cusOrder.orStatusID == 4
                              }">completed</c:if>">
                                 <span class="is-complete "></span>
                                 <p>Complate</p>
                             </div>


                        </div>
                    </div>
                </div>
            </div>


            <div style="margin: auto; width: 90%; justify-content: center;display: flex; flex-wrap: wrap">
            <c:forEach items="${requestScope.orderDetail}" var="o">
                <div class="card">
                    <div class="card-border-top">
                    </div>
                    <div class="img">
                        <c:forEach items="${requestScope.list_img}" var="i">
                            <c:if test="${i.proID==o.proID}" >
                                <div style="width: 70px">
                                    <img src="../${i.proImg}"  style="width: 100%" >
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    <span > ${o.proName}</span>
                    <p class="job"> Quantity ${o.quantity}</p>
                    <div style="display: flex; justify-content: space-around; color: white">
                        <div>
                            <c:forEach items="${requestScope.list_Size}" var="e">
                                <c:if test="${e.sizeID==o.sizeID}" >
                                    <p class="job">Size: ${e.sizeName}</p>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div>
                            <c:forEach items="${requestScope.list_Color}" var="f">
                                <c:if test="${f.proColorID==o.colorID}" >
                                    <p class="job">Color: ${f.proColorName}</p>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <p class="job" style="margin-bottom: 10px"> Price: ${o.proPrice * o.quantity}</p>

                    <c:if test="${requestScope.cusOrder.orStatusID == 4}">
                        <form action="Feedback" method="get">
                            <input hidden name="proID" value="${o.proID}">
                            <input hidden name="proName" value="${o.proName}">
                            <input hidden name="proSize" value="${o.sizeID}">
                            <input hidden name="proColor" value="${o.colorID}">
                            <button type="submit" value="Feedback" >Feedback</button>
                        </form> 
                    </c:if>
                    </div>
            </c:forEach>
        </div>
        <div>

            <div style=" width: 55%;margin: 10px auto; display: flex">
                <div style="font-size: medium">
                    <h4 style="">Address</h4>
                    <p>Name: ${sessionScope.account.name}</p>
                    <p>Phone: ${requestScope.address.phone}</p>
                    <p>Address: ${requestScope.address.address}, ${requestScope.address.ward},${requestScope.address.district}, ${requestScope.address.city} </p>

                </div>
            </div>
        </div>


        <jsp:include page="../components/Footer.jsp"></jsp:include>
    </body>
</html>
