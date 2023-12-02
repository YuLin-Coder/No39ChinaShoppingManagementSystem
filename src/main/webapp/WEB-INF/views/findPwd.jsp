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
	<link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
	<script src="${ctx}/resources/js/fg/findpwd.js"></script>	
</head>

<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="#">密码找回</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="xingming">
					<div class="col-md-8" style="margin-top:-68px;">
					<div class="heading" style="margin-left:-190px;margin-top:50px;font-size:22px;border-bottom:none;">请填写要找回密码的用户名:</div>
					<form class="form-horizontal">
							<div class="form-group">
								<label for="userName" class="col-md-2 control-label">用户名</label>
								<div class="col-md-5">
									<input type="text" class="form-control" id="userName" name="userName">
								</div>
							</div>			
							<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
								<button type="button" class="btn btn-1 form1">确定</button>
							</div>
					</form> 
					</div>
				</div>	
				<div class="mibao">
				<div class="col-md-8" style="margin-top:-68px;">
					<div class="heading" style="margin-left:-190px;margin-top:50px;font-size:22px;border-bottom:none;">请填写密保:</div>
					<form class="form-horizontal" name="form2">
						<div class="form-group">
							<label for="uquestion" class="col-md-2 control-label">密保问题：</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="uquestion" name="uquestion" readonly value="">
							</div>
						</div>
						<div class="form-group">
							<label for="daAn1" class="col-md-2 control-label">答案：</label>
							<div class="col-md-5">
								<input type="hidden"  id="uID" value="">
								<input type="hidden"  id="daAntrue" value="">
								<input type="text" class="form-control" id="daAn1" name="uanswer">
							</div>
						</div>				
						<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
							<button type="button" class="btn btn-1 form2">确定</button>
						</div>
					</form> 
					</div>
				</div>
				<div class="mima">
				<div class="col-md-8" style="margin-top:-68px;">
					<div class="heading" style="margin-left:-190px;margin-top:50px;font-size:22px;border-bottom:none;">请填写密码:</div>
					<form class="form-horizontal" name="form3" >
						<div class="form-group">
							<label for="passwordz" class="col-md-2 control-label">输入新密码：</label>
							<div class="col-md-5">
								<input type="password" class="form-control" id="passwordz" name="passwordz">
							</div>
						</div>				
						<div class="col-md-5 col-md-offset-3" style="margin-bottom:20px;">
							<button type="button" class="btn btn-1 form3">确定</button>
						</div>
					</form> 
					</div>
				</div>
			<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>