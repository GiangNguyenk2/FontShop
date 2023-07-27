<%-- 
    Document   : UserDetail
    Created on : Jun 24, 2023, 7:23:54 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->

        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/maketing.css">


        <!-- Boxicons -->
        <title>UserDetail</title>
        <style type="text/css">

            body {

                margin: 0;

                padding: 0;

                font-family: 'Roboto Condensed', sans-serif;

            }

            /* Overlay Styles */

            .overlay {

                background: rgba(0, 0, 0, 0.8);

                opacity: 0.8;

                filter: alpha(opacity=80);

                position: absolute;

                top: 0px;

                bottom: 0px;

                left: 0px;

                right: 0px;

                z-index: 100;

            }

            /* Popup */

            .popup {

                background: white;

                position: absolute;

                top: 0;

                left: 0;

                bottom: 0;

                right: 0;

                z-index: 101;

                width: 500px;

                /*Change your width here*/

                height: 200px;

                /*Change your height here*/

                margin: auto;

                /* Popup Inner */

            }

            @media (max-width: 768px) {

                .popup {

                    width: 90%;

                    margin: auto 5%;

                }

            }

            .popup .popup-inner {

                position: relative;

                padding: 1em;

            }

            .popup .popup-inner input.s3-btn-close {

                position: absolute;

                top: -0.5em;

                right: -0.5em;

                background: black;

                border: solid 2px white;

                color: white;

                cursor: pointer;

                border-radius: 15px;

                outline: none;

            }

            /*************
                    
            S3 Button
                    
            *************/

            input.s3-btn {

                background: #4E92DF;

                border: none;

                width: 30%;

                height: 50px;

                cursor: pointer;

                position: absolute;

                top: 0;

                color: white;

                right: 0;

                bottom: 0;

                left: 0;

                margin: auto;

                font-size: 18pt;



            }

            .s3-center {

                text-align: center;

            }

            table, td, th {
                border: 1px solid black;
                text-align: center;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }
            td {
                text-align: center;
            }

            .textarea {
                width: 400px;
                height: 120px;
                padding: 12px 20px;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                background-color: #f8f8f8;
                resize: none;
            }
            .button {
                background-color: white; /* Green */
                border: 1px solid black;
                color: black;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 13px;
            }

            .card {
                text-align: center;
                margin: auto;
                --main-color: #000;
                --submain-color: #78858F;
                --bg-color: #fff;
                font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                position: relative;
                width: 50%;
                height: 50%;
                display: flex;
                flex-direction: column;
                align-items: center;
                border-radius: 20px;
                background: var(--bg-color);
            }

            .card__img {
                height: 192px;
                width: 100%;
            }

            .card__img svg {
                height: 100%;
                border-radius: 20px 20px 0 0;
            }


            .card__avatar svg {
                width: 100px;
                height: 100px;
            }

            .card__title {
                margin-top: 60px;
                font-weight: 500;
                font-size: 40px;
                color: var(--main-color);
            }

            .card__subtitle {
                margin-top: 10px;
                font-weight: 400;
                font-size: 30px;
                color: var(--submain-color);
            }

            .card__btn {
                padding: 10px;
                margin-top: 15px;
                width: fit-content;
                margin: 15px;
                height: 31px;
                border: 2px solid var(--main-color);
                border-radius: 4px;
                font-weight: 700;
                font-size: 11px;
                color: var(--main-color);
                background: var(--bg-color);
                text-transform: uppercase;
                transition: all 0.3s;
            }

            .card__btn-solid {
                background: var(--main-color);
                color: var(--bg-color);
            }

            .card__btn:hover {
                background: var(--main-color);
                color: var(--bg-color);
            }

            .card__btn-solid:hover {
                background: var(--bg-color);
                color: var(--main-color);
            }
        </style>

    </head>
    <body>
        <!-- SIDEBAR -->    
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="activeUser" value="active"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
            </nav>



            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>


                <div class="card" >
                    <div class="card__title">Name: ${acc.name} </div>
                    <div class="card__subtitle">Gmail: ${acc.gmail}</div>
                    <div class="card__subtitle">${acc.gender?"Male":"Female"}</div>
                    <c:if test="${acc.roleID ==1}">
                        <div class="card__subtitle">Admin</div>
                    </c:if>
                    <c:if test="${acc.roleID ==2}">
                        <div class="card__subtitle">Marketing</div>

                    </c:if>
                    <c:if test="${acc.roleID ==3}">
                        <div class="card__subtitle">Sale</div>

                    </c:if>
                    <c:if test="${acc.roleID ==4}">
                        <div class="card__subtitle">Customer</div>
                        <div class="card__subtitle">Order done: ${done}</div>
                        <div class="card__subtitle">Order cancel: ${cancel}</div>
                        <div class="card__subtitle">Total Money: ${money}</div>

                    </c:if>

                    <div class="card__wrapper">
                        <c:if test="${sessionScope.account.roleID == 1}">
                            <c:if test="${status ==true}">
                                <input class="card__btn" type="button"  name="Open" onclick="popupOpen();" value="Block User">

                            </c:if>
                            <c:if test="${status ==false}">
                                <input class="card__btn" type="button"  name="Open" onclick="popupOpen();" value="Unblock User">

                            </c:if>  
                        </c:if>
                    </div>
                </div>        


            </main>



            <!-- MAIN -->
        </section>
        <div>
            <!-- Overlay -->

            <div class="overlay" id="overlay" style="display:none;"></div>

            <!-- Popup -->

            <div class="popup" id="popup" style="display:none;height: fit-content">
                <h4 style="padding-top: 10px; padding-left: 10px">Why do you want to block this account?</h4>
                <div class="popup-inner" style="border-radius: 20px">
                    <input style="padding: 10px" type="button" name="Close" class="s3-btn-close" onclick="popupClose();" value="×">
                    <c:if test="${status ==true}">
                        <form action="userDetail" method="post">

                            <textarea class="textarea" type="text" name="reason" value=""></textarea><br>
                            <input style="border: 1px solid black" class="card__btn"  type="submit" name="block" value="Block">
                            <input class="card__btn" hidden="" name="gmail" value="${acc.gmail}">

                        </form>
                    </c:if>

                    <c:if test="${status ==false}">
                        <form action="userDetail" method="post">
                            You want to unblock this user
                            <br>
                            <input style="border: 1px solid black" class="card__btn"  type="submit" name="unblock" value="Unblock">
                            <input class="card__btn" hidden="" name="gmail" value="${acc.gmail}">
                        </form>
                    </c:if>

                </div>
            </div>

            <!-- Popup Button -->

            <!--            <c:if test="${status ==true}">
                            <input type="button" class="s3-btn" name="Open" onclick="popupOpen();" value="Block User">
            </c:if>
            <c:if test="${status ==false}">
                <input type="button" class="s3-btn" name="Open" onclick="popupOpen();" value="Unblock User">
            </c:if>              -->

        </div>
        <!-- CONTENT -->
        <script>
            function submitForm() {
                // Xử lý logic của việc submit form ở đây
                // Ví dụ: Gửi dữ liệu form đến server bằng Ajax hoặc refresh trang
                document.forms[0].submit(); // Submit form
            }
        </script><!-- comment -->

        <script>
            function popupOpen() {
                document.getElementById("popup").style.display = "block";
                document.getElementById("overlay").style.display = "block";
            }
            function popupClose() {
                document.getElementById("popup").style.display = "none";
                document.getElementById("overlay").style.display = "none";
            }

        </script>

        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
