<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <link rel="stylesheet" href="css/a..css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="screen" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <!-- Start Sign In Form -->
            <form action="LoginServlet" class="animate-box" data-animate-effect="fadeIn" style="width:950px">
                <div id="login-box">
                    <h1>Sign IN</h1>
                    <c:if test="${msg != null}">
                    <a href="#" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                        <span class="text"> ${msg}</span>
                    </a>
                    </c:if>
                    <c:if test="${msg1 != null}">
                    <a href="#" class="btn btn-danger btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                        <span class="text">${msg1}</span>
                    </a>
                    </c:if>
                    <div class="form">
                        <i class="fa fa-male"></i>
                        <select class="item1" name="type" style="opacity:0.4">
                            <option value ="manager" style="background-color: #c8daee">管理员</option>
                            <option value ="teacher" style="background-color: #c8daee">教师</option>
                            <option value ="monitor" style="background-color: #c8daee">班长</option>
                        </select>
                    </div>
                    <div class="item">
                        <label for="username" class="sr-only">Username</label>
                        <i class="fa fa-user-circle-o" ></i>
                        <input type="text" name="username" class="form-control" id="username" placeholder="用户名" autocomplete="off">
                    </div>
                    <div class="item">
                        <label for="password" class="sr-only">Password</label>
                        <i class="fa fa-key" ></i>
                        <input type="password" name="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
                    </div>
                    <p>还没注册? <a href="manager_teacher_add.jsp">注册</a>
                        <input style="display: none" type="text" name="option" value="signIn">
                    <div class="item">
                        <input type="submit" value="登录" class="btn btn-primary" >
                    </div>
                    <div class="form-group">
                    </div>
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>
</div>
<!-- jQuery -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
