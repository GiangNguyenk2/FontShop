<%-- 
    Document   : Admin
    Created on : May 20, 2023, 3:44:21 PM
    Author     : dinhd513
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link href="../stylesheet/admin.css" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.3/apexcharts.min.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://cdn.jsdelivr.net/npm/apexcharts@3.27.1/dist/apexcharts.min.js"></script>

        <title>Admin</title>
    </head>
    <body> 
        <!-- SIDEBAR -->    
        <jsp:include page="../components/MenuBar_Manage.jsp">
            <jsp:param name="active1" value="active"/>
            <jsp:param name="hrefAdmin" value="../view/AdminDashboard?table=product"/>
            <jsp:param name="hrefShopInfo" value="../view/ShopInfomation"/>
            <jsp:param name="hrefOrder" value="../view/managerorder?table=all&filter=new&page=1"/>
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
                        <h1>Admin Dashboard</h1>
                    </div>
                </div>

                <ul class="box-info" style="margin-bottom: 50px;">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="text">
                            <h3>${requestScope.totalProduct}</h3>
                            <p>Product</p>
                        </span>
                    </li>

                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="text">
                            <h3>${requestScope.totalOrder}</h3>
                            <p>Order</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="text">
                            <h3>${requestScope.totalRevenue} VND</h3>
                            <p>Revenue</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="text">
                            <h3>${requestScope.totalStock}</h3>
                            <p>Stock</p>
                        </span>
                    </li>
                </ul>
                <form action="../view/AdminDashboard" method="GET" style="margin-bottom: 20px">
                    <label for="year" style="display: inline-block;margin-right: 10px;">Select Year:</label>
                    <select name="year" id="year" style=" padding: 5px;font-size: 14px;border-radius: 4px;">
                        <c:forEach var="i" items="${years}">
                            <option ${requestScope.year==i?"selected":""} value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" style="background-color: black; padding: 5px; color: white; cursor: pointer">Confirm</button>
                </form>
                <div class="charts">

                    <div class="charts-card">
                        <p class="chart-title">Total amount by month</p>
                        <div id="bar-chart"></div>
                    </div>

                    <div class="charts-card">
                        <p class="chart-title">Purchase and Sales Orders</p>
                        <div id="area-chart"></div>
                    </div>

                </div>       
            </main>
            <!-- MAIN -->
        </section>

        <!-- CONTENT -->


        <script src="../js/MaketingPage.js"></script>

        <script type="text/javascript">




// ---------- CHARTS ----------

// BAR CHART
            var totalMoneyMap = {
            <c:forEach var="entry" items="${totalMoneyMap}">
                "${entry.key}": ${entry.value},
            </c:forEach>
            };
            // Tạo mảng categories và mảng data từ totalMoneyMap
            var categories = Object.keys(totalMoneyMap);
            var data = Object.values(totalMoneyMap);
            var barChartOptions = {
                series: [{
                        data: data
                    }],
                chart: {
                    type: 'bar',
                    height: 350,
                    toolbar: {
                        show: false
                    },
                },
                colors: [
                    "#246dec",
                    "#cc3c43",
                    "#367952",
                    "#f5b74f",
                    "#4f35a1"
                ],
                plotOptions: {
                    bar: {
                        distributed: true,
                        borderRadius: 4,
                        horizontal: false,
                        columnWidth: '40%',
                    }
                },
                dataLabels: {
                    enabled: false
                },
                legend: {
                    show: false
                },
                xaxis: {
                    categories: categories,
                    title: {
                        text: 'Month'
                    }
                },
                yaxis: {
                    title: {
                        text: "Total Money"
                    }
                }
            };
            var barChart = new ApexCharts(document.querySelector("#bar-chart"), barChartOptions);
            barChart.render();
// AREA CHART

            // Lấy danh sách orderCounts từ attribute
            var orderCounts = ${orderCounts};

            var totalOrders = [];
            var salesOrders = [];

            for (var i = 0; i < orderCounts.length; i += 2) {
                totalOrders.push(orderCounts[i]);
                salesOrders.push(orderCounts[i + 1]);
            }

            var labels = [];
            for (var i = 0; i < totalOrders.length; i++) {
                if (totalOrders[i] > 0 || salesOrders[i] > 0) {
                    labels.push("Month " + (i + 1));
                }
            }

            var areaChartOptions = {
                series: [{
                        name: 'Purchase Orders',
                        data: totalOrders
                    }, {
                        name: 'Sales Orders',
                        data: salesOrders
                    }],
                chart: {
                    height: 350,
                    type: 'area',
                    toolbar: {
                        show: false,
                    },
                },
                colors: ["#4f35a1", "#246dec"],
                dataLabels: {
                    enabled: false,
                },
                stroke: {
                    curve: 'smooth'
                },
                labels: labels,
                markers: {
                    size: 0
                },
                yaxis: [
                    {
                        title: {
                            text: 'Purchase Orders',
                        },
                    },
                    {
                        opposite: true,
                        title: {
                            text: 'Sales Orders',
                        },
                    },
                ],
                tooltip: {
                    shared: true,
                    intersect: false,
                }
            };
            var areaChart = new ApexCharts(document.querySelector("#area-chart"), areaChartOptions);
            areaChart.render();
        </script>
    </body>
</html>

