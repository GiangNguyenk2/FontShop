<%-- 
    Document   : AddUser
    Created on : Jun 21, 2023, 9:15:10 AM
    Author     : admin
--%>

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
        <title>AddUser</title>
        <style type="text/css">
            .button {
                background-color: white; /* Green */
                border: 1px solid black;
                color: black;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 13px;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <!-- SIDEBAR -->    
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="activeUser" value="active"/>
            <jsp:param name="hrefShopInfo" value="../view/ShopInfomation"/>
             <jsp:param name="hrefAdmin" value="../view/AdminDashboard?table=product"/>
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
                <h1 style="text-align: center">
                    Add New Staff
                </h1>
                <div style="width: 90%; margin: auto">
                    <form action="AddUser" method="post" style="justify-content: center; margin: auto;text-align: center;padding-top: 80px">
                    <p>${mess}</p>
                    <style>
                        .input{
                            --c-text: rgb(50, 50, 80);
                            --c-bg: rgb(252, 252, 252);
                            --c-outline: rgb(55, 45 , 190);
                            padding: 0.5em 0.75em;
                            border-radius: 0.2em;
                            border: 1px solid var(--c-border, currentColor);
                            color: var(--c-text);
                            font-size: 1rem;
                            letter-spacing: 0.1ch;
                            width: 60%;
                            margin: 10px;
                        }
                        

                        .input:invalid {
                            --c-border: rgb(230, 85, 60);
                            --c-text: rgb(230, 85, 60);
                            --c-outline: rgb(230, 85, 60);
                        }

                        .input:is(:disabled, :read-only) {
                            --c-border: rgb(150, 150, 150);
                            --c-text: rgb(170, 170, 170);
                        }

                        

                    </style>
                    Gmail(*):<jsp:include page="../components/input_AddProduct.jsp">
                        <jsp:param name="type" value="text"/>
                        <jsp:param name="placeholder" value=""/>
                        <jsp:param name="field" value="gmail"/>
                    </jsp:include>

                    Name(*):<jsp:include page="../components/input_AddProduct.jsp">
                        <jsp:param name="type" value="text"/>
                        <jsp:param name="placeholder" value=""/>
                        <jsp:param name="field" value="name"/>
                    </jsp:include>

                    <label><input style="margin: 0 10px" type="radio" name="gender" ${gender==1?"checked":""} value="1"> Male</label>
                    <label><input style="margin: 0 10px"  type="radio" name="gender" ${gender==0?"checked":""} value="0"> Female</label>
                    <br><br>
                    <label><input style="margin: 0 10px" type="radio" name="role" ${role==2?"checked":""} value="2"> Maketing</label>
                    <label><input style="margin: 0 10px" type="radio" name="role" ${role==3?"checked":""} value="3"> Sale</label>
                    <br>
                    <input style="margin-top: 30px; padding: 10px 50px; border-radius: 20px" class="button" type="submit" value="Add User">
                </form>
                </div>
                
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
