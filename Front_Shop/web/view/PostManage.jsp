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
        <link rel="stylesheet" href="../stylesheet/PostManage.css">

        <title>Post Manage</title>
    </head>
    <body>
        <!-- SIDEBAR -->
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="active2" value="active"/>
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
                        <h1>Post Manage</h1>
                    </div>
                </div>

                <ul class="box-info">
                    <li>

                        <a href="../view/AddBlog.jsp" style="font-size: 30px ; color: black;">Add New Blog</a>


                    </li>

                </ul>


                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Recent Post</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table  style="width: 100%;">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Gmail</th>
                                    <th>Toppic</th>
                                    <th>Image</th>
                                    <th>Date</th>

                                    <th>Delete</th>
                                    <th>Update</th>

                                </tr>
                            </thead>
                            <c:forEach items="${listP}" var="p" varStatus="index" begin="0"> 
                                <tbody>
                                    <tr>
                                        <td style="width: 40px">${index.index}</td>
                                        <td style="width: 300px"><a href="../view/blogdeatil?ptittle=${p.tittle}">${p.tittle}</a></td>
                                        <td>${p.gmail}</td>
                                        <td>${p.toppic}</td>
                                        <td><img src="../${p.img}" alt="alt"/></td>                                                                
                                        <td>${p.dob}</td>

                                        <td><a href="../view/delete?dtittle=${p.tittle}"><span class="status completed">Delete</span></a></td>
                                        <td><a href="../view/update?ptittle=${p.tittle}"><span class="status completed">Update</span> </a></td>
                                    </tr>

                                </tbody>
                            </c:forEach>
                        </table>
                    </div>


            </main>
            <div class="pagination" style="margin-right: 200px; float: right;  ">
                <c:forEach begin="1" end="${endP}" var="e">
                    <a class="" href="../view/PostManage?index=${e}">${e}</a> 
                </c:forEach>
            </div>
            <!-- MAIN -->
        </section>
        
        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>




</html>