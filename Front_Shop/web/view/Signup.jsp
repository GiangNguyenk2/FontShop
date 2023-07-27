<%-- 
    Document   : signUp
    Created on : May 19, 2023, 2:09:07 PM
    Author     : dinhd513
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>

        <link rel="stylesheet" href="../stylesheet/login.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&family=Oxygen:wght@300;400;700&display=swap" rel="stylesheet">
    </head>
    <style>
        .wrapper {
            --font-color-dark: #323232;
            --font-color-light: #FFF;
            --bg-color: #fff;
            --main-color: #323232;
            position: relative;
            width: 170px;
            height: 34px;
            background-color: var(--bg-color);
            border: 2px solid var(--main-color);
            border-radius: 34px;
            display: flex;
            flex-direction: row;
            box-shadow: 2px 2px var(--main-color);
            
        }

        .option {
            width: 80.5px;
            height: 28px;
            position: relative;
            top: 2px;
            left: 2px;
        }

        .check {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            appearance: none;
            cursor: pointer;
        }

        .ok {
            width: 100%;
            height: 100%;
            background-color: var(--bg-color);
            border-radius: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .span {
            color: var(--font-color-dark);
        }

        .check:checked + .ok {
            background-color: var(--main-color);
        }

        .check:checked + .ok .span {
            color: var(--font-color-light);
        }
    </style>
    <body>

                <a href="../view/Home" style="color: black; text-decoration: none">
            <h2 style="font-size: 55px; font-family: 'MuseoModerno', cursive;">Front:</h2>
        </a>
        <div class="container" style=" margin: auto ; justify-content: center" >
            <form action="../view/signup" method="post" style="width: 100%">
                <div class="row">
                    <h2 style="text-align:center">Sign Up</h2>
                    <div class="col">

                        <p>${mess}</p>

                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Full Name"/>
                            <jsp:param name="field" value="name"/>
                        </jsp:include>
                       

                        

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
                        
                        <div class="wrapper" style="margin: auto; margin-top: -10px; margin-bottom:  10px">
                            <div class="option">
                                <input class="check" type="radio" id="nam" name="gender" value="1"  required>
                                <div class="ok">
                                    <span class="span">Male</span>
                                </div>
                            </div>
                            <div class="option">
                                <input class="check" type="radio" id="nu" name="gender" value="0" required>
                                <div class="ok">
                                    <span class="span">Female</span>
                                </div>  </div>
                        </div>
                        <input type="submit" value="Sign Up">
                    </div>  

                </div>
            </form>
        </div>

        <div class="bottom-container">
            <div class="row">
                <div class="col">
                    <a href="../view/Login.jsp" style="color:rgb(0, 0, 0)" class="btn">Go back</a>
                </div>

            </div>
        </div>



    </body>
</html>
