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

    <title>管理员界面</title>

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

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"  action="MonitorServlet">
                    <div class="input-group">
                        <input type="text"  name="allMessage" class="form-control bg-light border-0 small" placeholder="输入班级信息..."
                               autocomplete="off" aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button lay-submit lay-filter="formDemo" class="btn btn-primary" type="submit">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                    <input style="display: none" type="text" name="option" value="FindMonitorByAllMessage">
                </form>



                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
<%--                        <!-- Dropdown - Messages -->--%>
<%--                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"--%>
<%--                             aria-labelledby="searchDropdown">--%>
<%--                            <form class="form-inline mr-auto w-100 navbar-search">--%>
<%--                                <div class="input-group">--%>
<%--                                    <input name='option' value='FindTeacher' type="text" class="form-control bg-light border-0 small"--%>
<%--                                           placeholder="输入教师信息..." aria-label="Search"--%>
<%--                                           aria-describedby="basic-addon2">--%>
<%--                                    <div class="input-group-append">--%>
<%--                                        <button class="btn btn-primary" type="button">--%>
<%--                                            <i class="fas fa-search fa-sm"></i>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </form>--%>
<%--                        </div>--%>
                        <!-- 搜索栏，搜索班级所有信息 -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"  action="MonitorServlet">
                                <div class="input-group">
                                    <input name='option' value='FindMonitorByAllMessage' type="text" class="form-control bg-light border-0 small"
                                           placeholder="输入班级信息..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="submit">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>


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


                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">         班级信息</h1>
                    <button class="btn btn-primary dropdown-toggle" type="button"
                            id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" style="float:right">
                        增加班级
                    </button>
                </div>



                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">班级列表</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>班号</th>
                                    <th>年级</th>
                                    <th>系别</th>
                                    <th>专业</th>
                                    <th>人数</th>
                                    <th>密码</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${monitors}" var="cls">
                                    <tr>
                                        <th>${cls.cno}</th>
                                        <th>${cls.cgrade}</th>
                                        <th>${cls.cdept}</th>
                                        <th>${cls.cmajor}</th>
                                        <th>${cls.cnum}</th>
                                        <th>${cls.password}</th>
                                        <th>
                                            <a onclick="update('${cls.cno}','${cls.cgrade}','${cls.cdept}','${cls.cmajor}','${cls.cnum}','${cls.password}')" class="btn btn-info btn-circle">
                                                <i class="fas fa-info-circle"></i>
                                            </a>

                                            <a onclick="confirmDel(${cls.cno})" class="btn btn-danger btn-circle">
                                                <i class="fas fa-trash"></i>
                                            </a>
                                        </th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>







                    </div>




            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

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





</div>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="./layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('form', function(){
        var form = layui.form;
    });
    function confirmDel(Cno) {
        if (window.confirm("您确定要删除这条记录吗")) {
            document.location = "MonitorServlet?option=deleteMonitor&id="+Cno;
        }
    }
     function update(Cno,Cgrade,Cdept,Cmajor,Cnum,Password) {
        layer.open({
                            type: 1,
                            title:'修改班级',
                            content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="MonitorServlet">\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">班号</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="Cno" value="'+Cno+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">年级</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="Cgrade" value="'+Cgrade+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" ">\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">院系</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="Cdept" value="'+Cdept+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">专业</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="Cmajor" value="'+Cmajor+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">人数</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="Cnum" value="'+Cnum+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item" pane>\n' +
                                '                    <label class="layui-form-label">密码</label>\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <input type="text" name="password" value="'+Password+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item">\n' +
                                '                    <div class="layui-input-block">\n' +
                                '                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                                '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '                <div class="layui-form-item">\n' +
                                '                    <div class="layui-input-block">\n' +
                                // ' <input style="display: none" type="text" name="Cno" value="'+Cno+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                                ' <input style="display: none" type="text" name="option" value="updateMonitor" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '            </form> </div>'
                        });
    }


     $(function () {
        $("#dropdownMenuButton").click(function () {
            layer.open({
                title:'增加班级',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="MonitorServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="addMonitor">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">班号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cno" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">年级</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cgrade" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">院系</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cdept" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">专业</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cmajor" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">人数</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cnum" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">密码</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="password" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                    '                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </form>' //这里content是一个普通的String
            });
        })
    })
    $(function () {
        $("#btn_add1").click(function () {
            layer.open({
                title:'查询班级',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="MonitorServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="FindMonitorByCno">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">班号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cno"  values=""  placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">年级</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cgrade"  values=""  placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">院系</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cdept"   placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">专业</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cmajor"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">人数</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Cnum"   placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                    '                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </form>' //这里content是一个普通的String
            });
        })
    })


</script>
<%--</body>--%>
<%--</html>--%>





</body>

</html>
