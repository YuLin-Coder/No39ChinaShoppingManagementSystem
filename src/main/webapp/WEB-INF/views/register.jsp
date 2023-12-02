<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />	
    <title> china shop</title>
    <c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<script type="text/javascript">var ctx="${ctx}";</script>
  	<link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrapValidator.min.css" type="text/css">
	<link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/public/distpicker.data.min.js"></script>
	<script src="${ctx}/resources/js/public/distpicker.min.js"></script>
	<script src="${ctx}/resources/js/public/bootstrapValidator.min.js"></script>
	<script src="${ctx}/resources/js/fg/register.js"></script>
</head>

<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="#">注册</a></li>
					</ul>
				</div>
			</div>
			<div class="row" style="background-color:#dff0d8;">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="margin-top:-68px;">
				<div class="heading" style="margin-left:200px;"><h2>用户注册</h2></div>
				<form class="form-horizontal" name="form2" id="ff2" method="post" action="${ctx}/register/addUser">
					<div class="form-group">
						<label for="username" class="col-md-2 control-label">用户名：</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="userName" name="userName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">性别：</label>
						<div class="col-md-9">
							<input name="gender" id="gender1" type="radio" checked="true" value="M"> 男 <input name="gender" id="gender2" type="radio" value="F" style="margin-left:50px;"> 女 
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 control-label">密码：</label>
						<div class="col-md-9">
							<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="form-group">
						<label for="password_qr" class="col-md-2 control-label">确认密码：</label>
						<div class="col-md-9">
							<input type="password" class="form-control" id="password_qr" name="password_qr">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNum" class="col-md-2 control-label">手机号码：</label>
						<div class="col-md-9">
						<input type="text" class="form-control" name="phoneNum" id="phoneNum">
						</div>
					</div>
					<div class="form-group">
					   	<label for="address" class="col-md-2 control-label">地址：</label>
					   <!-- 地址联动插件 -->
					   	<div data-toggle="distpicker">
					  		<div class="col-md-3">
					  	  		<label class="sr-only" for="province">Province</label>
					  	  		<select class="form-control" id="province" name="province"></select>
					  		</div>
					  		<div class="col-md-3">
					  	  		<label class="sr-only" for="city">City</label>
					  	 		<select class="form-control" id="city" name="city"></select>
					  		</div>
					  		<div class="col-md-3">
					  	 		<label class="sr-only" for="district">District</label>
					  	 		<select class="form-control" id="district" name="district"></select>
					  		</div>
					  	</div>					 
					</div> 
					<div class="form-group">
						<div class="col-md-2"></div>
						<div class="col-md-9">
						<input type=text class="form-control" placeholder="详细地址 " name="addressD" id="addressD">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 control-label">邮箱：</label>
						<div class="col-md-9">
						<input type="text" class="form-control" name="email" id="email">
						</div>
					</div>
					<div class="form-group">
						<label for="miBao1" class="col-md-2 control-label">密保问题：</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="miBao1" name="uquestion">
						</div>
					</div>
					<div class="form-group">
						<label for="daAn1" class="col-md-2 control-label">答案：</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="daAn1" name="uanswer">
						</div>
					</div>				
					<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
						<button type="submit" class="btn btn-1">确定</button>
						<a href="${ctx}/index"><button type="button" class="btn btn-1" style="margin-left:100px;">取消</button></a>
					</div>
				</form> 
			</div>
			<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>