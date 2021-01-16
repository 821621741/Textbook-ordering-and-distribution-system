<%@ page import="com.javaweb.demo.entity.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>教材订购可视化</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="manager_index.jsp?">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">
                <%
                    HttpSession session1 = request.getSession();
                    Admin user1 = (Admin) session1.getAttribute("user");
                    out.println(user1.getMname());
                %>
            </div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">



        <!-- 库存教材信息 -->
        <li class="nav-item">
            <a class="nav-link" href="BookServlet?option=showAllBooks">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>库存教材信息</span></a>
        </li>



        <!-- 课程信息 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="CourseServlet?option=showAllCourses">
                <i class="fas fa-fw fa-cog"></i>
                <span>课程信息</span>
            </a>
        </li>

        <!-- 教师信息 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="TeacherServlet?option=showAllTeachers" >
                <i class="fas fa-fw fa-wrench"></i>
                <span>教师信息</span>
            </a>
        </li>

        <!-- 班级信息 -->
        <li class="nav-item">
            <a class="nav-link" href="MonitorServlet?option=showAllMonitor" >
                <i class="fas fa-fw fa-folder"></i>
                <span>班级信息</span>
            </a>
        </li>

        <!-- 订单信息 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>订单信息</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">订单信息:</h6>
                    <a class="collapse-item" href="ReserveServlet?option=showReserveManagernotissue">未处理订单</a>
                    <a class="collapse-item" href="ReserveServlet?option=showReserveManagerissued">已处理订单</a>
                    <a class="collapse-item" href="ReserveServlet?option=show">数据可视化</a>
                </div>
            </div>
        </li>

        <!-- 管理员 -->
        <li class="nav-item">
            <a class="nav-link" href="manager_modify_info.jsp?">
                <i class="fas fa-fw fa-table"></i>
                <span>修改信息</span></a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="manager-modify-pwd.jsp?">
                <i class="fas fa-fw fa-table"></i>
                <span>修改密码</span></a>
        </li>




        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
<%--                <form--%>
<%--                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">--%>
<%--                    <div class="input-group">--%>
<%--                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."--%>
<%--                               aria-label="Search" aria-describedby="basic-addon2">--%>
<%--                        <div class="input-group-append">--%>
<%--                            <button class="btn btn-primary" type="button">--%>
<%--                                <i class="fas fa-search fa-sm"></i>--%>
<%--                            </button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

<%--                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->--%>
<%--                    <li class="nav-item dropdown no-arrow d-sm-none">--%>
<%--                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"--%>
<%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            <i class="fas fa-search fa-fw"></i>--%>
<%--                        </a>--%>
<%--                        <!-- Dropdown - Messages -->--%>
<%--                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"--%>
<%--                             aria-labelledby="searchDropdown">--%>
<%--                            <form class="form-inline mr-auto w-100 navbar-search">--%>
<%--                                <div class="input-group">--%>
<%--                                    <input type="text" class="form-control bg-light border-0 small"--%>
<%--                                           placeholder="Search for..." aria-label="Search"--%>
<%--                                           aria-describedby="basic-addon2">--%>
<%--                                    <div class="input-group-append">--%>
<%--                                        <button class="btn btn-primary" type="button">--%>
<%--                                            <i class="fas fa-search fa-sm"></i>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                    </li>--%>


                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                <%
                                    HttpSession session2 = request.getSession();
                                    Admin user2 = (Admin) session2.getAttribute("user");
                                    out.println(user2.getMname());
                                %>
                            </span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                个人信息
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                退出
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">订单情况</h1>
                </div>

                <!-- Content Row -->
                <div class="row">


                    <!-- Pending Requests Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-warning shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                            订单数目
                                        </div>
<%--                                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"  action="BookServlet">--%>
<%--                                        <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>--%>
                                        <form action="ReserveServlet" method="post">
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                <%=session1.getAttribute("reserve_num")%>
<%--                                                <%--%>
<%--                                                    HttpSession session1 = request.getSession();--%>
<%--                                                    Admin user1 = (Admin) session1.getAttribute("user");--%>
<%--                                                    out.println(user1.getMname());--%>
<%--                                                %>--%>
                                            </div>
                                        </form>

<%--                                        </form>--%>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-comments fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            预定书籍总数</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800"><%=session1.getAttribute("reserve_book_num")%></div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>





                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            教材订单总金额</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">￥<%=session1.getAttribute("total_price")%></div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>






                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-info shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">订单完成度
                                        </div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%=session1.getAttribute("complete_degree")%>%</div>
                                            </div>
                                            <div class="col">
                                                <div class="progress progress-sm mr-2">
                                                    <div class="progress-bar bg-info" role="progressbar"
<%--                                                         下面这个百分制是控制图的--%>
                                                         style="width: <%=session1.getAttribute("complete_degree")%>%" aria-valuenow="50" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

                <!-- Content Row -->

                <div class="row">

                    <!-- Area Chart -->
                    <div class="col-xl-8 col-lg-7">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary">各学年教材订单数量情况</h6>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                         aria-labelledby="dropdownMenuLink">
                                        <div class="dropdown-header">Dropdown Header:</div>
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <div class="chart-area">
<%--                                    <canvas id="myAreaChart"></canvas>--%>
                                    <div id="container" style="height: 100%"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Pie Chart -->
                    <div class="col-xl-4 col-lg-5">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary">各价格区间教材占比</h6>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink1"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                         aria-labelledby="dropdownMenuLink">
                                        <div class="dropdown-header">Dropdown Header:</div>
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <div class="chart-pie pt-4 pb-2">
                                    <canvas id="myPieChart"></canvas>
                                </div>
                                <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> 0~30
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> 30~60
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle" style="color:#36b9cc"></i> >=60
                                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Content Row -->
                <div class="row"></div>

                <!-- Content Column -->
                <div class="col-lg-6 mb-4"></div>

            </div>
        </div>
    </div>
