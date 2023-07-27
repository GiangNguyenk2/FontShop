<%-- 
    Document   : ChangePassword
    Created on : May 21, 2023, 1:59:30 PM
    Author     : admin
--%>

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
  input, .btn {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 4px;
    margin: 5px 0;
    opacity: 0.85;
    display: inline-block;
    font-size: 17px;
    line-height: 20px;
    text-decoration: none; /* remove underline from anchors */
  }
  
  input:hover,
  .btn:hover {
    opacity: 1;
  }
  

  /* style the submit button */
  input[type=submit] {
    background-color: #000000;
    color: white;
    cursor: pointer;
    
    width: 50%;
    text-align: center;
    
  
    
  }
  
  input[type=submit]:hover {
    background-color: #323232;
  }
    </style>

    <body>

        <jsp:include page="../components/Menu.jsp"/>


        <div style="justify-content: center; display: flex">
            <form action="userInfo?" method="get">
                <input type="hidden" value="${sessionScope.account.gmail}" name="accId">
                <button type="submit" value="History" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px">History</button>
            </form>

            <form action="updateProfile" method="post">
                <button type="submit" value="" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px;margin-left: 10px">Update Profile</button>
            </form>
        </div>


        <h1 style="text-align: center; margin: 20px;">Change Password</h1>
        <div class="container" style="margin-bottom: 200px">
            <form action="changePassword" method="post">
                <div class="row" style="justify-content: center; text-align: center">
                    <div class="col" style="margin: auto; justify-content: center">

                        <p>${mess}</p>
                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="Old Password"/>
                            <jsp:param name="field" value="oldpass"/>
                        </jsp:include>

                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="New Password"/>
                            <jsp:param name="field" value="newpass"/>
                        </jsp:include>

                        <jsp:include page="../components/inputField.jsp">
                            <jsp:param name="type" value="password"/>
                            <jsp:param name="placeholder" value="RePassword"/>
                            <jsp:param name="field" value="repass"/>
                        </jsp:include>

                        <input type="submit" value="Change Password">
                    </div>  

                </div>
            </form>
        </div>
        <div class="pagination" style="margin: auto; justify-content: center; ">

        </div>
        <jsp:include page="../components/Footer.jsp"/>
    </body>

</html>

