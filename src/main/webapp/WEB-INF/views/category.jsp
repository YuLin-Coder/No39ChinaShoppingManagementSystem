<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />	
    <title>china Shop</title>
    <c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<script type="text/javascript">var ctx="${ctx}";</script>
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
	 <link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/public/jqPaginator.min.js"></script>
    <script src="${ctx}/resources/js/fg/fgtop.js"></script>
    <script src="${ctx}/resources/js/fg/category.js"></script>
</head>
<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="#">${sessionScope.name}</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-12">
					<div class="col-md-12">
						<div class="products" id="products">
						</div>
						<div id="nopd" style="text-align:center;font-size:xx-large;height:470px;display:none;">
								<p>暂时没有该物品！</p>
						</div>
						<div class="row">
						</div>
						<div class="row text-center">
							<ul class="pagination" id="pagination">
	        				</ul>
	        				<input type="hidden" id="PageCount"  value=""/>
	        				<input type="hidden" id="PageSize"  value="" />
	        				<input type="hidden" id="countindex"  value=""/>
	        				<input type="hidden" id="visiblePages" value="7" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<script src="${ctx}/resources/js/fg/fgfoot.js"></script>
</body>
</html>