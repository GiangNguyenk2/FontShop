<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="../stylesheet/AddBlog.css">

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

            <!--Main-->
            <main>


                <div class="head-title">
                    <div class="left">
                        <h1>Add New Blog</h1>
                    </div>
                </div>
                <div>
                    <form action="add" method="post" >

                        <div class="form-input">
                            <label>Tittle</label>
                            <input name="tittle" type="text" required>
                        </div>   

                        <div class="form-input">
                            <label>Gmail</label>
                            <input name="gmail" type="text" required>
                        </div> 

                        <div class="form-input">
                            <label>Toppic</label>
                            <select name="toppic">                            
                                <option value="News">News</option>
                                <option value="Product">Product</option>
                                <option value="Sale">Sale</option>                     
                            </select>
                        </div> 

                        <div class="form-input">
                            <label>Image</label>
                            <input name="image" type="file" required>
                        </div> 

                        <div class="form-input">
                            <label>Detail</label>
                            <textarea name="detail" type="text" required></textarea>
                        </div> 
                        <div class="form-input">
                            <label>Date</label>
                            <input type="date" name="date">
                        </div> 

                        <div class="Add" >
                            <input type="submit" value="ADD"> 

                        </div>

                    </form>
                </div>               
            </main>
        </section>
    </body>
</html>