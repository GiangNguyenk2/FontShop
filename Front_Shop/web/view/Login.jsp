<%-- 
    Document   : Login
    Created on : May 18, 2023, 3:43:03 PM
    Author     : dinhd513
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/login.css" type="text/css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">
    </head>


    <body>
        <a href="../view/Home" style="color: black; text-decoration: none">
            <h2 style="font-size: 55px; font-family: 'MuseoModerno', cursive;">Front:</h2>
        </a>
        
        <div class="container">
            <form action="login" method="post">
                <div class="row">
                    <h2 style="text-align:center" >Login</h2>
                    <div class="col">

                        <p>${mess}</p>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Gmail"/>
                            <jsp:param name="field" value="gmail"/>
                        </jsp:include>



                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="Password"/>
                            <jsp:param name="field" value="password"/>
                        </jsp:include>
                        <div class="group" style="margin: auto">
                            <input style="" class="submit" type="submit" value="Login">
                        </div>

                    </div>  

                </div>
            </form>
        </div>

        <div class="bottom-container">
            <div class="row">
                <div class="col">
                    <a href="../view/Signup.jsp" style="color:rgb(0, 0, 0)" class="btn">Sign up</a>
                </div>
                <div class="col">
                    <a href="../view/ForgotPassword.jsp" style="color:rgb(0, 0, 0)" class="btn">Forgot password?</a>
                </div>
            </div>
        </div>

    </body>
</html>
