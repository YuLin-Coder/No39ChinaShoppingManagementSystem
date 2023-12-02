(function(){
	yjgCC = {
			isHideMenu:true,
			init:function(){
				var self = this;
				//追加头部
				self.appendNav();	
				//添加事件
				self.event();
			},
			/**
			 * 追加头部
			 */
			appendNav:function(){
				var user;
				$.ajax({
					type: 'POST',
					url: ctx+'/index/getSession',
					async:false,
					success:function(data){
						var data = eval('(' + data + ')'); //字符串转换成json
						user=data.User;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})						
				var html01='',html02='',html03='',html04='',html05='',html06='';
				if(user==null||user==undefined){
					html01='<nav id="top">\
						<div class="container">\
						<div class="row">\
							<div class="col-xs-6">\
							</div>\
							<div class="col-xs-6">\
								<ul class="top-link">\
									<li><a href="'+ctx+'/login">\<span class="glyphicon glyphicon-user"></span> 请登录</a></li>\
									<input type="hidden" id="DDD" value="0"></input>\
									<li><a href="'+ctx+'/login">\<span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a></li>\
									<li><a href="'+ctx+'/contact">\<span class="glyphicon glyphicon-envelope"></span> 联系我们</a></li>\
								</ul>\
							</div>\
						</div>\
						</div>\
						</nav>';
				}else{
					html01='<nav id="top">\
						<div class="container">\
						<div class="row">\
							<div class="col-xs-6">\
							</div>\
							<div class="col-xs-6">\
								<ul class="top-link">\
						  			<li>\
										<div class="dropdown">\
	                        				<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1">\
	                            				<i class="glyphicon glyphicon-user"></i>'+user.userName+'\
	                            				<i class="caret"></i>\
	                        				</a>\
					                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">\
					                            <li><a href="'+ctx+'/user">用户中心</a></li>\
					                            <li><a href="'+ctx+'/index/remSession">退出</a></li>\
					                        </ul>\
                            			</div>\
									</li>\
									<input type="hidden" id="DDD" value="1"></input>\
									<li><a href="'+ctx+'/cart">\<span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a></li>\
									<li><a href="'+ctx+'/contact">\<span class="glyphicon glyphicon-envelope"></span> 联系我们</a></li>\
								</ul>\
							</div>\
						</div>\
						</div>\
						</nav>';
				}
				html02='<header class="container">\
						<div class="row">\
							<div class="col-md-4">\
							<div id="logo"><img src="'+ctx+'/resources/images/fg/logo.png"></div>\
							</div>\
							<div class="col-md-8">\
							<form class="form-search">\
								<input type="text" class="input-medium search-query">\
								<button type="button" class="btn"><span class="searchzz">搜索</span></button>\
							</form>\
					</div>\
					</div>\
					</header>';
				html03='<nav id="menu" class="navbar">\
					<div class="container">\
					<div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>\
					<button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>\
					</div>\
					<div class="collapse navbar-collapse navbar-ex1-collapse">\
					<ul class="nav navbar-nav">';
				$.ajax({
						type: 'POST',
						url: ctx+'/index/getTitle',
						async:false,
						success:function(data){
							var data = eval('(' + data + ')'); //字符串转换成json
							var zz=data.RetData;
							for(var a=0;a<zz.length;a++){
								if(zz[a].name=='主页'){
									var html0401='<li class="dropdown" style="margin-left:30px;"><a href="'+ctx+'/index" >'+zz[a].name+'</a>';
								}else{
									var html0401='<li class="dropdown" style="margin-left:30px;"><a href="#" class="dropdown-toggle" data-toggle="dropdown">'+zz[a].name+'</a>';
								}
								var html0402='';
								var html0403='';
								var zzz=zz[a].list;
								if(zzz!=undefined&&zzz.length!=0){
									
									html0402+='<div class="dropdown-menu">\
												<div class="dropdown-inner">\
													<ul class="list-unstyled">';
									for(var b=0;b<zzz.length;b++){
										html0403+='<li style="width:100px; float:left"><a href="'+ctx+'/category?name='+zzz[b].name+'&typeDid='+zzz[b].typeDid+'">'+zzz[b].name+'</a></li>';				
									}
									html0402+=html0403;
									html0402+='</ul>\
											</div>\
										</div>\
										</li>';
								}
								html0401+=html0402;
								html04+=html0401;
							}							
						}
				})
				html05='</ul>\
					</div>\
				</div>\
			</nav>';
				html06=html01+html02+html03+html04+html05;
				$('#page-content').before(html06);
			},
			event:function(){
				$(".searchzz").on('click',function(){
					var searchZZ=$(".search-query").val();
					if(searchZZ!=null&&searchZZ.trim()!=''&&searchZZ!=undefined){
						window.location.href =ctx+'/category?name='+searchZZ;
					}
				});
			}
	};
})();
$(function(){
	yjgCC.init();
});
