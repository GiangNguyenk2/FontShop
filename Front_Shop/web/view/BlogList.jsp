<%-- 
    Document   : BlogList
    Created on : May 24, 2023, 4:58:21 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link href="../stylesheet/blog.css" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
    </head>

    <body>
        <jsp:include page="../components/Menu.jsp"/>
        <!-- Load an icon library -->



        <div style=" justify-content: center;">
            <div class="categories" style="width: 250px; justify-content: center;">

                <ul id="myUL">
                    <li><a href="../view/category?Ctoppic=News">News</a></li>
                    <li><a href="../view/category?Ctoppic=Product">Product</a></li>
                    <li><a href="../view/category?Ctoppic=Sale">Sale</a></li>
                </ul>
            </div>
        </div>



        <div class="row">
            <div class="couponlist1" style="display: ${none}">
                <div class="coupon">
                    
                    <a href="../view/blogdeatil?ptittle=${f.tittle}" class="active" style="color: black;"><img src="../${f.img}" alt="Avatar" style="width:100%;"></h2></a>
                    <div class="container" style="background-color:white">
                        <a class="active" style="color: black;" href="../view/blogdeatil?ptittle=${f.tittle}"><h2><b>${f.tittle}</b></h2></a>                      
                    </div>
                    <div class="container">
                        <p>Poster: <span class="promo">${f.gmail}</span></p>
                        <p class="expire">Expires: ${f.dob}</p>
                    </div>
                </div>
            </div>



            <div class="couponlist2">
                <c:forEach  var="b" items="${listP}">

                    <div class="couponlistdetail">
                        <a href="../view/blogdeatil?ptittle=${b.tittle}" class="active" style="color: black;"><img src="../${b.img}"" alt="Avatar" style="width:100%;"></h2></a>
                        <div class="container" style="background-color:white">
                            <a class="active" style="color: black;" href="../view/blogdeatil?ptittle=${b.tittle}"><h2><b>${b.tittle}</b></h2></a>
                            <p>Poster: <span class="promo">${b.gmail}</span></p>
                            <p class="expire">Posting date: ${b.dob}</p>
                        </div>
                    </div>              
                </c:forEach>
            

        </div>




        <div class="pagination" style="margin: auto; justify-content: center; display: ${paging1} ">


            <c:forEach begin="1" end="${endP}" var="e">
                <a class="" href="../view/bloglist?index=${e}">${e}</a> 
            </c:forEach>
                
            


        </div>
                    
                    
                    
        <div class="pagination" style="margin: auto; justify-content: center; display: ${paging2} ">


           
            <c:forEach begin="1" end="${endP}" var="e">
                <a class="" href="../view/category?index=${e}&Ctoppic=${requestScope.toppic}">${e}</a> 
            </c:forEach>    


        </div>
</div>

        <jsp:include page="../components/Footer.jsp"/>



    </body>

</html>
