<%@ page import="com.javaweb.demo.entity.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%
        Teacher teacher1=(Teacher)session.getAttribute("user");
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>教师界面</title>

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
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="teacher_index.jsp?">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3"> <%
                out.println(teacher1.getTname());
            %></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">




        <!-- 下学期课程 -->
        <li class="nav-item">
            <a class="nav-link" href="CourseServlet?option=ShowAllCoursesByTeacher" >
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>课程列表</span></a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>教材信息</span>
            </a>
            <div id="collapsePages" class="collapse show" aria-labelledby="headingPages" data-parent="#accordionSidebar" style="">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Textbook information:</h6>
                    <a class="collapse-item" href="BookServlet?option=ShowAllBooks">库存教材信息</a>
                    <a class="collapse-item" href="BookServlet?option=ShowAllBooksToTeacher">预定教材信息</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>订单信息</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Order information:</h6>
                    <a class="collapse-item" href="ReserveServlet?option=ShowAllReserveByTeacher">全部订单</a>
                    <a class="collapse-item" href="ReserveServlet?option=ShowAllNoReserveByTeacher">未发放订单</a>
                    <a class="collapse-item" href="ReserveServlet?option=ShowAllYesReserveByTeacher">已发放订单</a>
                </div>
            </div>
        </li>

        </li>
        <!-- 教师信息 -->
        <li class="nav-item">
            <a class="nav-link" href="teacher_modify_info.jsp?">
                <i class="fas fa-fw fa-table"></i>
                <span>我的信息</span></a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>修改信息</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Modify information:</h6>
                    <a class="collapse-item" href="teacher_update_info.jsp?">修改个人信息</a>
                    <a class="collapse-item" href="teacher_update_pwd.jsp?">修改个人密码</a>
                </div>
            </div>
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
                <form action="BookServlet"
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2" name="info">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                                <button>查询信息</button>
                                <input style="display:none" name="option" value="FindTeacherBook">
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
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
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%
                                out.println(teacher1.getTname());
                            %></span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_rocket.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="teacher_modify_info.jsp?">
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


            <!-- Begin Page Content -->
            <div class="container-fluid">
                <div class="layui-body layui-bg-gray" style="padding: 10px">
                    <!-- 内容主体区域 -->
                    <div class="container-fluid">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h3 class="m-0 font-weight-bold text-primary">我的教材信息</h3>
                                <c:if test="${msg != null}">
                                    <a href="#" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                                        <span class="text"> ${msg}</span>
                                    </a>
                                </c:if>
                                <c:if test="${msg1 != null}">
                                    <a href="#" class="btn btn-danger btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-exclamation-triangle"></i>
                                        </span>
                                        <span class="text">${msg1}</span>
                                    </a>
                                </c:if>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th>所属课程号</th>
                                            <th>所属课程名</th>
                                            <th>学习班级</th>
                                            <th>教材号</th>
                                            <th>教材名</th>
                                            <th>作者</th>
                                            <th>出版社</th>
                                            <th>版次</th>
                                            <th>价格</th>
                                            <th>删除教材</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${books}" var="book">
                                            <tr>
                                                <th>${book.course.cno}</th>
                                                <th>${book.course.cname}</th>
                                                <th>${book.course.mno}</th>
                                                <th>${book.bno}</th>
                                                <th>${book.bname}</th>
                                                <th>${book.bauthor}</th>
                                                <th>${book.bsource}</th>
                                                <th>${book.bedition}</th>
                                                <th>${book.bprice}</th>
<%--                                                <th>--%>
<%--                                                    <a onclick="update('${book.bname}','${book.bauthor}','${book.bsource}','${book.bedition}','${book.bprice}','${book.bno}')" class="btn btn-info btn-icon-split">--%>
<%--                                                        <span class="icon text-white-50">--%>
<%--                                                            <i class="fas fa-info-circle"></i>--%>
<%--                                                        </span>--%>
<%--                                                    </a>--%>
<%--                                                </th>--%>
                                                <th>
                                                    <a onclick="confirmDel(${book.bno},${book.course.cno},${book.course.CCmno})" class="btn btn-danger btn-icon-split">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-trash"></i>
                                                        </span>
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

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">准备离开？</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">如果你准备退出，请点击“退出”</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
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
<script src="js/jquery-1.11.0.min.js"></script>
<script src="./layui/layui.js"></script>
<script>
    function confirmDel(param1,param2,param3) {
        if (window.confirm("您确定要删除该教材吗")) {
            document.location = "BookServlet?option=DeleteBookByTeacher&Bno=" + param1+"&CCno="+param2+"&CCmno="+param3;
        }
    }

    function update(bookName, bookAuthor, bookSource, bookEdition, bookPrice, bookBno,) {
        layer.open({
            type: 1,
            title: '修改教材',
            content: '<div style="padding: 20px"><form class="layui-form layui-form-pane" action="BookServlet">\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">书名</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="Bname" required lay-verify="required" value="' + bookName + '" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">作者</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="Bauthor" required lay-verify="required" value="' + bookAuthor + '" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">出版社</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="Bsource" required lay-verify="required" value="' + bookSource + '" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">版次</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="Bedition" required lay-verify="required" value="' + bookEdition + '" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">价格</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="Bprice" required lay-verify="required" value="' + bookPrice + '" autocomplete="off" class="layui-input">\n' +
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
                ' <input style="display: none" type="text" name="Bno" value="' + bookBno + '" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                ' <input style="display: none" type="text" name="option" value="updateBook" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </form> </div>'
        });
    }


    $(function () {
        $("#btn_find").click(function () {
            layer.open({
                title: '查询教材',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="BookServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="FindAllBook">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教材号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bno"    placeholder=""  autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教材名</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bname"    placeholder=""  autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">作者</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bauthor"   placeholder=""  autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">出版社</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bsource"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">版次</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bedition"   placeholder="" autocomplete="off" class="layui-input">\n' +
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

</body>

</html>