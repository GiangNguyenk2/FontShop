<%-- 
    Document   : FeedbackDetail
    Created on : Jun 22, 2023, 11:26:09 AM
    Author     : DELL
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
        <link rel="stylesheet" href="../stylesheet/feedbackdetail.css">

        <title>Feedback Detail</title>
    </head>
    <body>
        <!-- SIDEBAR -->
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="activeFeedback" value="active"/>
             <jsp:param name="hrefMarketing" value="../view/marketingDashboard?table=product"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link">Feedback Detail</a>

                <input type="checkbox" id="switch-mode" hidden>


            </nav>
            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>

                <div class="head-title">
                    <div class="left">

                    </div>
                </div>

                <h1 style="text-align: center; margin: 20px;">About</h1>

                <div class="profile" style="margin-bottom: 200px">


                    <div class="boxleft" style="height: 400px ; ">
                        <h3 style="margin-bottom: 20px; text-align: center">User</h3>
                        <div class="fb" style="text-align: left; font-size: 18px">

                            <p>Name     <span>:&emsp;${detail.name}</span></p>
                            <p>Gmail    <span>:&emsp;${detail.gmail}</span></p>
                            <p>Phone    <span>:&emsp;${detail.phone}</span></p>
                            <p>Address  <span style="padding-left: 15px">:&emsp;${detail.adderss}</span></p>
                            <p>City  &emsp;  <span>:&emsp;${detail.city}</span></p>
                            <p>District <span style="padding-left: 25px">:&emsp;${detail.district}</span></p>
                            <p>Ward     <span style="padding-left: 37px">:&emsp;${detail.ward}</span></p>
                        </div>


                    </div>

                    <div class="boxright">
                        <h3 style="margin-bottom: 20px; text-align: center">Product Order</h3>
                        <table>
                            <tr style="padding: 0" >
                                <th style="margin-bottom: 5px">Product Name</th>
                                <th style="margin-bottom: 5px">Feedback</th>
                                <th style="margin-bottom: 5px; padding-right: 50px">Rate Star</th>

                            </tr>

                            <tr >
                                <td style="margin-bottom: 5px; width: 30%;"><img style="width: 80%" src="../${detail.proImg}" alt="alt"/><br>${detail.proName}</td>

                                <td style="margin-bottom: 5px;width: 30%">${detail.feedback}</td>
                                <td style="width: 10%">
                                    <c:if test="${detail.rateStar == 1}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label></div>
                                        </c:if>
                                        <c:if test="${detail.rateStar == 2}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;"for="star2" title="text"></label></div>
                                        </c:if>

                                    <c:if test="${detail.rateStar == 3}">
                                        <div class="rating" style="width: 150px;">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;"for="star2" title="text"></label>
                                            <input  type="radio" id="star3" name="rate" value="3">
                                            <label style="color: orange;"for="star3" title="text"></label></div>
                                        </c:if>
                                        <c:if test="${detail.rateStar == 4}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;"for="star2" title="text"></label>
                                            <input  type="radio" id="star3" name="rate" value="3">
                                            <label style="color: orange;"for="star3" title="text"></label>
                                            <input type="radio" id="star4" name="rate" value="4">
                                            <label style="color: orange;"for="star4" title="text"></label></div>
                                        </c:if>
                                        <c:if test="${detail.rateStar == 5}">
                                        <div class="rating" style="width: 150px">
                                            <input  type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;" for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;" for="star2" title="text"></label>
                                            <input  type="radio" id="star3" name="rate" value="3">
                                            <label style="color: orange;" for="star3" title="text"></label>
                                            <input type="radio" id="star4" name="rate" value="4">
                                            <label  style="color: orange;"for="star4" title="text"></label>
                                            <input type="radio" id="star5" name="rate" value="5">
                                            <label style="color: orange;"for="star5" title="text"></label></div>
                                        </c:if>
                                </td>
                            </tr>

                        </table>



                    </div>
                </div>





            </main
            <!-- MAIN -->
        </section>

        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>




</html>