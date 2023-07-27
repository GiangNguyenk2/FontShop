<%-- 
    Document   : Combo
    Created on : May 20, 2023, 5:32:43 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ComboList</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/stylesheet/combolist.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../components/Menu.jsp"></jsp:include>

        <c:forEach items="${requestScope.combolist}" var="o" >
            <div class="row">
                <div class="ComboName">
                    <h2 style="">${o.comboName}</h2>
                </div>


                <div class="combolist">
                    <c:forEach items="${requestScope.combodetail}" var="i">
                        <c:if test="${i.comboID == o.comboID}">

                            <div class="card" >
                                <c:forEach items="${requestScope.list_stock}" var="m">
                                    <c:if test="${i.proID==m.proID}">
                                <a href="../view/comboDetail?comboID=${o.comboID}&proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0"> 
                                    <c:forEach items="${requestScope.listimg}" var="z">

                                        <c:if test="${i.proID == z.proID}">
                                            <img src="../${z.proImg}" alt="John" style="width:100%">
                                        </c:if>

                                    </c:forEach>


                                    <p class="title">${i.proName}</p>
                                    <p class="price-N">${i.proPrice} VND</p>
                                </a> 
                                </c:if>
                                </c:forEach>
                            </div>
                        </c:if>


                    </c:forEach>

                </div>       
            </div>
        </c:forEach>

        <jsp:include page="../components/Footer.jsp"></jsp:include>
    </body>
</html>
