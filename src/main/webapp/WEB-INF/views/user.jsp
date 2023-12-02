<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;utf-8">
	<title>china Shop</title>
  	<c:set  var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<script type="text/javascript">var ctx="${ctx}";</script>
    <link rel="stylesheet" href="${ctx}/resources/css/public/bootstrap.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/css/fg/fgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
	<link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<style type="text/css">
		.default{
			    border: 1px dashed #ccc;
			 	line-height: 100px;
				text-align: center;
			 	background: #fff;
			 	width: 140px;
			 	height: 100px;
			 	cursor: pointer;
			 	position: relative;
			 	color: #ccc;
		}
		.m-imgWrap{
		      	margin-left:100px;
		      	margin-top:50px;
		      	float:left;
		}
		.m-imgWrap .default p{
		      	position: absolute;
			    top: 0;
			    width: 100%;
			    height: 100%;
			    font-size: 16px;
			    -moz-box-sizing: border-box;
			    box-sizing: border-box;
			    text-align: center;
			    padding-top: 30px;
		}
		 .m-imgWrap .default input{
		   	    opacity: 0;
			    position: absolute;
			    width: 100%;
			    height: 100%;
			    top: 0;
			    left: 0;
			    z-index: 1;
			    cursor: pointer;
		}
		.m-imgWrap .g-showImg {
			  width: 140px;
			  height: 100px;
			  border: 1px solid #e2e2e2;
		}
		.m-imgWrap .g-showImg img {
		  width: 100%;
		  height: 100%;
		  display: block;
		}
		.m-imgWrap .g-showImg .u-close {
		  position: absolute;
		  width: 17px;
		  height: 17px;
		  background: url(resources/images/public/close1.png) no-repeat 0 0;
		  cursor: pointer;
		}
		.m-imgWrap .g-showImg:hover {
		  border: 1px solid #2D77C1;
		}
    </style>
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/public/distpicker.data.min.js"></script>
	<script src="${ctx}/resources/js/public/distpicker.min.js"></script>
	<script src="${ctx}/resources/js/public/bootstrapValidator.min.js"></script>
	<script src="${ctx}/resources/js/fg/user.js"></script>
	<script src="${ctx}/resources/js/public/jquery.form.js"></script> 
