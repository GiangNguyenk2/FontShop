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
        <title>Customer Order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="../stylesheet/customerOrder.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
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

        <div>
            <h2 style="text-align: center; margin-top: 20px">Customer Order</h2>

            <div class="table_section" style="width: 90%; margin: auto">
                <table>

                    <thead>
                        <tr>
                            <th>orID</th>
                            <th>Date</th>
                            <th style="width:500px">Gmail</th>
                            <th>Total_Money</th>
                            <th>Status</th> 
                            <th>Action</th>
                        </tr>
                    </thead>   
`

                    <tbody>
                        <c:forEach items="${requestScope.listOrder}" var="o">
                            <tr>
                                <td>${o.orID}</td>
                                <td>${o.dob}</td>

                                <td  style="width:500px">${sessionScope.account.gmail}</td>
                                <td>${o.totalMoney}</td>
                                <td>
                                    <c:if test="${o.orStatusID == 1}">
                                        Pending
                                    </c:if>
                                    <c:if test="${o.orStatusID == 2}">
                                        Confirmed
                                    </c:if>
                                    <c:if test="${o.orStatusID == 3}">
                                        Shipping
                                    </c:if>
                                    <c:if test="${o.orStatusID == 4}">
                                        Complete
                                    </c:if>
                                    <c:if test="${o.orStatusID == 5}">
                                        Canceled
                                    </c:if>
                                </td>
                                <td>
                                    <form action="orderInformation" method="get">
                                        <input value="${o.orID}" name="orID" hidden > 
                                        <input type="submit" value="Detail">
                                    </form>
                                        <c:if test="${o.orStatusID == 1}">
                                            <form action="customerOrder" method="post">
                                        <input value="${o.orID}" name="orID" hidden > 
                                        <input type="submit" value="Cancel">
                                    </form>
                                        </c:if>
                                              
                                    
                                </td>

                            </tr> 
                        </c:forEach>
                    </tbody>

                </table>           
            </div>
        </div>
        <jsp:include page="../components/Footer.jsp"></jsp:include>
    </body>
</html>
