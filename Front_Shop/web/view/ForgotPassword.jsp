<%-- 
    Document   : FotgotPassword
    Created on : May 20, 2023, 10:56:31 AM
    Author     : dinhd513
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>

        <link rel="stylesheet" href="../stylesheet/login.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">
        <style>
            .container2{
                display: none;
            }
            .containerPass{
                display: none;
            }
        </style>
    </head>
    <body>
                <a href="../view/Home" style="color: black; text-decoration: none">
            <h2 style="font-size: 55px; font-family: 'MuseoModerno', cursive;">Front:</h2>
        </a>
        <div class="container" style="display: ${requestScope.inputGmail}">
            <form action="../view/forgotPassword" method="post">
                <div class="row">
                    <h2 style="text-align:center">Enter your Gmail</h2>
                    <div class="col">

                        <p>${mess}</p>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Gmail"/>
                            <jsp:param name="field" value="gmailToForgot"/>
                        </jsp:include>
                        <input type="submit" value="Get Verification Code">
                    </div>  

                </div>
            </form>
        </div>

        <div class="container2" style="display: ${requestScope.inputCode}">
            <form action="../view/verifyCode" method="post">
                <div class="row">
                    <h2 style="text-align:center">Enter your code</h2>
                    <div class="col">

                        <p>${mess}</p>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Code"/>
                            <jsp:param name="field" value="codeToVerifyGmail"/>
                        </jsp:include>
                        <input type="submit" value="Check">
                    </div>  

                </div>
            </form>
        </div>  

        <div class="containerPass" style="display: ${requestScope.inputNewPassword}">
            <form action="../view/updatePassword" method="post">
                <div class="row">
                    <h2 style="text-align:center">Enter your new Password</h2>
                    <div class="col">

                        <p>${mess}</p>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="New Password"/>
                            <jsp:param name="field" value="newPassword"/>
                        </jsp:include>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="Re-enter Password"/>
                            <jsp:param name="field" value="reNewPassword"/>
                        </jsp:include>
                        <input type="submit" value="Done">
                    </div>  

                </div>
            </form>


        </div>          

        <div class="bottom-container">
            <div class="row">
                <div class="col">
                    <a href="../view/Login.jsp" style="color:rgb(0, 0, 0); padding: 0;" class="btn">Go back Login page</a>
                </div>
            </div>
        </div>
    </body>
</html>
