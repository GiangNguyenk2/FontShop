<%-- 
    Document   : Feedback
    Created on : Jun 10, 2023, 5:19:50 PM
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

        <link href="../stylesheet/feedback.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <style>
            .colorful-form {
                margin-top: 40px;
                max-width: fit-content;
                margin: 40px auto;
                padding: 20px;
                background-color: #f5f5f5;
                border-radius: 10px;
            }

            .form-group {

                margin-bottom: 20px;
            }

            .form-label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
                color: #333;
            }

            .form-input {
                width: 400px;
                padding: 10px;
                border: none;
                background-color: #fff;
                color: #333;
                border-radius: 5px;
            }

            textarea.form-input {
                height: 100px;
            }

            .form-button {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #ff6f69;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .form-button:hover {
                background-color: #ff5f59;
            }
        </style>
        <!-- MDB -->
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

        <form class="colorful-form" action="Feedback" method="post">
            <div class="rating">
                <input value="5" name="star-radio" id="star-1" type="radio">
                <label for="star-1">
                    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12,17.27L18.18,21L16.54,13.97L22,9.24L14.81,8.62L12,2L9.19,8.62L2,9.24L7.45,13.97L5.82,21L12,17.27Z" pathLength="360"></path></svg>
                </label>
                <input value="4" name="star-radio" id="star-2" type="radio">
                <label for="star-2">
                    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12,17.27L18.18,21L16.54,13.97L22,9.24L14.81,8.62L12,2L9.19,8.62L2,9.24L7.45,13.97L5.82,21L12,17.27Z" pathLength="360"></path></svg>
                </label>
                <input value="3" name="star-radio" id="star-3" type="radio">
                <label for="star-3">
                    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12,17.27L18.18,21L16.54,13.97L22,9.24L14.81,8.62L12,2L9.19,8.62L2,9.24L7.45,13.97L5.82,21L12,17.27Z" pathLength="360"></path></svg>
                </label>
                <input value="2" name="star-radio" id="star-4" type="radio">
                <label for="star-4">
                    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12,17.27L18.18,21L16.54,13.97L22,9.24L14.81,8.62L12,2L9.19,8.62L2,9.24L7.45,13.97L5.82,21L12,17.27Z" pathLength="360"></path></svg>
                </label>
                <input value="1" name="star-radio" id="star-5" type="radio">
                <label for="star-5">
                    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12,17.27L18.18,21L16.54,13.97L22,9.24L14.81,8.62L12,2L9.19,8.62L2,9.24L7.45,13.97L5.82,21L12,17.27Z" pathLength="360"></path></svg>
                </label>
            </div>
            <input name="proID" value="${requestScope.proID}" hidden>
            <input readonly style="width:100%; border: none;background-color: #f5f5f5; margin:10px 0" name="info" value="${requestScope.proID} - ${requestScope.proName} - <c:forEach items="${requestScope.list_Size}" var="e"><c:if test="${e.sizeID== requestScope.proSize}" >${e.sizeName} - </c:if></c:forEach><c:forEach items="${requestScope.list_Color}" var="f"><c:if test="${f.proColorID==requestScope.proColor}">${f.proColorName}:</c:if></c:forEach>">

                    <div class="form-group">
                        <label class="form-label" for="message">Message:</label>

                        <textarea required="" placeholder="Enter your message" class="form-input" name="message" id="message" onkeyup="filterFeedback(this)"></textarea>
                    </div>
                    <button class="form-button" type="submit">Submit</button>
        </form>

        <jsp:include page="../components/Footer.jsp"></jsp:include>

        <script>
            function filterFeedback(textarea) {
                var regex = /\b(fuck|shit|ass|bitch|cunt|dick|pussy|cock|bastard|damn|hell|đéo)\b/gi;
                textarea.value = textarea.value.replace(regex, "");
            }
        </script>
    </body>
</html>
