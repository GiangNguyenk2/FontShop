<%-- 
    Document   : shopAll
    Created on : May 20, 2023, 3:51:26 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop All</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../stylesheet/shopAll.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <link rel=”stylesheet” href=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css”> <script
        src=”https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js”></script> <script
        src=”https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js”></script> <script
        src=”https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js”></script> 

    </head>

    <body>
        <jsp:include page="../components/Menu.jsp"/>
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <section class="page-section">
            <div class="container">
                <div class="row">
                    <div class="col-3 blog-form">
                        <h2 class="blog-siderbar-title"><b>Categories</b> </h2>
                        <hr />
                        <c:forEach items="${requestScope.list}" var="o">
                            <a style="${o.caID==requestScope.caID?"font-size: 25px;":""}" href="shopAll?caID=${o.caID}&page=1&sort=new"> 
                                <p class="blog-sidebar-list"><b>${o.caName}</b> </p></a> 
                                    </c:forEach>


                        <hr />
                        <!--search -->
                        <h4 class="blog-siderbar-title"><b>Search</b> </h4>
                        <div>
                            <div class="input-group mb-3">
                                <form action="search" method="get" class="d-block">
                                    <div class="row d-flex">
                                        <input type="text" class="col-10" name="search" placeholder="Search">
                                        <button class="col-2 " type="submit"><i class="fa fa-search"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--tim theo gia-->
                        <hr />
                        <h4 class="blog-siderbar-title"><b>Price</b> </h4>
                        <ul style="padding: 0;" class="dropdown">
                            <li> <a style="${requestScope.sort_list=="new"?"font-size: 20px;":""}" class="dropdown-item mx-1" href="search?search=${requestScope.key}&page=${requestScope.page}&sort=new"> <b>NEW</b></a> </li>
                            <li>  <a style="${requestScope.sort_list=="low"?"font-size: 20px;":""}" class="dropdown-item mx-1"  href="search?search=${requestScope.key}&page=${requestScope.page}&sort=low"><b> Low to High</b></a></li>
                            <li> <a  style="${requestScope.sort_list=="high"?"font-size: 20px;":""}" class="dropdown-item mx-1" href="search?search=${requestScope.key}&page=${requestScope.page}&sort=high"><b>High to Low</b></a></li>
                        </ul>
                    </div>
                    <!--Ket thuc blog form-->

                    <div class="col-9">
                        <div class="row">
                            <div class="col-9">
                                Showing all ${requestScope.size} result
                            </div>
                            <div class="col-3 ">
                                <!--       <form id="myForm" action="../view/shopAll" method="get">
                                          <select class="form-select" name="sort" onchange="submitForm()">
                                              <a > <option value="new">NEW</option></a></a> 
                                              <option value="low">Low to High</option></a>
                                              <option value="high">High to Low</option>
                                          </select>
      
                                      </form
                                >-->


                            </div>

                        </div>
                        <!--Sorting-->

                        <div class="row d-flex justify-content-center">


                            <c:forEach items="${requestScope.listpage}" var="i">
                                <div class="col-4 product-field">
                                    <ul class="items">
                                        <li data-category data-price="${i.proPrice}">
                                            <c:forEach items="${requestScope.list_stock}" var="m">
                                                <c:if test="${i.proID==m.proID}">
                                                    <a href="productDetail?proID=${i.proID}&colorID=${m.proColorID}&sizeID=${m.proSizeID}&quantity=0">
                                                    </c:if>
                                                </c:forEach>  
                                                <div class="card border border-0">
                                                    <div class="card-body text-center">
                                                        <c:forEach items="${requestScope.list_img}" var="o">
                                                            <c:if test="${i.proID==o.proID}">  
                                                                <img src="../${o.proImg}" class="product-image img-fluid" alt="">
                                                            </c:if>  
                                                        </c:forEach> 
                                                        <h5 class="card-title"><b>${i.proName}</b></h5>

                                                        <c:set var="price" value="${i.proPrice}" />
                                                        <p class="text-center" style="color: red;font-size: 16px"><b>
                                                                <%-- Định dạng số tiền theo VND với dấu phẩy --%>
                                                                <fmt:formatNumber type="number" pattern="###,###₫" value="${price}" />
                                                            </b></p>

                                                    </div>
                                                </div>
                                            </a>

                                        </li>
                                    </ul>
                                </div>
                            </c:forEach>

                        </div>
                        <c:set var="page" value="${requestScope.page}"/>
                        <c:set var="caID" value="${requestScope.caID}"/>
                        <c:set var="num" value="${requestScope.num}"/>
                        <div class="pagination" style="margin: auto; justify-content: center; ">



                            <c:if test="${page-1>1}">
                                <li ><a href="search?search=${requestScope.key}&page=${requestScope.page-2}&sort=${requestScope.sort_list}">&laquo;</a></li>
                                </c:if>

                                <c:forEach begin="${page<2?1:(page-1)}" end="${page>(num-1)?num:(page+1)}" var="i">
                                <li class="${(i==page)?"active":""}"> <a href= "search?search=${requestScope.key}&page=${i}&sort=${requestScope.sort_list}">${i}</a> </li>
                                </c:forEach>
                                <c:if test="${(requestScope.page+2)<=requestScope.num}">
                                <li><a href="search?search=${requestScope.key}&page=${requestScope.page+2}&sort=${requestScope.sort_list}">&raquo;</a></li>
                                </c:if>




                        </div>

                    </div>
                </div>
            </div>

        </section>






        <!--Footer-->
        <jsp:include page="../components/Footer.jsp"/>
    </body>
    <script>
        function submitForm() {
            document.getElementById("myForm").submit();
        }
    </script>
</html>