</div>
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- 退出 -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">准备离开</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">如果您准备退出，请在下面选择“退出”。.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="sign-in.jsp?">退出</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<%--<script src="js/demo/chart-pie-demo.js"></script>--%>

<script>
    // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#858796';

    // Pie Chart Example
    var ctx = document.getElementById("myPieChart");
    var myPieChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ["0-30", "30-60",">=60"],
            datasets: [{
                data: [<%=session1.getAttribute("price30")%> , <%=session1.getAttribute("price3060")%>, <%=session1.getAttribute("price60")%>],
                backgroundColor: ['#4e73df', '#1cc88a','#36b9cc'],
                hoverBackgroundColor: ['#2e59d9', '#17a673','#2c9faf'],
                hoverBorderColor: "rgba(234, 236, 244, 1)",
            }],
        },
        options: {
            maintainAspectRatio: false,
            tooltips: {
                backgroundColor: "rgb(255,255,255)",
                bodyFontColor: "#858796",
                borderColor: '#dddfeb',
                borderWidth: 1,
                xPadding: 15,
                yPadding: 15,
                displayColors: false,
                caretPadding: 10,
            },
            legend: {
                display: false
            },
            cutoutPercentage: 80,
        },
    });

</script>




<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/echarts.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-gl@1/dist/echarts-gl.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-stat@1/dist/ecStat.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/dataTool.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/china.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/world.js"></script>
<!-- <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=xfhhaTThl11qYVrqLZii6w8qE5ggnhrY&__ec_v__=20190126"></script> -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/bmap.min.js"></script>
<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    // Generate data
    var category = ["2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"];
    var dottedBase = +new Date();
    var lineData =
        [<%=session1.getAttribute("not_issue0")%>,
            <%=session1.getAttribute("not_issue1")%>,
            <%=session1.getAttribute("not_issue2")%>,
            <%=session1.getAttribute("not_issue3")%>,
            <%=session1.getAttribute("not_issue4")%>,
            <%=session1.getAttribute("not_issue5")%>,
            <%=session1.getAttribute("not_issue6")%>,
            <%=session1.getAttribute("not_issue7")%>,
            <%=session1.getAttribute("not_issue8")%>,
            <%=session1.getAttribute("not_issue9")%>,
        ];
    var barData =
        [<%=session1.getAttribute("year0")%>,
            <%=session1.getAttribute("year1")%>,
            <%=session1.getAttribute("year2")%>,
            <%=session1.getAttribute("year3")%>,
            <%=session1.getAttribute("year4")%>,
            <%=session1.getAttribute("year5")%>,
            <%=session1.getAttribute("year6")%>,
            <%=session1.getAttribute("year7")%>,
            <%=session1.getAttribute("year8")%>,
            <%=session1.getAttribute("year9")%>,
        ];


    // for (var i = 0; i < 10; i++) {
    //     var date = new Date(dottedBase += 3600 * 24 * 1000);
    //     // category.push([
    //     //     date.getFullYear(),
    //     //     date.getMonth() + 1,
    //     //     date.getDate()
    //     // ].join('-'));
    //     var b = Math.random() * 200;
    //     var d = Math.random() * 200;
    //     barData.push(b)
    //     lineData.push(d);
    // }


    // option
    option = {
        backgroundColor: '#ffffff',
    // #0f375f
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['已发放', '未发放'],
            textStyle: {
                color: '#ccc'
            }
        },
        xAxis: {
            data: category,
            axisLine: {
                lineStyle: {
                    color: '#ccc'
                }
            }
        },
        yAxis: {
            splitLine: {show: false},
            axisLine: {
                lineStyle: {
                    color: '#ccc'
                }
            }
        },
        series: [{
            name: 'line',
            type: 'line',
            smooth: true,
            showAllSymbol: true,
            symbol: 'emptyCircle',
            symbolSize: 15,
            data: lineData
        }, {
            name: 'bar',
            type: 'bar',
            barWidth: 10,
            itemStyle: {
                barBorderRadius: 5,
                color: new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#14c8d4'},
                        {offset: 1, color: '#43eec6'}
                    ]
                )
            },
            data: barData
        }, {
            name: 'line',
            type: 'bar',
            barGap: '-100%',
            barWidth: 10,
            itemStyle: {
                color: new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: 'rgba(20,200,212,0.5)'},
                        {offset: 0.2, color: 'rgba(20,200,212,0.2)'},
                        {offset: 1, color: 'rgba(20,200,212,0)'}
                    ]
                )
            },
            z: -12,
            data: lineData
        }, {
            name: 'dotted',
            type: 'pictorialBar',
            symbol: 'rect',
            itemStyle: {
                color: '#ffffff'
            },
            symbolRepeat: true,
            symbolSize: [12, 4],
            symbolMargin: 1,
            z: -10,
            data: lineData
        }]
    };;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

</body>

</html>

