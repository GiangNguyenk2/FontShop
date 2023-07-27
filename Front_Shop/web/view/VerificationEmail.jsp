<%-- 
    Document   : VerificationEmail
    Created on : May 19, 2023, 8:25:47 PM
    Author     : dinhd513
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="../stylesheet/login.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    </head>
    <body>
        <h2 style="font-size: 55px; font-family: 'Lobster', cursive;">Front</h2>
        <div class="container">
            <form action="../view/acctive" method="post">
                <div class="row">
                    <h2 style="text-align:center">Verification Email </h2>
                    <div class="col">
                        
                        <p>${mess}</p>

                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Code"/>
                            <jsp:param name="field" value="verifyCode"/>
                        </jsp:include>
                        
                        <input type="submit" value="Send">
                    </div>  

                </div>
            </form>
        </div>

        <div class="bottom-container">
            
        </div>
    </body>
</html>
