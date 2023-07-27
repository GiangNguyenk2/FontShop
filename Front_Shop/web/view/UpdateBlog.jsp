<%-- 
    Document   : UpdateBlog.jsp
    Created on : Jun 8, 2023, 11:26:18 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="../stylesheet/updateBlog.css">

        <title>Post Manage</title>
    </head>
    <body>
        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Front:</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="#">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Product</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxl-blogger' ></i>
                        <span class="text">Post</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-receipt'></i>
                        <span class="text">Combo</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-barcode' ></i>
                        <span class="text">Order</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class='bx bxs-user' ></i>
                        <span class="text">Customer</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                <li>
                    <a href="#">
                        <i class='bx bxs-cog' ></i>
                        <span class="text">Settings</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="logout">
                        <i class='bx bxs-log-out-circle' ></i>
                        <span class="text">Logout</span>
                    </a>
                </li>
            </ul>
        </section>
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

            <!--Main-->
            <main>
                
                <div class="head-title">
                    <div class="left">
                        <h1>Update Blog</h1>
                    </div>
                </div>
                <form action="edit" method="post">
                    <div  class="form-input" >
                    <label>ID</label>
                    <input value="${dt.postID}" name="postID" type="text" readonly required>
                 </div>   

                 <div  class="form-input" >
                    <label>Tittle</label>
                    <input value="${dt.tittle}" name="tittle" type="text" required>
                 </div>   

                 <div  class="form-input">
                    <label>Gmail</label>
                    <input value="${dt.gmail}" name="gmail" type="text" required>
                 </div> 

                   <div  class="form-input" >
                    <label>Toppic</label>
                    <select name="toppic">                            
                             <option value="News">News</option>
                             <option value="Product">Product</option>
                             <option value="Sale">Sale</option>                     
                    </select>
                 </div> 

                 <div  class="form-input">
                    <label>Image</label>
                    <input value="${dt.img}" name="image" type="file" required>
                 </div> 

                 <div  class="form-input">
                    <label>Detail</label>
                    <textarea value="${dt.detail}" name="detail" type="text" required></textarea>
                 </div> 
                 <div  class="form-input">
                    <label>Date</label>
                    <input value="${dt.dob}" name="date" type="text" required>
                 </div> 


                 <div  class="Add">                  
                    <input type="submit" value="Update">
                 </div>
                 

                </form>
            </main>
        </section>
    </body>
</html>