</head>
<body>
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
				</div>
				<div class="col-xs-6">
					<ul class="top-link">
			  			<li>
							<div class="dropdown">
	                     				<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1">
	                         				<i class="glyphicon glyphicon-user"></i>${sessionScope.User.userName}
	                         				<i class="caret"></i>
	                     				</a>
		                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
		                            <li><a href="#">用户中心</a></li>
		                            <li><a href="${ctx}/index/remSession">退出</a></li>
		                        </ul>
	                        </div>
						</li>
						<li><a href="${ctx}/cart"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a></li>
						<li><a href="${ctx}/contact"><span class="glyphicon glyphicon-envelope"></span> 联系我们</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<nav id="menu" class="navbar">
		<div class="container" >
			<a href="${ctx}/index" style="color:#fff;font-size:xx-large;margin-left:-60px;">chinaShop</a>
			<img alt="" src="">
		</div>
	</nav>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="tabbable" id="tabs-665358">
					<div style="float:left">
					<ul class=""><!--nav nav-tabs  -->
						<li  class="active">
							 <a href="#panel-740095" data-toggle="tab"></a>
						</li>
						<li>
							 <a href="#panel-936340" data-toggle="tab" id="myCollect">我的收藏</a>
						</li>
						<li >
							 <a href="#panel-936342" data-toggle="tab" id="xgUser">修改资料</a>
						</li>
						<li >
							 <a href="#panel-936343" data-toggle="tab" id="dzsq">商品出售</a>
						</li>
						<li >
							 <a href="#panel-936344" data-toggle="tab" id="mmxg">密码修改</a>
						</li>
					</ul>
					</div>
					<div class="tab-content" style="margin-left:100px;float:left;width:900px;height:auto;"> 
						<div class="tab-pane active" id="panel-740095">
							<p>
								欢迎进入个人中心！
							</p>
						</div>
						<div class="tab-pane " id="panel-936340">
							<div id="noSC" style="text-align:center;font-size:xx-large;height:470px;display:none;">
								<p>您还没有任何收藏！</p>
							</div>
							<div id="exictSC">
							</div>
						</div>
						<div class="tab-pane " id="panel-936342">
								<form class="form-horizontal" name="form2" id="ff2" method="post">
									<div class="form-group">
										<label for="username" class="col-md-2 control-label">用户名：</label>
										<div class="col-md-9">
											<input type="text" class="form-control" id="userName" name="userName" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">性别：</label>
										<div class="col-md-9">
											<input name="gender" id="gender1" type="radio" checked="true" value="M"> 男 <input name="gender" id="gender2" type="radio" value="F" style="margin-left:50px;"> 女 
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
									   	<div data-toggle="distpicker" id="aaaa">
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
									<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
										<button type="button" class="btn btn-1" id="upUser">确定</button>
										<a href="${ctx}/user"><button type="button" class="btn btn-1" style="margin-left:100px;">取消</button></a>
									</div>
								</form> 
						</div>
						<div class="tab-pane " id="panel-936343">
							<div id="SQ" style="display:none;">
								<p>
									需要进行身份审核,请您如实认真填写：
								</p>
								<form class="form-horizontal" id="ff3" method="POST" enctype="multipart/form-data">
									<div class="form-group">
										<label for="tUserName" class="col-md-2 control-label">真实姓名：</label>
										<div class="col-md-9">
											<input type="text" class="form-control" id="tUserName" name="tUserName">
										</div>
									</div>
									<div class="form-group">
										<label for="tPhoneNum" class="col-md-2 control-label">手机号码：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="tPhoneNum" id="tPhoneNum">
										</div>
									</div>
									<div class="form-group">
										<label for="tIdCard" class="col-md-2 control-label">身份证号：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="tIdCard" id="tIdCard">
										</div>
									</div>
									<div class="form-group">
										<label for="tEmail" class="col-md-2 control-label">邮箱：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="tEmail" id="tEmail" >
										</div>
									</div>
									<div class="form-group">
										<label  class="col-md-2 control-label">添加证件：</label>
										<div class="col-md-9">										
											<div class="m-imgWrap" id="sfzzz">
												<div class="default">
													<span>+</span>
													<p>身份证正面</p>
													<input class="u-ipt-file" type="file" name="file1">
												</div>
											</div>
											<div class="m-imgWrap" id="sfzff">
												<div class="default">
													<span>+</span>
													<p>身份证反面</p>
													<input class="u-ipt-file" type="file" name="file2">
												</div>
											</div>
										</div>
									</div>					
									<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
										<button type="button" class="btn btn-1" id="sellerQD">确定</button>
										<a href="${ctx}/user"><button type="button" class="btn btn-1" style="margin-left:100px;">取消</button></a>
									</div>
								</form>
							</div>
							<div id="SH" style="text-align:center;font-size:xx-large;height:470px;display:none;">
								<p>正在审核中,请耐心等待。</p>
							</div>
							<div id="HW" style="display:none;">
								<div class="col-md-12" style="margin-bottom:20px;">
										<button type="button" class="btn btn-default" id="spQD">新增陶瓷</button>
								</div>
								<div id="noSP" style="text-align:center;font-size:xx-large;height:470px;padding-top:100px;">
									<p>您还没有任何在售陶瓷商品！</p>
								</div>
								<div id="exictSP" style="padding-top:100px;">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>陶瓷名</th>
												<th>陶瓷单价</th>
												<th>陶瓷数量</th>
												<th>是否折扣</th>
												<th>折扣价格</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="splist">
										</tbody>
									</table>
								</div>
							</div>
							<div id="HWcaoz" style="display:none;">
								<form class="form-horizontal" id="ff4" method="POST" enctype="multipart/form-data">
									<div class="form-group">
										<label for="goodsName" class="col-md-2 control-label">陶瓷名：</label>
										<div class="col-md-9">
											<input type="text" class="form-control" id="goodsName" name="goodsName">
										</div>
									</div>
									<div class="form-group">
									 	<label class="col-md-2 control-label">陶瓷种类：</label>
										<div class="col-md-9"> 
										  <select class="form-control" id="pzlist" name="pzName">
										  </select>
										 </div>
									</div>
									<div class="form-group">
										<label for="goodsPrice" class="col-md-2 control-label">陶瓷单价：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="goodsPrice" id="goodsPrice">
										</div>
									</div>
									<!-- <div class="form-group">
										<label for="goodsPrice" class="col-md-2 control-label">是否折扣：</label>
										<div class="col-md-9">
											<input type="radio" name="ifZK" class="zkzz" value="N" checked="checked">否&nbsp;&nbsp;&nbsp; <input type="radio" name="ifZK" value="Y" class="zkzz">是
										</div>
									</div> -->
									<div class="form-group" id="zkjg">
										<label for="goodsPriceZ" class="col-md-2 control-label">陶瓷折扣价：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="goodsPriceZ" id="goodsPriceZ">
										</div>
									</div>
									<div class="form-group">
										<label for="goodsNum" class="col-md-2 control-label">陶瓷数量：</label>
										<div class="col-md-9">
										<input type="text" class="form-control" name="goodsNum" id="goodsNum">
										</div>
									</div>
									<div class="form-group">
										<label for="goodsDesc" class="col-md-2 control-label">描述：</label>
										<div class="col-md-9">
										<textarea type="message" class="form-control" name="goodsDesc" id="goodsDesc"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label  class="col-md-2 control-label">添加图片：</label>
										<div class="col-md-9">										
											<div class="m-imgWrap" id="tu1">
												<div class="default">
													<span>+</span>
													<p>商品图1</p>
													<input class="u-ipt-file" type="file" name="file1">
												</div>
											</div>
											<div class="m-imgWrap" id="tu2">
												<div class="default">
													<span>+</span>
													<p>商品图2</p>
													<input class="u-ipt-file" type="file" name="file2">
												</div>
											</div>
											<div class="m-imgWrap" id="tu3">
												<div class="default">
													<span>+</span>
													<p>商品图3</p>
													<input class="u-ipt-file" type="file" name="file3">
												</div>
											</div>
											<div class="m-imgWrap" id="tu4">
												<div class="default">
													<span>+</span>
													<p>商品图4</p>
													<input class="u-ipt-file" type="file" name="file4">
												</div>
											</div>
										</div>
									</div>					
									<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
										<input type="hidden"  name="goodsIdZZ" id="goodsIdZZ" >
										<button type="button" class="btn btn-1" id="spQD11" style="margin-left:40px;">确定</button>
										<a href="${ctx}/user"><button type="button" class="btn btn-1" style="margin-left:150px;">取消</button></a>
									</div>
								</form>
							</div>
						</div>
						<div class="tab-pane " id="panel-936344">
							<div id="noMB" style="text-align:center;font-size:xx-large;height:470px;padding-top:100px;">
								<form class="form-horizontal" id="ff5" method="POST" enctype="multipart/form-data">
									<div class="form-group" style="font-size:20px;">
										<label for="passwordold" class="col-md-4 control-label" >旧密码：</label>
										<div class="col-md-6">
										<input type="password" class="form-control" name="passwordold" id="passwordold">
										</div>
									</div>
									<div class="form-group" style="font-size:20px;">
										<label for="passwordnew" class="col-md-4 control-label" >新密码：</label>
										<div class="col-md-6">
										<input type="password" class="form-control" name="passwordnew" id="passwordnew">
										</div>
									</div>
									<div class="form-group" style="font-size:20px;">
										<label for="passwordnew2" class="col-md-4 control-label" >确认密码：</label>
										<div class="col-md-6">
										<input type="password" class="form-control" name="passwordnew2" id="passwordnew2">
										</div>
									</div>
									<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
										<button type="button" class="btn btn-1" id="passwordQD">确定</button>
										<a href="${ctx}/user"><button type="button" class="btn btn-1" style="margin-left:100px;">取消</button></a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//上传身份证
			$('.m-imgWrap .u-ipt-file').change(function(){
				var $this = $(this);
				var fileList = this.files[0];
				if (fileList == undefined){
					return;
				} 
				var reader = new FileReader();
				reader.onload = function(){
				var $imgWrap = $($this.closest('.m-imgWrap'));
		 		var showImg = "<div class='g-showImg'>"+
			 						"<i class='u-close' style='display:none;'></i>"+
									"<img src='"+this.result+"'/>"+
								"</div>";
	 			$imgWrap.find('.g-showImg').css('display','none');
	 			$imgWrap.find('.default').css('display','none');
				$imgWrap.append(showImg);
				}
				reader.readAsDataURL(fileList);
			}); 
		}); 
	</script>
</body>
</html>