<%-- 
    Document   : Profile
    Created on : May 21, 2023, 1:55:35 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ShopAll</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../stylesheet/profile.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
    </head>
    <style>
        h3{
            text-align: center;
             padding-bottom: 10px;
             margin-bottom: 20px;
        }
        th ,td{
            color: white;
            text-align: left;
            padding-left: 10px;
            padding-bottom: 10px;
        }
    </style>
    <body>

        <jsp:include page="../components/Menu.jsp"/>


        <div style="justify-content: center; display: flex">
            <form action="customerOrder" method="get">
                <input type="submit" value="History" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px">
            </form>

            <form action="updateProfile" method="post">
                <input type="submit" value="Update Profile" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px;margin-left: 10px">
            </form>

            <form action="changePassword" method="get">
                <input type="submit" value="Change Password"  style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-left: 10px">
            </form>

        </div>
        <h1 style="text-align: center; margin: 20px;">Profile</h1>

        <div class="profile" style="margin-bottom: 200px">


            <div class="boxleft">
                <h3 style="">About</h3>
                <p>Name: <span> ${sessionScope.account.name}</span></p>
                <p>Gmail: <span>${sessionScope.account.gmail}</span></p>
                <p>Gender: <span>${sessionScope.account.gender?"Male":"Female"}</span></p>

            </div>

            <div class="boxright">
                <h3 style="margin-bottom: 20px; text-align: center">Address List</h3>
                <table>
                    <tr style="padding: 0" >
                        <th style="margin-bottom: 5px">Phone</th>
                        <th style="margin-bottom: 5px">Address</th>

                    </tr>
                    <c:forEach items="${listadd}" var="o">
                        <tr style="padding: 0">
                            <td style="margin-bottom: 5px">${o.phone}</td>
                            <td style="margin-bottom: 5px">${o.city}, ${o.district}, ${o.ward}, ${o.address}</td>
                        </tr>
                    </c:forEach>
                </table>



            </div>
        </div>
        <div class="pagination" style="margin: auto; justify-content: center; ">
            
        </div>
        <jsp:include page="../components/Footer.jsp"/>
    </body>

</html>
