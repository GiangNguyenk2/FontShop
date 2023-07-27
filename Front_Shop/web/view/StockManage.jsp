<%-- 
    Document   : StockManage
    Created on : Jun 2, 2023, 3:29:00 PM
    Author     : dinhd513
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/stockManage.css">

        <title>Stock Manage</title>

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
        <!-- SIDEBAR -->
         <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param value="active" name="active"/> 
            <jsp:param name="hrefOrder" value="../view/managerorder?table=all&filter=new&page=1"/>
        </jsp:include>
        <!-- SIDEBAR -->



        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>


                <c:if test="${requestScope.listP == null}">
                    <form action="../view/mktSearch" method="get" onsubmit="event.preventDefault(); submitForm();" style="display: ">
                        <input hidden value="product" name="list">
                        <input hidden value="" name="caID">
                        <input hidden value="new" name="sort">
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
                </c:if>
                <c:if test="${requestScope.listS == null}">
                    <form action="../view/mktSearch" method="get" onsubmit="event.preventDefault(); submitForm();" style="display: ${requestScope.listS}">
                        <input hidden value="stock" name="list">
                        <input hidden value="" name="sizeID">
                        <input hidden value="new" name="sort">
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
                </c:if>
                <script>
                    function submitForm() {
                        // Xử lý logic của việc submit form ở đây
                        // Ví dụ: Gửi dữ liệu form đến server bằng Ajax hoặc refresh trang
                        document.forms[0].submit(); // Submit form
                    }
                </script>

                <c:if test="${sessionScope.account.roleID == 2}">
                    <div>
                    <form action="../view/addProduct" method="get" style="width: fit-content">
                        <input hidden value="stock" name="list">
                        <button class="btn" style="background-color: #FFF" type="submit"> Add Product
                        </button>
                    </form>
                </div> 
                </c:if>
                

                <div class="list">

                    <ul class="box-Choose" style="display: flex; justify-content: center; float: right">
                        <li style="margin-right: 100px; ba">

                        </li>

                        <li style="margin-right: 30px; ">
                            <form action="../view/productStockManage?list=product&caID=&sort=new" method="get">
                                <input hidden value="product" name="list">
                                <input hidden value="" name="caID">
                                <input hidden value="new" name="sort">
                                <button class="btn" style="border-bottom: 2px solid black;" type="submit"> <h4 style="color:  ${requestScope.list == "product"? "orange;font-weight: 800;" : ""}">Product List</h4>
                                </button>
                            </form>
                        </li>
                        <li style="margin-left: 30px">
                            <form action="../view/productStockManage" method="get">
                                <input hidden value="stock" name="list">
                                <input hidden value="" name="sizeID">
                                <input hidden value="new" name="sort">
                                <button class="btn" type="submit"> <h4 style="color:  ${requestScope.list == "stock"? "orange;font-weight: 800;" : ""}">Stock List</h4>
                                </button>
                            </form>
                        </li>

                    </ul>

                </div>





            </nav>
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main style="padding-top: 10px">
                <c:if test="${requestScope.listP == null}">
                    <div class="table-data" style="display: ${requestScope.listP} ">

                        <div class="order">
                            <div class="head" style="justify-content: space-between">
                                <c:if test="${requestScope.txt==null}">
                                    <div style="justify-content: space-around">
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "new"? "font-weight : 800":""};" href="../view/productStockManage?list=product&caID=&sort=new"> Normal</a>
                                        <a style="margin: 0 5px; color: #202425;${requestScope.sort_list == "low"? "font-weight : 800":""};" href="../view/productStockManage?list=product&caID=${requestScope.caID}&sort=low"> Low</a>
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "high"? "font-weight : 800":""};" href="../view/productStockManage?list=product&caID=${requestScope.caID}&sort=high"> High</a>
                                    </div>
                                </c:if>
                                <c:if test="${requestScope.txt!=null}">
                                    <div style="justify-content: space-around">
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "new"? "font-weight : 800":""};" href="../view/mktSearch?list=product&txt=${requestScope.txt}&sort=new"> Normal</a>
                                        <a style="margin: 0 5px; color: #202425;${requestScope.sort_list == "low"? "font-weight : 800":""};" href="../view/mktSearch?list=product&txt=${requestScope.txt}&sort=low"> Low</a>
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "high"? "font-weight : 800":""};" href="../view/mktSearch?list=product&txt=${requestScope.txt}&sort=high"> High</a>
                                    </div>
                                </c:if>
                                <div class="ca" style="display: ${requestScope.noneCa}">
                                    <c:forEach items="${requestScope.listCa}" var="o">
                                        <a  style=" ${requestScope.caID == o.caID? "color: orange": ""};" class="caName"
                                            href="../view/productStockManage?list=product&caID=${o.caID}&sort=new"  >${o.caName} </a>
                                    </c:forEach>
                                </div>


                            </div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Detail</th>
                                        <th>Category</th>
                                        <th>Price</th>
                                        <th>Status</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.listProduct}" var="o">
                                        <tr>
                                            <td>${o.proID}</td>
                                            <td style="display: flex;">
                                                <c:forEach items="${requestScope.list_img}" var="i">
                                                    <c:if test="${o.proID==i.proID}">  
                                                        <img src="../${i.proImg}">
                                                    </c:if>  
                                                </c:forEach> 

                                                <p>${o.proName}</p>

                                            </td>
                                            <td>
                                                <a href="#" onclick="showPopup()" style="color: black">View Detail</a>
                                             
                                                    


                                                    <div class="popup-overlay" id="popupOverlay_${o.proID}">
                                                        <div class="popup-content">
                                                            <a  style="font-weight: 800; font-size:larger ; cursor: pointer; text-align: center; color: pink" onclick="closePopup()">X</a>
                                                            <div >
                                                                <p>${o.proDetail}</p>    

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <script>
                                                        function showPopup() {
                                                            var popupOverlay = document.getElementById('popupOverlay_${o.proID}');
                                                            popupOverlay.style.display = 'flex';
                                                        }

                                                        function closePopup() {
                                                            var popupOverlay = document.getElementById('popupOverlay_${o.proID}');
                                                            popupOverlay.style.display = 'none';
                                                        }
                                                    </script>
                                                
                                            </td>



                                            <c:forEach items="${requestScope.list_Category}" var="j">
                                                <c:if test="${o.caID==j.caID}">  
                                                    <td>${j.caName}</td>
                                                </c:if>  
                                            </c:forEach> 

                                            <td>${o.proPrice}</td>
                                            <c:if test="${o.proStatus == true}">
                                                <td> <span class="status completed">On sale</span></td>
                                            </c:if>
                                            <c:if test="${o.proStatus != true}">
                                                <td><span class="status pending">not sold</span></td>
                                            </c:if>     
                                            <c:if test="${sessionScope.account.roleID == 2}">
                                                <td>
                                                <form action="../view/updateProduct" method="get">
                                                    <input value="${o.proID}" hidden="" name="proID">
                                                    <button class="button_">Update</button>
                                                </form>
                                            </td>

                                            <td>
                                                <form action="addStock" method="get">
                                                    <input value="${o.proID}" hidden="" name="proID">
                                                    <button class="button_">Add new Stock</button>
                                                </form>
                                            </td>
                                            </c:if>
                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>

                        </div>

                    </div>

                </c:if>
                <c:if test="${requestScope.listS==null}">
                    <div class="table-data stock" style="display: ${requestScope.listS}">
                        <div class="order">
                            <div class="head" style="justify-content: space-between">
                                <c:if test="${txt==null}">
                                    <div style="justify-content: space-around">
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "new"? "font-weight : 800":""};" href="../view/productStockManage?list=stock&sizeID=&sort=new"> Normal</a>
                                        <a style="margin: 0 5px; color: #202425;${requestScope.sort_list == "low"? "font-weight : 800":""};" href="../view/productStockManage?list=stock&sizeID=${requestScope.sizeID}&sort=low"> Low</a>
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "high"? "font-weight : 800":""};" href="../view/productStockManage?list=stock&sizeID=${requestScope.sizeID}&sort=high"> High</a>
                                    </div>

                                    <div>
                                        <c:forEach items="${requestScope.list_Size}" var="s">
                                            <a  style="  font-size: 13px; color: black; ${requestScope.sizeID == s.sizeID? "color: orange": ""}; border-bottom: 2px solid black; border-radius:10px; padding:0 5px; font-weight: 600; margin: 0 5px "
                                                href="../view/productStockManage?list=stock&sizeID=${s.sizeID}&sort=new" >${s.sizeName} </a>
                                        </c:forEach>

                                    </div>

                                </c:if>
                                <c:if test="${txt!=null}">
                                    <div style="justify-content: space-around">
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "new"? "font-weight : 800":""};" href="../view/mktSearch?list=stock&txt=${requestScope.txt}&sizeID=${requestScope.sizeID}&sort=new"> Normal</a>
                                        <a style="margin: 0 5px; color: #202425;${requestScope.sort_list == "low"? "font-weight : 800":""};" href="../view/mktSearch?list=stock&txt=${requestScope.txt}&sizeID=${requestScope.sizeID}&sort=low"> Low</a>
                                        <a style="margin: 0 5px; color: #202425; ${requestScope.sort_list == "high"? "font-weight : 800":""};" href="../view/mktSearch?list=stock&txt=${requestScope.txt}&sizeID=${requestScope.sizeID}&sort=high"> High</a>
                                    </div>
                                    <div>
                                        <c:forEach items="${requestScope.list_Size}" var="s">
                                            <a  style="  font-size: 13px; color: black; ${requestScope.sizeID == s.sizeID? "color: orange": ""}; border-bottom: 2px solid black; border-radius:10px; padding:0 5px; font-weight: 600; margin: 0 5px "
                                                href="../view/mktSearch?list=stock&sizeID=${s.sizeID}&sort=new&txt=${requestScope.txt}" >${s.sizeName} </a>
                                        </c:forEach>

                                    </div>

                                </c:if>

                            </div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Color</th>
                                        <th>Size</th>
                                        <th>Quantity</th>
                                        <th>Status</th>
                                        <th>Update</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.listStock}" var="o">
                                        <tr>
                                            <td>${o.stockID}</td>
                                            <td style="display: flex;">
                                                <c:forEach items="${requestScope.list_img}" var="i">
                                                    <c:if test="${o.proID==i.proID}">  
                                                        <img src="../${i.proImg}">

                                                    </c:if>  
                                                </c:forEach> 

                                                <c:forEach items="${requestScope.list_Pro}" var="e">
                                                    <c:if test="${o.proID==e.proID}">  
                                                        <p>${e.proName}</p>

                                                    </c:if>  
                                                </c:forEach> 


                                            </td>
                                            <td>
                                                <c:forEach items="${requestScope.list_Color}" var="j">
                                                    <c:if test="${o.proColorID == j.proColorID}">  
                                                        ${j.proColorName}
                                                    </c:if>  
                                                </c:forEach> 
                                            </td>
                                            <td>
                                                <c:forEach items="${requestScope.list_Size}" var="k">
                                                    <c:if test="${o.proSizeID == k.sizeID}">  
                                                        ${k.sizeName}
                                                    </c:if>  
                                                </c:forEach>        
                                            </td>
                                            <td>${o.quantity}</td>
                                            <c:if test="${o.stockStatus == true}">
                                                <td><span class="status completed">In stock</span></td>
                                            </c:if>
                                            <c:if test="${o.stockStatus != true}">
                                                <td><span class="status pending">Out of stock</span></td>
                                            </c:if>     
                                            <td>
                                                <form action="updateStock" method="get">
                                                    <input name="stockID" value="${o.stockID}" hidden>
                                                    <input name="proID" value="${o.proID}" hidden>
                                                    <input name="sizeID" value="${o.proSizeID}" hidden>
                                                    <input name="colorID" value="${o.proColorID}" hidden>
                                                    
                                                    <button class="button_">Update</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div> 

                </c:if>
                <div class="check" style="display: ${requestScope.none1} ;float:  right; text-align: center">
                    <div class="pagination" style="margin: auto">
                        <a href="../view/productStockManage?index=${indexNow - 1}&list=product&caID=${requestScope.caID}&sort=${requestScope.sort_list}">&laquo;</a>
                        <c:forEach begin="1" end="${endPage}" var="o">
                            <a class="${indexNow == o? "active" : ""}" href="../view/productStockManage?index=${o}&list=product&caID=${requestScope.caID}&sort=${requestScope.sort_list}">${o}</a>
                        </c:forEach>
                        <a href="../view/productStockManage?index=${indexNow + 1}&list=product&caID=${requestScope.caID}&sort=${requestScope.sort_list}">&raquo;</a>
                    </div>
                </div> 

                <div class="check" style="display: ${requestScope.paging2} ;float:  right; text-align: center">
                    <div class="pagination" style="margin: auto">
                        <a href="../view/productStockManage?index=${indexNow - 1}&list=stock&sizeID=${requestScope.sizeID}&sort=${requestScope.sort_list}&txt=${requestScope.txt}">&laquo;</a>
                        <c:forEach begin="1" end="${endPage}" var="osize">
                            <a class="${indexNow == osize? "active" : ""}" href="../view/productStockManage?index=${osize}&list=stock&sizeID=${requestScope.sizeID}&sort=${requestScope.sort_list}&txt=${requestScope.txt}">${osize}</a>
                        </c:forEach>
                        <a href="../view/productStockManage?index=${indexNow + 1}&list=stock&sizeID=${requestScope.sizeID}&sort=${requestScope.sort_list}&txt=${requestScope.txt}">&raquo;</a>
                    </div>
                </div>      

                <div class="check" style="display: ${requestScope.none3} ;float:  right; text-align: center">
                    <div class="pagination" style="margin: auto">
                        <a href="../view/mktSearch?index=${indexNow - 1}&list=product&txt=${requestScope.txt}&sort=${requestScope.sort_list}">&laquo;</a>
                        <c:forEach begin="1" end="${endPageTxt}" var="o">
                            <a class="${indexNow == o? "active" : ""}" href="../view/mktSearch?index=${o}&list=product&txt=${requestScope.txt}&sort=${requestScope.sort_list}">${o}</a>
                        </c:forEach>
                        <a href="../view/mktSearch?index=${indexNow + 1}&list=product&txt=${requestScope.txt}&sort=${requestScope.sort_list}">&raquo;</a>
                    </div>
                </div> 

                <div class="check" style="display: ${requestScope.none4} ;float:  right; text-align: center">
                    <div class="pagination" style="margin: auto">
                        <a href="../view/mktSearch?index=${indexNow - 1}&list=stock&txt=${requestScope.txt}&sort=${requestScope.sort_list}&txt=${requestScope.txt}&sizeID=${requestScope.sizeID}">&laquo;</a>
                        <c:forEach begin="1" end="${endPageTxt}" var="o">
                            <a class="${indexNow == o? "active" : ""}" href="../view/mktSearch?index=${o}&list=stock&txt=${requestScope.txt}&sort=${requestScope.sort_list}&sizeID=${requestScope.sizeID}">${o}</a>
                        </c:forEach>
                        <a href="../view/mktSearch?index=${indexNow + 1}&list=stock&txt=${requestScope.txt}&sort=${requestScope.sort_list}&txt=${requestScope.txt}&sizeID=${requestScope.sizeID}">&raquo;</a>
                    </div>
                </div> 

                <h4 style="text-align: center; margin-top: 20px; font-weight: 200">${requestScope.Message}</h4>
            </main>

            <!-- MAIN -->
        </section>

        <!-- CONTENT -->
        <script src="../js/MaketingPage.js"></script>
    </body>
</html>
