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
    <link rel="stylesheet" href="${ctx}/resources/css/bg/bgstyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${ctx}/resources/ziti/fonts/font-slider.css" type="text/css">
    <link rel="shortcut icon" href="${ctx}/resources/images/public/favicon.ico" type="image/x-icon" />  
	<script src="${ctx}/resources/js/public/jquery-2.1.1.js"></script>	 
    <script src="${ctx}/resources/js/public/bootstrap.min.js"></script>
    <script src="${ctx}/resources/js/public/jqPaginator.min.js"></script>
    <script src="${ctx}/resources/js/bg/index2.js"></script>
    <script src="${ctx}/resources/js/public/jquery.form.js"></script>  	
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
		      	margin-left:50px;
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
</head>
<body>
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6" style="margin-left:-60px;">
				 <span class="brand"><span class="first">china</span> <span class="second">Shop</span></span>
				</div>
				<div class="col-xs-6" style="margin-top:20px;">
					<ul class="top-link">
						<li>欢迎你，<span class="userZZ">${sessionScope.User1.userName}</span></li>
						<li><a href="${ctx}/index/remSession">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-3">
			<div class="sidebar-nav">
		    	<a href="${ctx}/index2" class="nav-header" style="text-align:center;">首页</a>
		        <a href="#" class="nav-header" id="pzgl" style="text-align:center;">品种管理</a>
		        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse" style="text-align:center;">商品</a>
		        <ul id="dashboard-menu" class="nav nav-list collapse">
		            <li><a href="#" id="spgl" style="text-align:center;"> 陶瓷管理</a></li>
		           <!--  <li ><a href="#" id="spsh">商品审核</a></li>  -->
		        </ul>
		        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse" style="text-align:center;">用户</a>
		        <ul id="error-menu" class="nav nav-list collapse">
		            <li ><a href="#" id="glysq" style="text-align:center;">管理员授权</a></li>
		            <li ><a href="#" id="dzsh" style="text-align:center;">店主审核</a></li>
		            <li ><a href="#" id="yhgl" style="text-align:center;">用户管理</a></li>
		        </ul>
		        <a href="#" class="nav-header" id="fkxx" style="text-align:center;">反馈信息</a>
		    </div>
		</div>
		<!--首页  -->
		<div class="col-md-9" style="margin-top:80px;display:none;" id="sy">
				<p style="font-size:xx-large;">欢迎进入陶瓷商城后台管理界面!</p>
		</div>
		<!--反馈信息  -->
		<div class="col-md-8" style="margin-top:80px;margin-left:-60px;display:none;" id="fkxx2">
			<div id="fkxxW">
				<p style="font-size:xx-large;text-align:center;">暂时没有反馈信息!</p>
			</div>
			<div id="fkxxY">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>内容</th>
							<th>新增时间</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody id="fklist">
					</tbody>
				</table>
			</div>
			<div id="fkxx3" style="margin-top:-50px;">
				<div><span style="color:black;cursor: pointer;font-size:x-large;" id="fkxxfh">返回</span></div>
				<div class="xx" style="margin-top:30px;">
					<div style="float:left;height:40px;width:200px;">
						<h4>反馈用户：<span id="mUserZ"></span></h4>
					</div>
					<div style="float:left;height:40px;margin-left:500px;width:200px;">
						<h4>状态：<span id="mStatuZ"></span></h4>
					</div>
				</div>
				<div style="widrh:200;height:200px;margin-top:30px;">
						<h4>详情:</h4>
						<p id="mDetailZ" style="background-color:white;height:200px;font-size:x-large;text-align:center;margin-top:30px;padding-top:20px;"></p>
				</div>
			</div>
		</div>
		<!--管理员授权  -->
		<div class="col-md-9" style="margin-top:40px;margin-left:-40px;" id="glysq2">
			<div class="col-md-12">
				<button type="button" class="btn btn-default" id="glyzz">授权用户</button>
			</div>
			<div style="padding-top:50px;">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>加入时间</th>
							<th>授权人</th>
						</tr>
					</thead>
					<tbody id="glylist">
					</tbody>
				</table>
			</div>
		</div>
		<!--商品管理  -->
		<div class="col-md-9" style="margin-top:40px;margin-left:-40px;" id="spgl2">
			<div id="HW">
				<div class="col-md-12">
						<button type="button" class="btn btn-default" id="spQD">新增陶瓷</button>
				</div>
				<div id="exictSP" style="padding-top:50px;">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>陶瓷名</th>
								<th>陶瓷单价</th>
								<th>陶瓷数量</th>
								<th>是否折扣</th>
								<th>折扣价格</th>
								<th>陶瓷来源</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="splist">
						</tbody>
					</table>
					<div class="row text-center" id="pageSP1">
						<ul class="pagination" id="pagination1">
	       				</ul>
	       				<input type="hidden" id="PageCount1"  value=""/>
	       				<input type="hidden" id="PageSize1"  value="" />
	       				<input type="hidden" id="countindex1"  value=""/>
	       				<input type="hidden" id="visiblePages1" value="7" />
					</div>
				</div>
			</div>
		</div>
		<!--用户管理  -->
		<div class="col-md-9" style="margin-top:40px;margin-left:-40px;" id="yhgl2">
				<div><span style="color:black;cursor: pointer;font-size:large; display:none" id="yhfhzz" onclick="aa()">返回</span></div>
				<div style="padding-top:50px;">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>用户名</th>
								<th>性别</th>
								<th>电话号码</th>
								<th>用户创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="yhlist">
						</tbody>
					</table>
					<div class="row text-center" id="pageSP2">
						<ul class="pagination" id="pagination2">
	       				</ul>
	       				<input type="hidden" id="PageCount2"  value=""/>
	       				<input type="hidden" id="PageSize2"  value="" />
	       				<input type="hidden" id="countindex2"  value=""/>
	       				<input type="hidden" id="visiblePages2" value="7" />
					</div>
				</div>
		</div>
		<!--品种管理  -->
		<div class="col-md-9" style="margin-top:40px;margin-left:-40px;display:none" id="pzgl2">
				<div style="padding-top:10px;float:left;">
					<h3>主品种</h3>
					<button type="button" class="btn btn-default" id="xzPZ1">新增</button>
					<table class="table table-bordered table-hover" style="margin-top:5px;">
						<thead>
							<tr>
								<th style="width:100px;">编号</th>
								<th style="width:100px;">名称</th>
								<th style="width:100px;">创建人</th>
								<th style="width:100px;"></th>
							</tr>
						</thead>
						<tbody id="pzlist1">
						</tbody>
					</table>
				</div>
				<hr style="float:left;border-right:1px solid black;height:500px;margin-left:80px;">
				<div style="padding-top:10px;float:left;margin-left:80px;">
					<h3>子品种</h3>
					<button type="button" class="btn btn-default" id="xzPZ2">新增</button>
					<table class="table table-bordered table-hover" style="margin-top:5px;">
						<thead>
							<tr>
								<th style="width:100px;">编号</th>
								<th style="width:100px;">名称</th>
								<th style="width:100px;">创建人</th>
								<th style="width:100px;"></th>
							</tr>
						</thead>
						<tbody id="pzlist2">
						</tbody>
					</table>
				</div>
		</div>
		<!--店主审核  -->
		<div class="col-md-9" style="margin-top:40px;margin-left:-40px; dispaly:none" id="dzsh2">
				<div style="padding-top:50px;">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>用户名</th>
								<th>电话号码</th>
								<th>状态</th>
								<th>申请时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dzlist">
						</tbody>
					</table>
					<div class="row text-center" id="pageSP3">
						<ul class="pagination" id="pagination3">
	       				</ul>
	       				<input type="hidden" id="PageCount3"  value=""/>
	       				<input type="hidden" id="PageSize3"  value="" />
	       				<input type="hidden" id="countindex3"  value=""/>
	       				<input type="hidden" id="visiblePages3" value="7" />
					</div>
				</div>
		</div>
		<!-- 商品操作 -->
		<div class="col-md-9" style="margin-top:40px;display:none;" id="GOODScaoz">
				<div><span style="color:black;cursor: pointer;font-size:large;" id="spfhzz" onclick="bb()">返回</span></div>
			<div id="HWcaoz" style="margin-top:20px;margin-left:-40px;">
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
				<!-- 	<div class="form-group">
						<label for="goodsPrice" class="col-md-2 control-label">是否折扣：</label>
						<div class="col-md-9">
							<input name="ifZK" class="zkzz" type="radio" value="N" checked>否&nbsp;&nbsp;&nbsp; <input name="ifZK"  type="radio" value="Y" class="zkzz">是
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
						<textarea type="message" class="form-control" name="goodsDesc" id="goodsDesc" style="height:200px;"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-md-2 control-label">添加图片：</label>
						<div class="col-md-9">										
							<div class="m-imgWrap" id="tu1" style="margin-left:0px;">
								<div class="default">
									<span>+</span>
									<p>陶瓷图1</p>
									<input class="u-ipt-file" type="file" name="file1">
								</div>
							</div>
							<div class="m-imgWrap" id="tu2">
								<div class="default">
									<span>+</span>
									<p>陶瓷图2</p>
									<input class="u-ipt-file" type="file" name="file2">
								</div>
							</div>
							<div class="m-imgWrap" id="tu3">
								<div class="default">
									<span>+</span>
									<p>陶瓷图3</p>
									<input class="u-ipt-file" type="file" name="file3">
								</div>
							</div>
							<div class="m-imgWrap" id="tu4">
								<div class="default">
									<span>+</span>
									<p>陶瓷图4</p>
									<input class="u-ipt-file" type="file" name="file4">
								</div>
							</div>
						</div>
					</div>					
					<div class="col-md-9 col-md-offset-3" style="margin-bottom:20px;">
						<input type="hidden"  name="goodsIdZZ" id="goodsIdZZ" value="">
						<button type="button" class="btn btn-1" id="spQD11">确定</button>
						<button type="button" class="btn btn-1" style="margin-left:400px;" onclick="bb()">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<input type="hidden" data-toggle="modal" data-target="#myModal" id="dzqqq">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="height:500px;">
				<!-- <div  >
					<div style="margin:60px;" id="dzsfzhm"></div>
					<div style="margin:60px;" id="dzsfz"></div>
				</div> -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<div><h5>姓名：</h5><h4 class="modal-title" id="dzmz" >
					</h4></div>
					<div><h5>身份证号：</h5><h4 class="modal-title" id="dzsfzhm" >
					</h4></div>
				</div>
				<div class="modal-body" id="dzsfz" style="height:200px;">
					<div class="m-imgWrap">
						<div class="g-showImg">
							<img src="" id="tuZZ1"/>
						</div>
					</div>
					<div class="m-imgWrap" >
						<div class="g-showImg">
							<img src="" id="tuZZ2"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden"  name="sellerZZZ" id="sellerZZZ" value="">
					<input type="hidden"  name="sellerZZZ2" id="sellerZZZ2" value="">
					<button type="button" class="btn btn-default" id="dzsqtg">通过
					</button>
					<button type="button" class="btn btn-default" id="dzsqbtg">
						不通过
					</button>
				</div>
			</div>
		</div>
	</div>
	<!--pzaaaa1  -->
	<input type="hidden" data-toggle="modal" data-target="#myModal2" id="pzaaaa1">
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="top:10%">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title">
						主品种
					</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="pzNamezz" class="col-md-2 control-label">品种名：</label>
						<div class="col-md-6">
						<input type="text" class="form-control" name="pzNamezz" id="pzNamezz">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden"  name="pzZZZ" id="pzidZZZ" value="">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="zpzqd">确定
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消
					</button>
				</div>
			</div>
		</div>
	</div>
	<!--pzaaaa2  -->
	<input type="hidden" data-toggle="modal" data-target="#myModal3" id="pzaaaa2">
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="top:10%">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" >
						子品种
					</h4>
				</div>
				<div class="modal-body" style="height:120px;">
					<form class="form-horizontal">
					<div class="form-group">
						<label class="col-md-3 control-label">所属主品种：</label>
						<div class="col-md-6"> 
							<select class="form-control" id="pz2list">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="pz2Namezz" class="col-md-3 control-label">品种名：</label>
						<div class="col-md-6">
						<input type="text" class="form-control" name="pz2Namezz" id="pz2Namezz">
						</div>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<input type="hidden"  name="pzdZZZ" id="pzdidZZZ" value="">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="zpz2qd">确定
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消
					</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//上传图片
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
