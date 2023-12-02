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
    <script src="${ctx}/resources/js/fg/fgtop.js"></script> 
    <script src="${ctx}/resources/js/fg/product.js"></script>
    <style type="text/css">
		.rating span{
			float:left;
			padding-left:10px;
		}
    </style>
</head>
<body>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/index">主页</a></li>
						<li><a href="" id="typeNamez"></a></li>
						<li><a href="#" id="goodsNamez"></a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-12">
					<div class="product">
						<div class="col-md-6">
							<div class="image">
								<div style="margin-left:15px;"><img class="goodsUrl" src="" /></div>
								<div class="image-more">
									 <ul class="row">
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive goodsUrl0" src=""></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive goodsUrl1" src=""></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive goodsUrl2" src=""></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive goodsUrl3" src=""></a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="caption">
								<div class="name"><h3 id="goodsName"></h3></div>
								<div class="info">
									<ul>
										<li>来源:<span id="goodsFrom"></span></li>
										<li>所属类型: <span id="goodsType"></span></li>
										<li>上架时间: <span id="goodsCreatT"></span></li>
										<input class="goodsIdzzz" type="hidden" value="">	
									</ul>
								</div>
								<div class="price" id="goodsPrice"></div>
								<div class="well"><label>数量: </label> <input class="form-inline quantity" type="text" value="1"><div class="btn btn-2 " id="jiaru">加入购物车</div></div>
								<div class="share well">
									<strong style="margin-right: 13px;">分享 :</strong>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-twitter"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-facebook"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-linkedin"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>	
					<div class="product-desc">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#description">陶瓷详情</a></li>
							<li><a href="#review">留言</a></li>
						</ul>
						<div class="tab-content">
							<div id="description" class="tab-pane fade in active">
								<h4>陶瓷介绍</h4>
								<p><span id="goodsDesc"></span></p>
								<h4>买家评价</h4>
								<div id="noMessage" style="text-align:center;">
									暂时没有评价！
								</div>
								<div id="messageZZ">
							<!-- 		<div>
										<span>用户：111111</span>
										<span style="margin-left:80px;">满意度：111111</span>
										<div >
											评价：aaaaaaaaaaaaaaaaaaaaaaa
										</div>
									</div>
									<div style="margin-top:20px;">
										<span>用户：111111</span>
										<span style="margin-left:80px;">满意度：111111</span>
										<div>
											评价：aaaaaaaaaaaaaaaaaaaaaaa
										</div>
									</div> -->
								</div>
								
							</div>
							<div id="review" class="tab-pane fade">
							  <div class="review-form">
								<h4>感谢您的填写！</h4>
								<form >
									<label>
									<span>满意度:</span>
									<div class="rating"><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span></div>
									</label>
									<br>
									<label>
									<span style="margin-left:5px;">评价:</span>
									<textarea name="message" id="messagez"></textarea>
									</label>
<!-- 									<div class="form-group">
										<div class="col-md-6">
											<input name="nim" id="nim" type="checkbox"> 匿名
										</div>
									</div> -->
									<div class="text-right">
										<input class="btn btn-default" type="button" name="msTJ" value="确定" id="msTJ">
									</div>
								</form>
							  </div>
							</div>
						</div>
					</div>
					<div class="product-related">
						<div class="heading"><h2>相似陶瓷</h2></div>
						<div class="products" id="xsProducts">
						</div>
						<div id="noxs" style="text-align:center;font-size:xx-large;height:470px;display:none;">
								<p>没有同一类型陶瓷物品</p>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<script src="${ctx}/resources/js/fg/fgfoot.js"></script>	
	<!-- IMG-thumb -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">         
          <div class="modal-body">            
          </div>
        </div>
      </div>
    </div>
</body>
</html>
