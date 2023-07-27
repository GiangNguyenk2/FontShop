<%-- 
    Document   : ShopInformation
    Created on : Jun 18, 2023, 1:31:44 AM
    Author     : Asus
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/ShopInfor.css">

        <title>Shop Information</title>
    </head>
    <body>
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="activeShopInfo" value="activeShopInfo"/>
            <jsp:param name="hrefShopInfo" value="../view/ShopInfomation"/>
            <jsp:param name="hrefAdmin" value="../view/AdminDashboard?table=product"/>
        </jsp:include>

        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link">Update Shop Information</a>

                <input type="checkbox" id="switch-mode" hidden>


            </nav>
            <!-- NAVBAR -->
            <main>
                <div class="mainTable" style="margin-top: 20px">
                    <div style="width: 90%; margin: auto; margin-top: 50px">
                        <table id="table" border="1">
                            <tr>
                                <th>Name</th>
                                <th>Address</th><!-- comment -->
                                <th>Facebook</th><!-- comment -->
                                <th>Gmail</th><!-- comment -->
                                <th>Phone</th><!-- comment -->                          
                            </tr>

                            <tr>
                                <td>${requestScope.info.name}</td>
                                <td>${requestScope.info.address}</td><!-- comment -->
                                <td>${requestScope.info.facebook}</td>
                                <td>${requestScope.info.gmail}</td><!-- comment -->
                                <td>${requestScope.info.phone}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                            
                <div class="UpdateIn4" style="text-align: center; margin-top: 20px">
                    <p style="color: Red">${requestScope.messFail}</p>
                    <p style="color: green">${requestScope.mess}</p>
                    <button onclick="showForm()">Update Information</button>
                </div><!-- comment -->
                <div style="margin-left: 80px; margin-top: 20px">
                    <form id="form" action="UpdateInfomation" method="post">
                        
                        
                        <input type="text" hidden name="name" value="${requestScope.info.name}" >
                        <jsp:include page="../components/input_UpdateInfo.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Address(*)"/>
                            <jsp:param name="field" value="address"/>
                            <jsp:param name="value" value="${requestScope.info.address}"/>
                        </jsp:include>
                        <jsp:include page="../components/input_UpdateInfo.jsp">
                            <jsp:param name="type" value="url"/>
                            <jsp:param name="placeholder" value="Facebook(*)"/>
                            <jsp:param name="field" value="facebook"/>
                            <jsp:param name="value" value="${requestScope.info.facebook}"/>
                        </jsp:include>
                        <jsp:include page="../components/input_UpdateInfo.jsp">
                            <jsp:param name="type" value="text"/>
                            <jsp:param name="placeholder" value="Gmail(*)"/>
                            <jsp:param name="field" value="gmail"/>
                            <jsp:param name="value" value="${requestScope.info.gmail}"/>
                        </jsp:include>
                        <jsp:include page="../components/input_UpdateInfo.jsp">
                            <jsp:param name="type" value="tel"/>
                            <jsp:param name="placeholder" value="Phone(*)"/>
                            <jsp:param name="field" value="phone"/>
                            <jsp:param name="value" value="${requestScope.info.phone}"/>
                        </jsp:include>
                        <button type="submit">Update</button>
                    </form>
                </div>
            </main>
            <script>
                function showForm() {
                    var form = document.getElementById("form");
                    var tableContainer = document.getElementById("table-container");

                    form.style.display = "block";
                    tableContainer.style.display = "none";
                }
            </script>
        </section>
    </body>
</html>
