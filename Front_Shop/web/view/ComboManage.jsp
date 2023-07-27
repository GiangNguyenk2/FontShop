<%-- 
    Document   : ComboManage
    Created on : Jun 7, 2023, 6:19:26 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ComboList</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/stylesheet/combolist.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/maketing.css">
        
        <style>
            .pagination a {
                color: black;
                float: left;
                padding: 4px 9px;
                text-decoration: none;
                transition: background-color .3s;
                border-radius: 10px;
            }
            .pagination a.active {
                background-color: black;
                color: white;
                border-radius: 10px;
                font-weight: bold;
            }
            .pagination a:hover:not(.active) {
                background-color: #b0b0b0;
                border-radius: 10px;
                font-weight: bolder;
            }

            .container {
                position: relative;
                --size-button: 30px;
            }

            .input {
                padding-left: var(--size-button);
                height: var(--size-button);
                font-size: 13px;
                border: none;
                color: black;
                outline: none;
                width: var(--size-button);
                transition: all ease 0.3s;
                background-color: #EFEFEF;

                border-radius: 50px;
                cursor: pointer;
            }

            .input:focus,
            .input:not(:invalid) {
                width: 200px;
                cursor: text;

            }

            .input:focus + .icon,
            .input:not(:invalid) + .icon {
                pointer-events: all;
                cursor: pointer;
            }

            .container .icon {
                color: black;
                position: absolute;
                width: var(--size-button);
                height: var(--size-button);
                top: 0;
                left: 0;
                padding: 7px;
                pointer-events: none;
            }

            .container .icon svg {
                width: 100%;
                height: 100%;
            }

            .ca a{
                font-size: 13px;
                color: black;
                border-bottom: 2px solid black;
                border-radius:10px;
                padding:0 5px;
                font-weight: 600;
                margin: 0 5px
            }
            .caName:hover{
                font-weight: 600;
                font-size:large;
            }

            .popup-overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;

                display: none;
                justify-content: center;
                align-items: center;

            }

            .popup-content {
                background-color: #FFF;
                padding: 20px;
                max-width: 400px;
                border-radius: 5px;
                border: 2px dotted black;
            }

            .close-button {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <script>
                    function submitForm() {
                        // Xử lý logic của việc submit form ở đây
                        // Ví dụ: Gửi dữ liệu form đến server bằng Ajax hoặc refresh trang
                        document.forms[0].submit(); // Submit form
                    }
                </script>
        <!-- SIDEBAR -->    
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="active3" value="active"/>
        </jsp:include>
        <!-- SIDEBAR -->

        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <form action="../view/comboManage" method="get" onsubmit="event.preventDefault(); submitForm();" style="display: ">
                        <div class="container">
                            <input placeholder="Type to search..."  class="input" name="txt" type="text" value="${requestScope.txt}" >
                            <div class="icon">
                                <svg viewBox="0 0 512 512" class="ionicon" xmlns="http://www.w3.org/2000/type="submit"svg">
                                <title>Search</title>
                                <path stroke-width="32" stroke-miterlimit="10" stroke="currentColor" fill="none" d="M221.09 64a157.09 157.09 0 10157.09 157.09A157.1 157.1 0 00221.09 64z"></path>
                                <path d="M338.29 338.29L448 448" stroke-width="32" stroke-miterlimit="10" stroke-linecap="round" stroke="currentColor" fill="none"></path>
                                </svg>
                            </div>
                        </div>
                        <input type="submit" hidden="">
                    </form>
                
            </nav>

            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>
                <form action="" method="">
                    <input type="submit"value="AddCombo">
                </form>
                <c:forEach items="${requestScope.combolist}" var="o" >
                    <div class="row">
                        <div class="ComboName">
                            <h2 style="font-size: 15px">${o.comboName}</h2>
                            <form action="" method="">
                                <input type="submit"value="Update">
                            </form>
                        </div>

                        <div class="combolist">
                            <c:forEach items="${requestScope.combodetail}" var="i">
                                <c:if test="${i.comboID == o.comboID}">
                                    <div class="card" >
                                        <a href="../view/comboDetail?comboID=${o.comboID}&proID=${i.proID}&color=0&size=0"> 
                                            <c:forEach items="${requestScope.listimg}" var="z">
                                                <c:if test="${i.proID == z.proID}">
                                                    <img src="../${z.proImg}" alt="John" style="width:30%">
                                                </c:if>
                                            </c:forEach>
                                            <p style="font-size: 15px" class="title">${i.proName}</p>
                                            <p style="font-size: 15px" class="price-N">${i.proPrice} VND</p>
                                        </a>    
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>       
                    </div>
                </c:forEach>
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
