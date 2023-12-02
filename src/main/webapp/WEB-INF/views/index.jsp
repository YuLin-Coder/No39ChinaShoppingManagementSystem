<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>china shop</title>
    <c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<script type="text/javascript">var ctx="${ctx}";</script>
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
	<link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/fg/fgtop.js"></script>
     <script src="${ctx}/resources/js/fg/index.js"></script>
</head>

<body>
	<div id="page-content" class="home-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img src="${ctx}/resources/images/fg/main-banner11-1903x600.jpg" alt="First slide">
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div>
							</div>
							<div class="item">
								<img src="${ctx}/resources/images/fg/main-banner22-1903x600.jpg" alt="Second slide">
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div>
							</div>
							<div class="item">
								<img src="${ctx}/resources/images/fg/main-banner33-1903x600.jpg" alt="Third slide">
								<div class="header-text hidden-xs">
									<div class="col-md-12 text-center">
									</div>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="banner">
					<div class="col-sm-4">
						<%-- <img src="${ctx}/resources/images/fg/sub-banner1.png" /> --%>
						<img src="${ctx}/resources/images/fg/20161010141657_0742.jpg" />
					</div>
					<div class="col-sm-4">
						<img src="${ctx}/resources/images/fg/20170420152343_1718.jpg" />
					</div>
					<div class="col-sm-4">
						<img src="${ctx}/resources/images/fg/20170510105448_0162.jpg" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading"><h2>最新产品</h2></div>
					<div class="products" id="newProducts">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="banner">
					<div class="col-sm-6">
						<img src="${ctx}/resources/images/fg/zzz1.gif" />
					</div>
					<div class="col-sm-6">
						<img src="${ctx}/resources/images/fg/zzz2.gif" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading"><h2>折扣产品</h2></div>
					<div class="products" id="zkProducts">
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctx}/resources/js/fg/fgfoot.js"></script>
</body>
</html>
