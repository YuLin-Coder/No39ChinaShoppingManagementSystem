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
    <script src="${ctx}/resources/js/fg/fgtop.js"></script>
    <script src="${ctx}/resources/js/fg/cart.js"></script>	
</head>
<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row" id="cartList">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="${ctx}/cart">购物车</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="product well" style="text-align:center;display:none;height:200px;font-size:x-large;" id="cartTS">
					购物车还是空的！
					<div class="clear"></div>
				</div>	
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-8 ">
					<center><a href="${ctx}/index" class="btn btn-1" id="fanHui"></a></center>
				</div>
			</div>
			<div class="row">
				<div class="pricedetails">
					<div class="col-md-4 col-md-offset-8">
						<table>
							<h6>价格详情</h6>
							<tr>
								<td>总价</td>
								<td id="nzkPrice"></td>
							</tr>
							<tr>
								<td>折扣</td>
								<td id="zprice"></td>
							</tr>
							<tr style="border-top: 1px solid #333">
								<td><h5>折扣后总价</h5></td>
								<td id="zkPrice"></td>
							</tr>
						</table>
						<center><span class="btn btn-1" id="checkGoods">结算</span></center>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<script src="${ctx}/resources/js/fg/fgfoot.js"></script>
</body>
</html>
