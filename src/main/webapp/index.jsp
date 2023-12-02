<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>login</title>
    <c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
    <script type="text/javascript">var ctx="${ctx}";</script>
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
    <link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />
    <%-- <link rel="stylesheet" href="${ctx}/resources/css/public/common.css"  type="text/css"> --%>
    <script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/fg/login.js"></script>
    <%-- <script src="${ctx}/resources/js/public/common.js"></script> --%>
</head>

<body>
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="${ctx}/index">主页</a></li>
                    <li><a href="#">登录</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 " style="margin-top:-68px;">
                <img src="${ctx}/resources/images/fg/login.jpg">
            </div>
            <div class="col-md-4">
                <div class="heading"><h2>登录</h2></div>

                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" name="username" id="username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码 " name="password" id="password">
                </div>
                <div class="form-group" data-toggle="modal" data-target="#myModal" id="tsAdmin">
                    <span style="display:none;color:#a94442;" id="loginTS">用户名或密码有误,请重新输入！</span>
                </div>
                <button type="submit" class="btn btn-1" name="login" id="login" >登录</button>
                <div style="float:right;margin-top:16px;">
                    <a href="${ctx}/findpwd">忘记密码 ?</a>
                    <a href="${ctx}/register">新用户注册</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div  style="height:200px;">
                <div style="margin:60px;">您好！管理员。</div>
                <div style="margin:60px;" id="sjj">3秒后将自动跳转到后台管理页面</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>