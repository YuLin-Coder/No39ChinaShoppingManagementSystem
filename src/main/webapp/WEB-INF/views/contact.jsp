<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Mobile Shop</title>
    <c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<script type="text/javascript">var ctx="${ctx}";</script>
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
	<link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/fg/contact.js"></script>
</head>

<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="${ctx}/contact">联系我们</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading"><h1>联系我们</h1></div>
				</div>
				<div class="col-md-6" style="margin-bottom: 30px;">
					<form name="form1" id="ff" >
						<div class="form-group">
							<input type="text" class="form-control" placeholder="姓名 *" name="mName" id="mName" >
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="邮箱 *" name="mEmail" id="mEmail" >
						</div>
						<div class="form-group">
							<input type="tel" class="form-control" placeholder="电话 *" name="mPhone" id="mPhone">
						</div>
						<div class="form-group">
							<textarea class="form-control" placeholder="留言 *" name="mDetail" id="mDetail"></textarea>
						</div>
						<div class="form-group" data-toggle="modal" data-target="#myModal" id="zzz">
							<span style="display:none;color:#a94442;" id="contactTX">请完整填写！</span>
						</div>
						<button type="button" class="btn btn-1" id="confirmM">确认</button>
					</form>
				</div>
				<div class="col-md-2">
				</div>
				<div class="col-md-4" style="margin-top:120px;">
					<p><span class="glyphicon glyphicon-home"></span> NanChang, JiangXi 6408</p>
					<p><span class="glyphicon glyphicon-earphone"></span> +13970004564</p>
					<p><span class="glyphicon glyphicon-envelope"></span> koshiroy@gmail.com</p>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div  style="height:200px;">
					<div style="margin:60px;">感谢您的建议，我们将尽快改善</div>
					<div style="margin-top:30px; margin-left:380px;">
							<button type="button" class="btn btn-default"><a href="${ctx}/index">返回主页</a></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
