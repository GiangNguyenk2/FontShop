<%-- 
    Document   : BlogDetail
    Created on : May 24, 2023, 4:58:10 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Details</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link href="../stylesheet/blogDetail.css" rel="stylesheet"/>
    <link
        href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
        rel="stylesheet"> 
</head>

<body>
    
    <jsp:include page="../components/Menu.jsp"/>
    
    <div style="justify-content: center; margin-top:40px;">
         <h2  style="text-align: center">${dt.tittle}</h2>
        <div style="text-align: center; width: 70%; margin: auto">
            
            
            <div style="">
                <a style="margin: auto"><img src="../${dt.img}" alt="abc" style="width:70%; margin: auto; border-radius: 20px"/></a>
            </div>
           
            <div style="display: flex; justify-content: space-between;  width: 70%; margin: auto">
                <div style="width: 40%">
                    <p style="width:70%; font-size: 20px; float: left; text-align: left">${dt.dob}</p>
                </div>
                <div style="width: 60%">
                    <p style="width:70%; font-size: 20px; float: right;text-align: right">${dt.gmail}</p>
                </div>
                
                
                
            </div>
            
            <div style="">
                
                <p style="margin: auto;width:70%; font-size: 20px; text-align: left">${dt.detail}</p>
                
            </div>
            
        
    </div>
    
        
    </div> 
       
            <jsp:include page="../components/Footer.jsp"/>
    
</html>
