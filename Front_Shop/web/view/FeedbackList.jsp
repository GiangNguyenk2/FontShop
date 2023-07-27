<%-- 
    Document   : PostManage
    Created on : Jun 6, 2023, 10:38:06 AM
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
        <link rel="stylesheet" href="../stylesheet/feedbackList.css">

        <title>Post Manage</title>
    </head>
    <body>
        <!-- SIDEBAR -->
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="activeFeedback" value="active"/>
             <jsp:param name="hrefFeedback" value="../view/feedback"/>
             <jsp:param name="hrefMarketing" value="../view/marketingDashboard?table=product"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link">Categories</a>

                <input type="checkbox" id="switch-mode" hidden>


            </nav>
            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>

                <div class="head-title">
                    <div class="left">
                        <h1>Feedback List</h1>
                    </div>
                </div>





                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Recent feedback</h3>
                            <form class="form" action="../view/searchFeedback" method="post">
                                <button>
                                    <svg width="17" height="16" fill="none" xmlns="http://www.w3.org/2000/svg" role="img" aria-labelledby="search">
                                    <path d="M7.667 12.667A5.333 5.333 0 107.667 2a5.333 5.333 0 000 10.667zM14.334 14l-2.9-2.9" stroke="currentColor" stroke-width="1.333" stroke-linecap="round" stroke-linejoin="round"></path>
                                    </svg>
                                </button>
                                <input class="input" placeholder="Type your text" required="" type="text" name="txt">
                                <button class="reset" type="reset">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"></path>
                                    </svg>
                                </button>
                            </form>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table  style="width: 100%;">
                            <thead>
                                <tr>
                                    <th  style="width: 15%;">Name</th>
                                    <th style="width: 20%;">Gmail</th>
                                    <th style="width: 20%;">Product Name</th>
                                    <th style="width: 30%;">Feedback</th>
                                    <th style="width: 15%; padding-left: 60px">RateStar</th>




                                </tr>
                            </thead>
                            <c:forEach items="${listF}" var="f">
                                <tr>
                                    <td style="margin-top: 30px">${f.name}</td>
                                    <td>${f.gmail}</td>
                                    <td><a href="../view/feedbackDetail?pName=${f.proName}">${f.proName}</a></td>
                                <td>${f.feedback}</td>
                                <td>
                                    <c:if test="${f.rateStar == 1}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label></div>
                                        </c:if>
                                        <c:if test="${f.rateStar == 2}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;"for="star2" title="text"></label></div>
                                        </c:if>

                                    <c:if test="${f.rateStar == 3}">
                                        <div class="rating" style="width: 150px">
                                            <input type="radio" id="star1" name="rate" value="1">
                                            <label style="color: orange;"for="star1" title="text"></label>
                                            <input type="radio" id="star2" name="rate" value="2">
                                            <label style="color: orange;"for="star2" title="text"></label>
                                            <input  type="radio" id="star3" name="rate" value="3">
                                            <label style="color: orange;"for="star3" title="text"></label></div>
                                        </c:if>
                                        <c:if test="${f.rateStar == 4}">
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
                                        <c:if test="${f.rateStar == 5}">
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
                            </c:forEach>
                        </table>
                    </div>


            </main>
            <div class="pagination" style="margin-right: 200px; float: right;">

                <c:forEach begin="1" end="${endPage}" var="e">
                    <a class="" href="../view/feedback?index=${e}">${e}</a> 
                </c:forEach>
            </div>

            <!-- MAIN -->
        </section>

        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>




</html>